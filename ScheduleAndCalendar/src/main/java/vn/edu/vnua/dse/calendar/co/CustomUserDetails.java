package vn.edu.vnua.dse.calendar.co;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import vn.edu.vnua.dse.calendar.model.Role;
import vn.edu.vnua.dse.calendar.model.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public CustomUserDetails(final User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return user.getEmail();
	}
	public String getRefreshToken() {
		return user.getRefreshToken();
	}
	
	public void setRefreshToken(String refreshToken) {
		this.user.setRefreshToken(refreshToken);
	}
	
	public String getFullName() {
		return user.getLastName() + " " + user.getLastName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		Set<String> roleNames = new HashSet<>();

		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			roleNames.add(role.getName());
		}
		
		for (String roleName : roleNames) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roleName));
		}
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user == null ? null : user.getPassword();
	}

	@Override
	public String getUsername() {
		return user == null ? null : user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}