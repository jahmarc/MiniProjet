package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Device;
import ch.hevs.businessobject.Network;
import ch.hevs.businessobject.User;
import ch.hevs.networksservice.Networks;

public class MappingBean {
	
	private Networks net;
	
	private List<Network> networks;
	private List<Device> devices;
	private List<User> users;
	
	private List<String> networkNames;
	private List<String> deviceNames;
	private List<String> userNames;
	
	private Network network;
	private List<Network> networks_user;
	private List<User> users_device;
	private List<User> users_network;
	private List<Device> devices_user;
	private List<Device> devices_network;
	
	private String NetworkName;
	private String UserName;
	private String DeviceName;
	
	@PostConstruct
	public void initialize() throws NamingException {
		// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		net = (Networks) ctx.lookup("java:global/MiniProjet_Java/NetworksBean!ch.hevs.networksservice.Networks");
	
		List<Network> networksList = net.getNetworks();
		this.networkNames = new ArrayList<String>();
		for (Network network : networksList) {
			this.networkNames.add(network.getName());
		}
		
		List<Device> devicesList = net.getDevices();
		this.deviceNames = new ArrayList<String>();
		for (Device device : devicesList) {
			this.deviceNames.add(device.getName());
		}
		
		List<User> usersList = net.getUsers();
		this.userNames = new ArrayList<String>();
		for (User user : usersList) {
			this.userNames.add(user.getFirstname() + " " + user.getLastname());
		}
		
		
		//init
		network = net.getNetworkByDevice(devices.get(0).getId());
		networks_user=net.getNetworksByUserList(users.get(0).getId());
		users_device=net.getUsersByDeviceList(devices.get(0).getId());
		users_network=net.getUsersByNetworkList(networks.get(0).getId());
		devices_user=net.getDevicesByUserList(users.get(0).getId());
		devices_network=net.getDevicesByNetworkList(networks.get(0).getId());
	}


	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<String> getNetworkNames() {
		return networkNames;
	}

	public void setNetworkNames(List<String> networkNames) {
		this.networkNames = networkNames;
	}

	public List<String> getDeviceNames() {
		return deviceNames;
	}

	public void setDeviceNames(List<String> deviceNames) {
		this.deviceNames = deviceNames;
	}

	public List<String> getUserNames() {
		return userNames;
	}

	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public List<Network> getNetworks_user() {
		return networks_user;
	}

	public void setNetworks_user(List<Network> networks_user) {
		this.networks_user = networks_user;
	}

	public List<User> getUsers_device() {
		return users_device;
	}

	public void setUsers_device(List<User> users_device) {
		this.users_device = users_device;
	}

	public List<User> getUsers_network() {
		return users_network;
	}

	public void setUsers_network(List<User> users_network) {
		this.users_network = users_network;
	}

	public List<Device> getDevices_user() {
		return devices_user;
	}

	public void setDevices_user(List<Device> devices_user) {
		this.devices_user = devices_user;
	}

	public List<Device> getDevices_network() {
		return devices_network;
	}

	public void setDevices_network(List<Device> devices_network) {
		this.devices_network = devices_network;
	}


	public String getNetworkName() {
		return NetworkName;
	}


	public void setNetworkName(String networkName) {
		NetworkName = networkName;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getDeviceName() {
		return DeviceName;
	}


	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	
	public void updateNetworkName(ValueChangeEvent event) {
    	this.NetworkName = (String)event.getNewValue();
    }
	
	public void updateDeviceName(ValueChangeEvent event) {
    	this.DeviceName = (String)event.getNewValue();
    }
	
	public void updateUserName(ValueChangeEvent event) {
    	this.UserName = (String)event.getNewValue();
    }
	
	
}
