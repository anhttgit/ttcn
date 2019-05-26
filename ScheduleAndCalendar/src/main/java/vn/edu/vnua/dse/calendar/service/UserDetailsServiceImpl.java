package vn.edu.vnua.dse.calendar.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.vnua.dse.calendar.co.CustomUserDetails;
import vn.edu.vnua.dse.calendar.model.Role;
import vn.edu.vnua.dse.calendar.model.User;
import vn.edu.vnua.dse.calendar.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new CustomUserDetails(user);
    }
    
    
    public static String getRefreshToken() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getRefreshToken();
		} else {
			return null;
		}
    }
    
    public static User getUser() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getUser();
		} else {
			return null;
		}
    }
}
