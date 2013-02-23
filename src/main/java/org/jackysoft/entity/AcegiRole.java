package org.jackysoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class AcegiRole extends AbstractNoIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6885515515519355356L;
	private String name;
	private String description;
	
	
	
	public AcegiRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	public AcegiRole(String name) {
		super();
		this.name = name;
	}
	
	public AcegiRole(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
