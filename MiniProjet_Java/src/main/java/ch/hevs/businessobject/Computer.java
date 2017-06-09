package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Computer")
public class Computer extends Device {
	
	@Column(name="os")
	private String os;
	@Column(name="model")
	private String model;
	@Column(name="processor")
	private String processor;
	@Column(name="ram")
	private String ram;
	
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
		// Constructors
		public Computer() {
			super();
		}
		public Computer(String os, String model, String processor, String ram) {
			super();
			this.os = os;
			this.model = model;
			this.processor = processor;
			this.ram = ram;
		}

}
