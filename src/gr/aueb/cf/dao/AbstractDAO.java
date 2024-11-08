package gr.aueb.cf.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAO<T> implements IGenericDAO<T> {
    private final Map<Long, T> storage = new HashMap<>();
    private Class<T> persistenceClass;

    public AbstractDAO() {}

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public void setPersistenceClass(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass; //in which concrete class t is referring
    }

    @Override
    public T insert(Long id, T t) {
        storage.put(id, t);
        return t;
    }

    @Override
    public T update(Long id, T t) {
        return storage.replace(id, t); // replace() returns t
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public T get(Long id) {
        return storage.get(id); // ger() returns t
     }

    @Override
    public Map<Long, T> getAll() {
        return new HashMap<>(storage); // fresh instance of storage
    }
}
