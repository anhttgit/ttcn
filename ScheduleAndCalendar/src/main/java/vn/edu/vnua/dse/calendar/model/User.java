package vn.edu.vnua.dse.calendar.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	private Date createDate;
	
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	private boolean enabled;
	
	private String confirmToken;
	
	private String resetToken;
	
	private String refreshToken;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Calendar> calendars;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getConfirmToken() {
		return confirmToken;
	}

	public void setConfirmToken(String confirmToken) {
		this.confirmToken = confirmToken;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Calendar> getCalendars() {
		return calendars;
	}

	public void setCalendars(Set<Calendar> calendars) {
		this.calendars = calendars;
	}

	
	

}