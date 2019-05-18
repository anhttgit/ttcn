package vn.edu.vnua.dse.calendar.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vn.edu.vnua.dse.calendar.common.AppConstant;
import vn.edu.vnua.dse.calendar.model.Role;
import vn.edu.vnua.dse.calendar.model.User;
import vn.edu.vnua.dse.calendar.repository.RoleRepository;
import vn.edu.vnua.dse.calendar.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
	public void init(User user) {
		//endcode
//    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//    	user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(11)));
    	encode(user);
    	setRole(user, AppConstant.ROLE_USER);
//        //set role user
//        Set<Role> roles = new HashSet<Role>();
//        roles.add(roleRepository.findByName("ROLE_USER"));
//        user.setRoles(roles);
        
        userRepository.save(user);
	}
    
    public void setRole(User user, String role) {
    	Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName(role));
        user.setRoles(roles);
    }
    
	private void encode(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(11)));
	}
    
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
		return userRepository.findByEmail(email);
    }
    
	@Override
	public User findByConfirmToken(String resetToken) {
		return userRepository.findByConfirmToken(resetToken);
	}

	

	

}
