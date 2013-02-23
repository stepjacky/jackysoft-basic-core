/**
 * 
 */
package org.jackysoft.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author qujiakang
 * 
 */
@Entity
@Table(name = "department")
public class Department extends AbstractEntity implements Comparable<Department> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5852801939166078336L;

	public static final Department NONE = new Department();

	private  String name;

	private Department topParent;
	
	private Department parent;
	
	private DepartmentType departmentType = DepartmentType.Manager;
	

	
	public Department() {
		super();
		this.setName("");		
	}
	public Department(String id) {
		this.id = id;
		
	}
	public Department(String id,String name) {
	    this(id);
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

	
	@ManyToOne
	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}
	
	public void setDepartmentType(DepartmentType departmentType) {
		this.departmentType = departmentType;
	}
	public DepartmentType getDepartmentType() {
		return departmentType==null?DepartmentType.Manager:departmentType;
	}	
		
	public void setTopParent(Department topParent) {
		this.topParent = topParent;
	}
	
	@ManyToOne
	public Department getTopParent() {
		return topParent;
	}
	@Override
	public int compareTo(Department o) {
		if(o==null || o.id==null) return 1;
		if(this.id==null) return -1;
		return this.id.compareTo(o.id);
	}

}
