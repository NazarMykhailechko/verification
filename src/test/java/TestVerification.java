import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import verifacation.kyiv.ua.dao.VerificationDao;
import verifacation.kyiv.ua.exception.EntityCreateException;
import verifacation.kyiv.ua.exception.EntityDeleteException;
import verifacation.kyiv.ua.exception.EntityEmptyListException;
import verifacation.kyiv.ua.exception.EntityNotFoundException;
import verifacation.kyiv.ua.model.*;
import verifacation.kyiv.ua.service.VerificationService;
import verifacation.kyiv.ua.service.VerificationServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestVerification {

    @Test
    public void _01create() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, EntityNotFoundException, EntityCreateException {

        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);

        long id = getId(verificationService);

        verificationService.create(new ClientCar("Сердюк Сергій Петрович",
                "3173513498",
                new VerificationServiceImpl<>(HbNegative.class).find(6),
                new VerificationServiceImpl<>(HbCheckKb.class).find(10),
                new VerificationServiceImpl<>(HbCheckProfit.class).find(15),
                "Відсутня додаткова інформація",
                "-",
                new VerificationServiceImpl<>(HbResult.class).find(19),
                new VerificationServiceImpl<>(HbType.class).find(23),
                new Date(),
                new VerificationServiceImpl<>(User.class).find(4)));

        verificationService.create(new ClientCar("Сердюк Сергій Петрович",
                "3173513498",
                new VerificationServiceImpl<>(HbNegative.class).find(6),
                new VerificationServiceImpl<>(HbCheckKb.class).find(10),
                new VerificationServiceImpl<>(HbCheckProfit.class).find(15),
                "Відсутня додаткова інфлрмація",
                "-",
                new VerificationServiceImpl<>(HbResult.class).find(19),
                new VerificationServiceImpl<>(HbType.class).find(23),
                new Date(),
                new VerificationServiceImpl<>(User.class).find(4)));

        Assert.assertEquals("3173513498",
                    new VerificationServiceImpl<>(ClientCar.class).find(id).getInn());
    }

    @Test
    public void _02find() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, EntityNotFoundException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);
        long id = getId(verificationService);
        ClientCar clientCar = verificationService.find(id-1);
        Assert.assertEquals("3173513498", clientCar.getInn());
    }

    @Test
    public void _03findAll() throws EntityEmptyListException {
        List<ClientCar> list = new VerificationServiceImpl<>(ClientCar.class).findAll();
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void _04delete() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, EntityNotFoundException, EntityDeleteException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);
        long id = getId(verificationService);
        ClientCar found = verificationService.find(id-1);
        ClientCar deleted = verificationService.delete(id-1);
        Assert.assertEquals(found.getInn(),deleted.getInn());
    }

    @Test(expected = EntityNotFoundException.class)
    public void _05entityNotFoundException() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, EntityNotFoundException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);
        long id = getId(verificationService);
        verificationService.find(id);
    }

    @Test(expected = EntityCreateException.class)
    public void _06entityCreateException() throws EntityCreateException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);
        verificationService.create(null);
    }

    @Test(expected = EntityDeleteException.class)
    public void _07entityDeleteException() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, EntityDeleteException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);
        long id = getId(verificationService);
        verificationService.delete(id);
    }

    @Test(expected = EntityEmptyListException.class)
    public void _07entityEmptyListException() throws EntityEmptyListException {
        VerificationService<ClientCar> verificationService = new VerificationServiceImpl<>(ClientCar.class);

        List<ClientCar> clientCars = verificationService.findAll();

        clientCars.forEach(c -> {
            try {
                verificationService.delete(c.getId());
            } catch (EntityDeleteException e) {
                e.printStackTrace();
            }
        });

        verificationService.findAll();
    }

    private long getId(VerificationService<ClientCar> verificationService) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        VerificationDao verificationDao = (VerificationDao) verificationService.getClass()
                .getMethod("getVerificationDao", new Class[] {})
                .invoke(verificationService, new Object[] {});
        return verificationDao.getNextHibernateSequence();
    }
}