package verifacation.kyiv.ua.service;

import verifacation.kyiv.ua.exception.*;

import java.util.List;

public interface VerificationService<T> {

    void create(T t)throws EntityCreateException;
    T find(long id) throws EntityNotFoundException;
    List<T> findAll() throws EntityEmptyListException;
    void update(long id, T t) throws EntityUpdateException;
    T delete(long id) throws EntityDeleteException;

}
