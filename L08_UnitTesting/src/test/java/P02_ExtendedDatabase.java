import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class P02_ExtendedDatabase {




    @Test
    public void whenTryToAddNull_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, ()-> {
            database.add(null);
        });


    }


    @Test
    public void whenAddValidPerson_thenPersonIsAdded() throws OperationNotSupportedException {
        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        int initialPeopleCount = database.getElements().length;//2

        Person gosho = new Person(3, "Gosho");

        database.add(gosho);

        int newPeopleCount = database.getElements().length; //3

        Person lastAddedPerson = database.getElements()[newPeopleCount - 1];
        //1. Гошо е последния добавен човек
        Assertions.assertEquals(gosho, lastAddedPerson);

        //2. Броя на хората се е увеличил с 1
        Assertions.assertEquals(initialPeopleCount + 1, newPeopleCount);


    }

    @Test
    public void whenCreateDatabaseWithZeroPeople_thenExceptionIsThrown(){

        Person[] people = new Person[0];

        // assertThrows = очаквам даден код да хвърли някакъв exception
        //1. Какъв клас грешка ще хвърли
        //2.  = () -> {Пишем кода, който хвърля този exception}

        Assertions.assertThrows(OperationNotSupportedException.class, () ->{
           Database database = new Database(people);
        });

    }


    @Test
    public void whenTryToFindByUsernameWithNameNull_thenExceptionIsThrown() throws OperationNotSupportedException {
        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () ->{
            database.findByUsername(null);
        });


    }


    @Test
    public void whenUseUnknownUsernameInFindByUsername_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);


        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername("Gosho");
        });


    }

    @Test
    public void whenUseExistingUsernameForFindByUsername_thenPersonIsReturned() throws OperationNotSupportedException {


        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        Person findedPerson = database.findByUsername("Ivan");


        Assertions.assertEquals(1, findedPerson.getId());
        Assertions.assertEquals("Ivan", findedPerson.getUsername());
        Assertions.assertEquals(ivan, findedPerson);

    }


    @Test
    public void whenSearchingByExistingId_thenReturnThePerson() throws OperationNotSupportedException {


        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        Person findedPerson = database.findById(2);

        Assertions.assertEquals(findedPerson.getId(), 2);
        Assertions.assertEquals(findedPerson.getUsername(), "Pesho");
        Assertions.assertEquals(findedPerson, pesho);

    }


    @Test
    public void whenSearchByNotExistingId_thenExceptionIsThrown () throws OperationNotSupportedException {


        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () ->{

            Person findedPerson = database.findById(3);
        });

    }

    @Test
    public void whenRemoveElementFromDatabaseWithManyElements_thenElementSuccessfullyRemoved() throws OperationNotSupportedException {


        Person ivan = new Person(1, "Ivan");
        Person pesho = new Person(2, "Pesho");
        Person[] people = {ivan, pesho};
        Database database = new Database(people);


        //Вземамем броя на елементи, които имаме в базата данни
        int oldElementsCount = database.getElements().length;

        //премахваме елемент -> каунт-а ще бъде намален с -1
        database.remove();

        int actualElementsCount = database.getElements().length;

        //проверяваме дали oldElementsCount - 1 == actualElementsCount
        Assertions.assertEquals(oldElementsCount - 1, actualElementsCount);



    }

    @Test
    public void whenRemoveElementFromEmptyDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {


        Person ivan = new Person(1, "Ivan");
        Person[] people = {ivan};
        Database database = new Database(people);


        database.remove();

        //след като съм премахнал всички елементи в базата данни
        //при извикване на метода remove() -> Exception
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });

    }



}
