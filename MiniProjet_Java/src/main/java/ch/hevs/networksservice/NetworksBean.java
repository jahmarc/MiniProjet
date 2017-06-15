package ch.hevs.networksservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Computer;
import ch.hevs.businessobject.Device;
import ch.hevs.businessobject.Network;
import ch.hevs.businessobject.Printer;
import ch.hevs.businessobject.User;

public class NetworksBean implements Networks {

	@PersistenceContext(name = "NetworksPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Override
	public Computer getComputer(long id) {
		Query query = em.createQuery("FROM Computer c WHERE c.id=:id");
		query.setParameter("id", id);
		
		Computer computer = (Computer) query.getSingleResult();
		System.out.println("ID Computer called from getComputer(): "+computer.getId());
		return computer;
	}
	
	@Override
	public Device getDevice(long id) {
		Query query = em.createQuery("FROM Device c WHERE c.id=:id");
		query.setParameter("id", id);
		
		Device device = (Device) query.getSingleResult();
		System.out.println("ID Computer called from getComputer(): "+device.getId());
		return device;
	}

	@Override
	public Network getNetwork(long id) {
		Query query = em.createQuery("FROM Network n WHERE n.id=:id");
		query.setParameter("id", id);
		
		Network network = (Network) query.getSingleResult();
		System.out.println("ID Network called from getNetwork(): "+network.getId());
		return network;
	}

	@Override
	public Printer getPrinter(long id) {
		Query query = em.createQuery("FROM Printer p WHERE p.id=:id");
		query.setParameter("id", id);
		
		Printer printer = (Printer) query.getSingleResult();
		System.out.println("ID Printer called from getPrinter(): "+printer.getId());
		return printer;
	}

	@Override
	public User getUser(long id) {
		Query query = em.createQuery("FROM User u WHERE u.id=:id");
		query.setParameter("id", id);
		
		User user = (User) query.getSingleResult();
		System.out.println("ID User called from getUser(): "+user.getId());
		return user;
	}


	@Override
	public List<Device> getDevicesByUserList(long id) {
		return (List<Device>) em.createQuery("SELECT u.devices FROM User u where u.id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Device> getDevicesByNetworkList(long id) {
		return (List<Device>) em.createQuery("SELECT n.devices FROM Network n where n.id=:id").setParameter("id", id).getResultList();
	}


	@Override
	public List<Network> getNetworksByUserList(long id) {
		return (List<Network>) em.createQuery("SELECT u.networks FROM User u where u.id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public Network getNetworkByDevice(long id) {
		return (Network) em.createQuery("SELECT d.network FROM Device d where d.id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<User> getUsersByDeviceList(long id) {
		return (List<User>) em.createQuery("SELECT d.users FROM Device d where d.id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<User> getUsersByNetworkList(long id) {
		return (List<User>) em.createQuery("SELECT n.users FROM Network n where n.id=:id").setParameter("id", id).getResultList();
	}

	@Override
	public List<Device> getDevices() {
		return em.createQuery("FROM Device").getResultList();
	}

	@Override
	public List<Network> getNetworks() {
		return em.createQuery("FROM Network").getResultList();
	}

	@Override
	public List<User> getUsers() {
		return em.createQuery("FROM User").getResultList();
	}

}
