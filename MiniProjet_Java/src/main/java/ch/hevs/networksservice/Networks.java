package ch.hevs.networksservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Computer;
import ch.hevs.businessobject.Device;
import ch.hevs.businessobject.Network;
import ch.hevs.businessobject.Printer;
import ch.hevs.businessobject.User;

@Local
public interface Networks {

	//Ramener chaque objet
	Computer getComputer (long id);
	Network getNetwork(long id);
	Printer getPrinter(long id);
	User getUser(long id);
	
	//Ramener des listes d'objets
	public List<Device> getDevicesByUserList(long id);
	public List<Device> getDevicesByNetworkList(long id);
	public List<Network> getNetworksByUserList(long id);
	public Network getNetworkByDevice(long id);
	public List<User> getUsersByDeviceList(long id);
	public List<User> getUsersByNetworkList(long id);
	
	//Ajout des méthodes d'insertion
}
