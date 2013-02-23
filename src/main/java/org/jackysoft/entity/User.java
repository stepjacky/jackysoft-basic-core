package org.jackysoft.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import com.google.common.collect.Lists;

@Entity
@Table(name = "sysuser")
public class User extends AbstractNoIdEntity implements Comparable<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6758732902889482666L;

	private String username;
	private String password = "12345678";
	private String localName;
	private Department department;
	private Role role;
	private boolean enabled;
	private Collection<AcegiRole> authoritys = Lists.newArrayList();
	
	
	public User() {}

	
	public User(String username) {
		this.username = username;
	}

	@ManyToOne
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            要设置的 role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne	
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            要设置的 department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return localName
	 */
	
	public String getLocalName() {
		return localName;
	}

	/**
	 * @param localName
	 *            要设置的 localName
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * @param password
	 *            要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name = "user_authority", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	public Collection<AcegiRole> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(Collection<AcegiRole> authoritys) {
		this.authoritys = authoritys;
	}

	
	

	@Column(name = "storePass")
	public String getPassword() {
		return password;
	}	

	@Id
	@GeneratedValue(generator = "agn")
	@GenericGenerator(name = "agn", strategy = "assigned")
	@Column(name = "name")	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int compareTo(User o) {
		if (o == null || o.sort==null)
			return 1;
		if(this.sort==null)
			return -1;
		return this.sort.compareTo(o.sort);
	}
	public boolean equals(Object rhs) {
		if (!(rhs instanceof User) || (rhs == null)) {
			return false;
		}
		User user = (User) rhs;
		return (this.getUsername().equals(user.getUsername()));
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
