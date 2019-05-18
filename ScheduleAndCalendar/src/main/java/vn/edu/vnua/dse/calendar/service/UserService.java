package vn.edu.vnua.dse.calendar.service;

import vn.edu.vnua.dse.calendar.model.User;

public interface UserService {
	public void init(User user);
	
	public void setRole(User user, String role);
	
	public void save(User user);
	
	public User findByEmail(String email);

	public User findByConfirmToken(String resetToken);
	
	
}
