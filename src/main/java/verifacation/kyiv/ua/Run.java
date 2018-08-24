/*
package verifacation.kyiv.ua;

import verifacation.kyiv.ua.exception.EntityCreateException;
import verifacation.kyiv.ua.exception.EntityEmptyListException;
import verifacation.kyiv.ua.exception.EntityNotFoundException;
import verifacation.kyiv.ua.model.*;
import verifacation.kyiv.ua.service.VerificationService;
import verifacation.kyiv.ua.service.VerificationServiceImpl;

import java.util.Date;

public class Run {

    public static void main(String[] args) throws EntityNotFoundException, EntityEmptyListException, EntityCreateException {

//        createHbNegative(new VerificationServiceImpl<>(HbNegative.class));
//        createHbCheckKb(new VerificationServiceImpl<>(HbCheckKb.class));
//        createHbCheckProfit(new VerificationServiceImpl<>(HbCheckProfit.class));
//        createHbResult(new VerificationServiceImpl<>(HbResult.class));
//        createHbType(new VerificationServiceImpl<>(HbType.class));
        //createUser(new VerificationServiceImpl<>(User.class));
        createClientCar(new VerificationServiceImpl<>(ClientCar.class));

    }

    private static void createClientCar(VerificationServiceImpl<ClientCar> verificationService) throws EntityNotFoundException, EntityCreateException {

        verificationService.create(
                new ClientCar("Гетьман Максим Олександрович",
                        "3356513290",
                        new VerificationServiceImpl<>(HbNegative.class).find(5),
                        new VerificationServiceImpl<>(HbCheckKb.class).find(12),
                        new VerificationServiceImpl<>(HbCheckProfit.class).find(14),
                        "13.01.2012 року притягувався до адміністративної відповідальності за проживання без паспорту.",
                        "-",
                        new VerificationServiceImpl<>(HbResult.class).find(16),
                        new VerificationServiceImpl<>(HbType.class).find(21),
                        new Date(),
                        new VerificationServiceImpl<>(User.class).find(2)));

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
    }

    private static void createHbNegative(VerificationService<HbNegative> verificationService) throws EntityCreateException {
        verificationService.create(new HbNegative("Так"));
        verificationService.create(new HbNegative("Ні"));
    }

    private static void createHbCheckKb(VerificationService<HbCheckKb> verificationService) throws EntityCreateException {
        verificationService.create(new HbCheckKb("Немає"));
        verificationService.create(new HbCheckKb("Низький КР"));
        verificationService.create(new HbCheckKb("Діюча прострочка"));
        verificationService.create(new HbCheckKb("Є, закритий"));
        verificationService.create(new HbCheckKb("Є, з прострочками"));
        verificationService.create(new HbCheckKb("Позитивна кредитна історія"));
        verificationService.create(new HbCheckKb("Не перевірялось"));
    }

    private static void createHbCheckProfit(VerificationService<HbCheckProfit> verificationService) throws EntityCreateException {
        verificationService.create(new HbCheckProfit("Не перевірялось"));
        verificationService.create(new HbCheckProfit("Підтверджуються"));
    }

    private static void createHbResult(VerificationService<HbResult> verificationService) throws EntityCreateException {
        verificationService.create(new HbResult("Погоджено"));
        verificationService.create(new HbResult("Відмовлено"));
        verificationService.create(new HbResult("На розгляд РМ"));
        verificationService.create(new HbResult("На доопрацювання"));
        verificationService.create(new HbResult("Інше"));
    }

    private static void createHbType(VerificationService<HbType> verificationService) throws EntityCreateException {
        verificationService.create(new HbType("Клієнт"));
        verificationService.create(new HbType("Поручитель"));
        verificationService.create(new HbType("Член ГСК"));
    }

    private static void createUser(VerificationServiceImpl<User> verificationService) throws EntityCreateException {
        verificationService.create(new User("admin","12345"));
        verificationService.create(new User("semykopna","11111"));
        verificationService.create(new User("borova","22222"));
        verificationService.create(new User("selivanovao","33333"));
    }
}*/
