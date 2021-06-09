package ru.hedin.modelka.domain;

import javax.persistence.*;

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
    private String password;
   private long longRoles = 1; //ROLE_USER
//    @Bean
//    public ModUser() {
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

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
