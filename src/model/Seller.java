package model;

import java.util.ArrayList;

public class Seller extends Person {
	private int totalSales;
	private ArrayList <Client> clients;

	public Seller(String name, String lastName, String id) {
		super(name,lastName,id);
		this.totalSales = 0;
		this.clients = new ArrayList<>();
	}

	public ArrayList<Client> getClients(){
		return clients;
	}
	
	public boolean addClient(Client client) {
		boolean added = true;
		if(this.clients.size() <= 5) {
			this.clients.add(client);			
		} else {
			added = false;
		}
		return added;
		
	}
	


	public int getTotalSales() {
		return totalSales;
	}


	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	
	

}
