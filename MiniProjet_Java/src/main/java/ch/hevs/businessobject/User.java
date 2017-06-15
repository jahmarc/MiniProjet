package ch.hevs.businessobject;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="mail")
	private String mail;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	//Relations
	@ManyToMany
	private List<Device> devices;
	
	public List<Device> getDevices(){
		return devices;
	}
	
	public void setDevices(List<Device> devices){
		this.devices = devices;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
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

	// constructors
			public User() {
			}
			
			public User(String firstname,String lastname, String mail, String username, String password) {
				this.firstname = firstname;
				this.lastname = lastname;
				this.mail = mail;
				this.username = username;
				this.password = password;
			}

}
