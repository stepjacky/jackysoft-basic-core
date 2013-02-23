package org.jackysoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jdbc.Work;
import org.jackysoft.entity.AcegiRole;
import org.jackysoft.entity.User;

public class SecurityUsersWork implements Work {
	
	static final Log logger  = LogFactory.getLog(SecurityUsersWork.class);
    private AcegiRole role;
    private Collection<User> users;
    
    
	public SecurityUsersWork(AcegiRole role, Collection<User> users) {
		super();
		this.role = role;
		this.users = users;
	}


	@Override
	public void execute(Connection connection) throws SQLException {
	    Statement stat = connection.createStatement();
        for(User user : users){
        	String sql = "insert into user_authority (user_id,authority_id) values('"+user.getUsername()+"','"+role.getName()+"')";
        	stat.addBatch(sql);
        	if(logger.isDebugEnabled()){
        		logger.debug(sql);
        	}
        }
        
        int[] rst = stat.executeBatch();
        logger.debug("已更新  "+rst.length +" 个用户..");
        stat.close();
        
	}

}
