package org.jackysoft.util;

import java.util.Collection;

import org.apache.commons.collections.Predicate;

public class CollectionUtils extends
		org.apache.commons.collections.CollectionUtils {
   public static void notNullable(Collection<?> col){
	   if(col==null)return ;
	   CollectionUtils.filter(col, new Predicate(){

		@Override
		public boolean evaluate(Object object) {
			// TODO Auto-generated method stub
			return object!=null;
		}
		   
	   });
   }
}
