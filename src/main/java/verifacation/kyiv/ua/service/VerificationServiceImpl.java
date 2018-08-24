package verifacation.kyiv.ua.service;

import verifacation.kyiv.ua.dao.VerificationDao;
import verifacation.kyiv.ua.dao.VerificationDaoImpl;
import verifacation.kyiv.ua.exception.EntityCreateException;
import verifacation.kyiv.ua.exception.EntityDeleteException;
import verifacation.kyiv.ua.exception.EntityEmptyListException;
import verifacation.kyiv.ua.exception.EntityNotFoundException;

import java.util.List;

public class VerificationServiceImpl<T> implements VerificationService<T>{

    private VerificationDao<T> verificationDao;

    public VerificationServiceImpl(Class<T> persistentClass) {
        verificationDao = new VerificationDaoImpl<>(persistentClass);
    }

    @Override
    public void create(T t) throws EntityCreateException {
        verificationDao.create(t);
    }

    @Override
    public T find(long id) throws EntityNotFoundException {
        return verificationDao.find(id);
    }

    @Override
    public List<T> findAll() throws EntityEmptyListException {
        return verificationDao.findAll();
    }

    @Override
    public void update(long id, T t) {

    }

    @Override
    public T delete(long id) throws EntityDeleteException {
        return verificationDao.delete(id);
    }

    public VerificationDao<T> getVerificationDao() {
        return verificationDao;
    }
}
