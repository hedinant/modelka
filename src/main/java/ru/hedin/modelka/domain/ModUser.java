package ru.hedin.modelka.domain;

import org.springframework.security.core.GrantedAuthority;
import ru.hedin.modelka.security.UserRole;

import javax.persistence.*;
import java.util.*;

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
        longRoles=0;
        roles.forEach( (rol)->{
            longRoles+= (long) Math.pow(2,rol.ordinal());
        });

    }

    public  Set<UserRole>  getRoles() {
            long tempLongRoles = longRoles;


            if (roles== null) { roles = new HashSet<UserRole>(); }
            roles.add(UserRole.ROLE_USER);
            tempLongRoles-=1;
            
            while (tempLongRoles>0) {
                if (tempLongRoles>=4) {
                    tempLongRoles-=4;
                    roles.add(UserRole.ROLE_GM);
                }
                if (tempLongRoles>=2) {
                    tempLongRoles-=2;
                    roles.add(UserRole.ROLE_ADMIN);
                }
            }


        return roles;
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
