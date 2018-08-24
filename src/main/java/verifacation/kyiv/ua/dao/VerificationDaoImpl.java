package verifacation.kyiv.ua.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import verifacation.kyiv.ua.exception.*;
import verifacation.kyiv.ua.exception.EntityNotFoundException;
import verifacation.kyiv.ua.util.EntityManagerUtil;

import javax.persistence.*;
import java.util.List;

public class VerificationDaoImpl<T> implements VerificationDao<T> {

    private static final Logger LOGGER = Logger.getLogger(VerificationDaoImpl.class);

    private Class<T> persistentClass;

    public VerificationDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void create(T t) throws EntityCreateException {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        LOGGER.info("Create EntityManager");
        EntityTransaction transaction = entityManager.getTransaction();
        LOGGER.info("Create EntityTransaction");

        try {
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
            LOGGER.info(persistentClass.getSimpleName() + " entity saved successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            LOGGER.debug(persistentClass.getSimpleName() + " entity rollbacked!!!");
            throw new EntityCreateException(persistentClass.getSimpleName() + " entity not saved!!!");
        } finally {
            entityManager.close();
            LOGGER.info("Close EntityManager");
        }
    }

    @Override
    public T find(long id) throws EntityNotFoundException {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        LOGGER.info("Create EntityManager");
        EntityTransaction transaction = entityManager.getTransaction();
        LOGGER.info("Create EntityTransaction");

        try {
            transaction.begin();
            if (entityManager.find(persistentClass, id) != null) {
                LOGGER.info(persistentClass.getSimpleName() + " entity found!!!");
                return entityManager.find(persistentClass, id);
            }else {
                LOGGER.debug(persistentClass.getSimpleName() + " entity not found!!!");
                throw new EntityNotFoundException("Entity not found!!!");
            }
        } finally {
            entityManager.close();
            LOGGER.info("Close EntityManager");
        }
    }

    @Override
    public List<T> findAll() throws EntityEmptyListException {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        LOGGER.info("Create EntityManager");
        EntityTransaction transaction = entityManager.getTransaction();
        LOGGER.info("Create EntityTransaction");

        try {
            transaction.begin();
            Query query = entityManager.createQuery("SELECT t FROM " + persistentClass.getSimpleName() + " t");
            if (query.getResultList().size()!= 0) {
                LOGGER.info("got the entities list of " + persistentClass.getSimpleName());
                return query.getResultList();
            }else {
                LOGGER.debug("empty entities list of " + persistentClass.getSimpleName());
                throw new EntityEmptyListException("Empty list!!!");
            }
        } finally {
            entityManager.close();
            LOGGER.info("Close EntityManager");
        }
    }

    @Override
    public void update(T t) throws EntityUpdateException {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        LOGGER.info("Create EntityManager");
        EntityTransaction transaction = entityManager.getTransaction();
        LOGGER.info("Create EntityTransaction");

        try {
            transaction.begin();
            entityManager.merge(t);
            transaction.commit();
            LOGGER.info(persistentClass.getSimpleName() + " entity updated successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            LOGGER.debug(persistentClass.getSimpleName() + " entity rollbacked!!!");
            throw new EntityUpdateException(persistentClass.getSimpleName() + " entity not updated!!!");
        } finally {
            entityManager.close();
            LOGGER.info("Close EntityManager");
        }
    }

    @Override
    public T delete(long id) throws EntityDeleteException {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        LOGGER.info("Create EntityManager");
        EntityTransaction transaction = entityManager.getTransaction();
        LOGGER.info("Create EntityTransaction");

        try {
            transaction.begin();
            T t = entityManager.find(persistentClass, id);
            if (t != null) {
                LOGGER.info(persistentClass.getSimpleName() + " entity found!!!");
                entityManager.remove(t);
                transaction.commit();
                LOGGER.info(persistentClass.getSimpleName() + " entity removed!!!");
                return t;
            }else{
                LOGGER.debug(persistentClass.getSimpleName() + " entity not removed!!!");
                LOGGER.debug(persistentClass.getSimpleName() + " entity rollbacked!!!");
                throw new EntityDeleteException(persistentClass.getSimpleName() + " entity not removed!!!");
            }
        }finally {
            entityManager.close();
            LOGGER.info("Close EntityManager");
        }
    }

    @Override
    public long getNextHibernateSequence() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Object next = entityManager.createNativeQuery("select distinct next_val from hibernate_sequence").getSingleResult();
        return Long.parseLong(String.valueOf(next));
    }
}