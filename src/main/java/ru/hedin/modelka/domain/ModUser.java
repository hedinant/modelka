package ru.hedin.modelka.domain;

import org.springframework.security.core.GrantedAuthority;
import ru.hedin.modelka.security.UserRole;

import javax.persistence.*;
import java.util.*;
import org.apache.commons.lang3.EnumUtils;

@Entity
@Table(name = "mod_user")

public class ModUser {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="modelPKgen", sequenceName="MODEL_C_MODEL_seq")
    @GeneratedValue(generator="modelPKgen", strategy= GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false, unique = true )
    private String userName;
    @Column (nullable = false, unique = true )
    private String password;
    @Column (nullable = false )
    private long longRoles = 1; //ROLE_USER
    @Transient
    private Set<UserRole> roles;
//    @Bean
//    public ModUser() {
//    }


    public long getLongRoles() {
        return longRoles;
    }

    public void setLongRoles(long longRoles) {
        this.longRoles = longRoles;
    }
    //calculation of longRoles
    public void setLongRoles(Set<UserRole> roleSet) {

        longRoles = EnumUtils.generateBitVector(UserRole.class,roles);

    }

    public  Set<UserRole>  getRoles() {

        return EnumUtils.processBitVector(UserRole.class,longRoles);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public String getLogin() {return  userName;}

    public void setUserName(String login) {
        this.userName = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
