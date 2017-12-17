package com.gestion.marchant.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;





import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.gestion.marchant.entities.role;
@Entity
@Table(name="users")
public class utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	@NotEmpty(message="Please enter your name.")
	private String userName;
	@NotEmpty(message="Please enter your password.")
	private String password;
	@NotEmpty(message="Please Re-enter your password.")
	private String confirmPassword;
	@Email(message="your E-mail is incorrect")
	@NotEmpty(message="Please enter your E-mail.")
	private String email;
	@NotEmpty(message="Please enter the name of your country.")
	private String country;
	@NotEmpty(message="Please enter the name of your city.")
	private String city;
	@NotNull(message="Please enter your phonenumber")
	private Long phoneNumber;
	private boolean activated;
	@OneToMany
	@JoinColumn(name="idUtilisateur")
	private Collection<role> roles;
	
 	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public utilisateur(String userName, String password,String confirmPassword,String email, String country,String city,
			Long phoneNumber, boolean activated, Collection<role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword=confirmPassword;
		this.email=email;
		this.country=country;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.activated = activated;
		this.roles = roles;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public Collection<role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<role> roles) {
		this.roles = roles;
	}
}
