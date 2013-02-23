package org.jackysoft.util;

import java.util.List;

public class ParamFormator {
	List<PageParameter> params;

	// public ParamFormator(){};
	public ParamFormator(List<PageParameter> params) {
		this.params = params;
	}

	/**
	 * 
	 * 把 页面传来的参数list={f,t,d,4} 转换成 s="f,t,d,4" 的形式;
	 * 
	 * @param 要组装的参数名字
	 * 
	 */
	public String getFormatedValues(String param) {
		StringBuffer paramstring = new StringBuffer();
		for (PageParameter p : params) {
			if (p.getName().equals(param)) {
				paramstring.append(p.getValue());
				paramstring.append(",");
			}
		}
		if (paramstring.length() > 0)
			return paramstring.substring(0, paramstring.length() - 1);
		else
			return null;

	}
}
