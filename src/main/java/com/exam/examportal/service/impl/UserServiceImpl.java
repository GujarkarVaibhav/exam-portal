package com.exam.examportal.service.impl;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.repo.RoleRepository;
import com.exam.examportal.repo.UserRepository;
import com.exam.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository ;

    @Autowired
    RoleRepository roleRepository ;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername()) ;

        if(local!= null){
            System.out.println("User already present");
            throw new Exception("User already present") ;
        }
        else{
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole()) ;
            }
            user.getUserRoles().addAll(userRoles) ;
            local = this.userRepository.save(user) ;

        }
        return local;
    }
}
