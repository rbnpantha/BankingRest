package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

 
@Entity(name = "CREDENTIALS")
public class UserCredentials {

	 @Id
	 @Column(nullable = false, unique = true)
 	String username;
	 @Column(nullable = false)
	String password;
	String verifyPassword;
	Boolean enabled;

	@OneToOne(mappedBy="userCredentials", cascade = CascadeType.PERSIST) 
 	@JsonManagedReference
	private User member;
	

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="credentials_id") 
	List<Authority> authority = new ArrayList<Authority>();

 	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public List<Authority> getAuthority() {
		return authority;
	}
	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	public User getMember() {
		return member;
	}
	public void setMember(User member) {
		this.member = member;
	}
 
 	
}
