package vn.edu.vnua.dse.calendar.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String email, String password);
    
    boolean hasRole(String role);
}
