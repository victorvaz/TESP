package br.unibh.persistencia;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T,K>
{
	public T find(K id) throws SQLException, Exception;
	public void insert(T t) throws SQLException, Exception;
	public void update(T t) throws SQLException, Exception;
	public void delete(K id) throws SQLException, Exception;
	public List<T> findAll() throws SQLException, Exception;
}