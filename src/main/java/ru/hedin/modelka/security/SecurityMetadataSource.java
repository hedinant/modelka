package ru.hedin.modelka.security;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SecurityMetadataSource extends AbstractMethodSecurityMetadataSource {
    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> aClass) {
        HasUserRoles userRoles = findAnnotation(method, aClass);
        if (userRoles == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new SecurityAttribute(Arrays.asList(userRoles.value())));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    private HasUserRoles findAnnotation(Method method, Class<?> targetClass) {
        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        HasUserRoles annotation = AnnotationUtils.findAnnotation(specificMethod, HasUserRoles.class);

        if (annotation != null) {
            return annotation;
        }

        if (specificMethod != method) {
            annotation = AnnotationUtils.findAnnotation(method, HasUserRoles.class);
            if (annotation != null) {
                return annotation;
            }
        }

        return AnnotationUtils.findAnnotation(specificMethod.getDeclaringClass(), HasUserRoles.class);
    }
}
