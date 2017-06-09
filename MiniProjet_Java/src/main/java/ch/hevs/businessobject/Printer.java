package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Printer")
public class Printer extends Device {

	@Column(name="color")
	private boolean color;
	@Column(name="scan")
	private boolean scan;

	
	
	
	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public boolean isScan() {
		return scan;
	}

	public void setScan(boolean scan) {
		this.scan = scan;
	}

	public Printer(){
		super();
	}
	
	public Printer(boolean color, boolean scan){
		super();
		this.color = color;
		this.scan = scan;
	}
	
}

