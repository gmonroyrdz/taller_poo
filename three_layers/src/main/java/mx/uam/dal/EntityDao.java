package mx.uam.dal;

import java.util.List;

public interface EntityDao<T> {
    public List<T> getAll();
    public T getById(int id);
    public void save(T entity);
    public void modify(T entity);
    public void delete(int id);
}
