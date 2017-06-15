package ch.hevs.businessobject;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="Device")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="Type")
	private String type;
	@Column(name="place")
	private String place;
	@Column(name="name")
	private String name;
	@Column(name="brand")
	private String brand;
	@Column(name="sn")
	private String sn;
	@Column(name="ip")
	private String ip;
	
	//Relations
	@ManyToOne
	private Network network;
	
	@ManyToMany(mappedBy="devices")
	private List<User> users;
	
	public List<User> getUsers(){
		return users;
	}
	
	public void setUsers(List<User> users){
		this.users = users;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	
	
	public Device(){
		
	}
	
	public Device(String type, String place, String name, String brand, String sn, String ip){
		this.type = type;
		this.place = place;
		this.name = name;
		this.brand = brand;
		this.sn = sn;
		this.ip = ip;
	}

	
	@Override
	public String toString() {
		String result = id + "-" + type + "-" + place + "-" + name + "-" + brand + "-" + sn + "-" + ip ;
		return result;
	}

}
