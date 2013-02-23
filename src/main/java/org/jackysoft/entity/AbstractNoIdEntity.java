package org.jackysoft.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@MappedSuperclass
public abstract class AbstractNoIdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 60397524682875165L;
	protected Integer sort = 0;
	private int mtype;
	@Column(columnDefinition="int default 0")
	@NotFound(action=NotFoundAction.IGNORE)
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort==null?0:sort;
	}	
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	@Transient
	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}	
}
