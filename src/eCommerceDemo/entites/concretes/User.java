package eCommerceDemo.entites.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.entites.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String parola;
	private boolean Active;

	public User() {
	}

	public User(int id, String firstName, String lastName, String email, String parola, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.parola = parola;
		Active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getNames() {
		List<String> names = new ArrayList<String>();
		names.add(this.firstName);
		if (this.middleName != null) {
			names.add(this.middleName);
		}
		names.add(this.lastName);
		return names;

	}

	public String getFullName() {
		if(this.middleName!=null) {
			
		return this.getId()+"-"+this.getFirstName()+" "+this.getMiddleName()+" "+this.getLastName();
		}
		return this.getId()+"-"+this.getFirstName()+" "+this.getLastName();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

}
