package temp;

import ru.hedin.modelka.security.UserRole;

import java.util.Set;

//тут сущность из БД к примеру
// TODO replace with modelka user
public class User {
    private String login;
    private String password;
    private Set<UserRole> roles;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
