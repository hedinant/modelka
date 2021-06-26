package ru.hedin.modelka.security;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PermissionVoter implements AccessDecisionVoter<MethodInvocation> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute instanceof SecurityAttribute;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MethodInvocation.class.isAssignableFrom(clazz);
    }

    @Override
    public int vote(Authentication authentication, MethodInvocation object, Collection<ConfigAttribute> attributes) {
            Optional<SecurityAttribute> securityAttribute = attributes.stream()
                    .filter(attr -> attr instanceof SecurityAttribute)
                    .map(SecurityAttribute.class::cast)
                    .findFirst();
            if (!securityAttribute.isPresent()) {
                    return AccessDecisionVoter.ACCESS_ABSTAIN;
            }

            Collection<UserRole> authorities = (Collection<UserRole>) authentication.getAuthorities();
            for (ConfigAttribute attribute : attributes) {
                    if (attribute instanceof SecurityAttribute) {
                            List<UserRole> userRoles = ((SecurityAttribute) attribute).getRoles();
                            if (userRoles != null && !userRoles.isEmpty() && CollectionUtils.containsAny(userRoles, authorities)) {
                                    return AccessDecisionVoter.ACCESS_GRANTED;
                            }
                    }
            }
        return AccessDecisionVoter.ACCESS_DENIED;
    }
}
