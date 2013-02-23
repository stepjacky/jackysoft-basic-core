package org.jackysoft.util;

public enum AttachmentType {
	  生产月简报{

			@Override
			public String toString() {
				return "manufacor_list";
			}
      	
      },
      市场周报{

			@Override
			public String toString() {
				return "market_list";
			}
      	
      },
      OFFICE文档 {

		@Override
		public String toString() {
			return "Office Document";
		}
    	    
      },
       WORD{
         
		@Override
		public String toString() {
			return "doc";
		}
    	  
      },
      
        PPT文档{
          
  		@Override
  		public String toString() {
  			return "ppt";
  		}
      	  
        },
        EXCEL文档{
            
    		@Override
    		public String toString() {
    			return "xls";
    		}
        	  
        },  
        未知类型{

			@Override
			public String toString() {
				return "UnKnow";
			}
        	
        };
      public static AttachmentType getType(String str){
    	    if("doc".equalsIgnoreCase(str)
    	     ||"docx".equalsIgnoreCase(str)){
    	    	return WORD;
    	    }
    	    if("xls".equalsIgnoreCase(str)
    	    	     ||"xlsx".equalsIgnoreCase(str)){
    	    	    	return EXCEL文档;
    	    	    }
    	    if("ppt".equalsIgnoreCase(str)
   	    	     ||"pptx".equalsIgnoreCase(str)){
   	    	    	return PPT文档;
   	    	    }
    	    else 
    	    	return 未知类型;
    	    	
      }
      
}
