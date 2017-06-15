package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Network")
public class Network {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="network")
	private String network;
	@Column(name="mask")
	private String mask;
	@Column(name="externalip")
	private String externalip;
	@Column(name="type")
	private String type;
	
	
	//Relations
	@OneToMany(mappedBy="network")
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public String getExternalip() {
		return externalip;
	}
	public void setExternalip(String externalip) {
		this.externalip = externalip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	// constructors
		public Network() {
		}
		
		public Network(String name, String network, String mask, String externalip, String type) {
			this.name = name;
			this.network = network;
			this.mask = mask;
			this.externalip = externalip;
			this.type = type;
		}

		@Override
		public String toString() {
			String result = id + "-" + name + "-" + network + "-" + mask + "-" + externalip + "-" + type;
			return result;
		}
		
}
