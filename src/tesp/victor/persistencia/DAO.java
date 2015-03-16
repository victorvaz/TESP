package tesp.victor.persistencia;

import java.util.List;

public interface DAO<T, K> {

    public T find(K id);

    public void insert(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> findAll();

}
