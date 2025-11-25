package org.example.securitymaster.service;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.RoleDao;
import org.example.securitymaster.dao.UserDao;
import org.example.securitymaster.security.Role;
import org.example.securitymaster.security.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public String register(User user,String roles){
        if(roles.contains(",")){
            String[] rolesArray=roles.split(",");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            for(String role:rolesArray){
                var role1=new Role();
                role1.setRoleName(role);
                user.addRole(roleDao.save(role1));
            }
            userDao.save(user);
            return "Successfully Register!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role=new Role();
        role.setRoleName(roles);
        user.addRole(role);
        roleDao.save(role);
        userDao.save(user);
        return "Successfully register!";
    }

}
