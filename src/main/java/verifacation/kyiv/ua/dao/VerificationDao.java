package verifacation.kyiv.ua.dao;

import verifacation.kyiv.ua.exception.*;

import java.util.List;

public interface VerificationDao<T> {

    void create(T t) throws EntityCreateException;
    T find(long id) throws EntityNotFoundException;
    List<T> findAll() throws EntityEmptyListException;
    void update(T t) throws EntityUpdateException;
    T delete(long id) throws EntityDeleteException;
    long getNextHibernateSequence();
}
