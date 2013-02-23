package org.jackysoft.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1097008724017131875L;
	
	private String name;	 
	
	public Role() {
		super();	
		this.setName("");
	  
	}
	public Role(String id,String name) {
		this.id = id;
		this.name = name;
	}	

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	

}
