package org.jackysoft.util;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Id;

import com.google.common.collect.Lists;

public class AnnotationUtil {
   public static String getPrimaryKeyFieldName(Class type){
	   if(type.isAnnotationPresent(Id.class)){
		   Id id = (Id) type.getAnnotation(type);
		  
	   }
	   return null;
   }
   
   /***/
   public static  String[] getAnnotationPresentedProperties(Object obj,Class<NoSerialize> als){
	   Class<?> c = obj.getClass();
	   List<String> pnames = Lists.newArrayList();
	   Field[] fds =  c.getFields();
	   for(Field f:fds){
		   if(!f.isAnnotationPresent(als)){
			   pnames.add(f.getName());
		   }
	   }
	   String[] ps = new String[pnames.size()];
	   pnames.toArray(ps);
	   return ps;
   }
   
}
