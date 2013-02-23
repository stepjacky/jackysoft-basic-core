package org.jackysoft.annotations;

public enum FormEncType {
	NORMAL{
		public String toString(){
		     return "application/x-www-form-urlencoded";
	
		}
		
	},
	FILEUPLOAD{
		public String toString(){
		     return "multipart/form-data";
	
		}
	},
	TEXT{
		public String toString(){
		     return "text/plain";
	        
		}
	}

}
