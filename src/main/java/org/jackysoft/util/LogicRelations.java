package org.jackysoft.util;

public enum LogicRelations {
     And,Or;
     
     public static LogicRelations parse(String str){
    	 if(str==null)throw new NullPointerException("invalid string ,LogicRelations: can not parse ");
    	 if(And.toString().equalsIgnoreCase(str))return And;
    	 if(Or.toString().equalsIgnoreCase(str))return Or;
    	 throw new NullPointerException("invalid string ,LogicRelations: can not parse ");
     }
}
