package ru.hedin.modelka.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hedin.modelka.service.UserRepository;

@Service
public class RegistrationService {
   @Autowired
    private UserRepository userRepository;
 //   private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public boolean creteUser (ModUser modUser){

        // User to save to database via repository @link
 //       ModUser user2Save = new ModUser();
//        user2Save.setUserName(modUser.getUserName());
        //need encoder done
//        BCryptPasswordEncoder enc = new BCryptPasswordEncoder(12);
//        String encpass = enc.encode(modUser.getPassword());
 //       user2Save.setPassword(modUser.getPassword());
        //need to set Roles and maybe something else


        if (userRepository.saveUser(modUser)) {
            return true;
        }
        return false;
    }
}
