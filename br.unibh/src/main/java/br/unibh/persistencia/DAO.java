package br.unibh.persistencia;

import java.util.List;

/**
 *
 * @author VictorVaz
 * @param <T>
 * @param <K>
 */
public interface DAO<T,K>
{
    public T find(K id);
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public List<T> findAll();
}
