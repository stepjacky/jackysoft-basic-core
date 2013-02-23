package org.jackysoft.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

public interface CRUDDataProvider<ID,B extends Serializable> {
    B  get(ID id) throws DataAccessException;
   
    B  get(QueryCriteria qc)throws DataAccessException;
    Collection<B> gets(int start,int size) throws DataAccessException;
    Collection<B> gets()throws DataAccessException;
    Collection<B> gets(QueryCriteria qc)throws DataAccessException;
    void create(B b)throws DataAccessException;
    void create(Collection<B> bs)throws DataAccessException;
    void remove(B t)throws DataAccessException;
    void remove(Collection<B> bs)throws DataAccessException;
    void update(B b)throws DataAccessException;
    void update(Collection<B> bs)throws DataAccessException;
    void saveOrUpdate(B b)throws DataAccessException;
   
    int count()throws DataAccessException;
    int count(QueryCriteria qc)throws DataAccessException;

}
