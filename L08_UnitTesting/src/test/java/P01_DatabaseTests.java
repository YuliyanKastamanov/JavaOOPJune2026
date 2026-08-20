import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class P01_DatabaseTests {


    @Test
    public void whenCreateDatabaseWithZeroElements_thenExceptionIsThrown(){

        Integer[] elements = new Integer[0];

        // assertThrows = очаквам даден код да хвърли някакъв exception
        //1. Какъв клас грешка ще хвърли
        //2.  = () -> {Пишем кода, който хвърля този exception}

        Assertions.assertThrows(OperationNotSupportedException.class, () ->{
            Database database = new Database(elements);
        });

    }

    @Test
    public void whenCreateDatabaseWithMoreThanSixteenElements_thenExceptionIsThrown(){

        //масив с повече от 16 елемента
        Integer[] elements = new Integer[17];

        // assertThrows = очаквам даден код да хвърли някакъв exception
        //1. Какъв клас грешка ще хвърли
        //2.  = () -> {Пишем кода, който хвърля този exception}
        //Очаквам да не мога да създам базата данни -> OperationNotSupportedException.class

        Assertions.assertThrows(OperationNotSupportedException.class, () ->{
            Database database = new Database(elements);
        });

    }


    @Test
    public void whenCreateDatabaseWithAllowedNumberOfElements_thenDatabaseCreationShouldBeSuccessfullyCreated() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        Assertions.assertEquals(database.getElements()[0], elements[0]);
        Assertions.assertEquals(database.getElements()[1], elements[1]);
        Assertions.assertEquals(database.getElements()[2], elements[2]);
        Assertions.assertEquals(database.getElements().length, elements.length);

    }

    @Test
    public void whenAddNullElement_thenExceptionIsThrown() throws OperationNotSupportedException {

        //създаваме елемент, който е null
        Integer element = null;
        Integer[] elements = new Integer[10];
        Database database = new Database(elements);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });

    }
    @Test
    public void whenAddNumber_thenTheNumberIsSuccessfullyAdded() throws OperationNotSupportedException {

        Integer number = 5;
        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        //вземаме стария каунт на броя елементи в базата данни
        int oldDatabaseElementsCount = database.getElements().length;

        //добавяме елемент -> oldDatabaseElementsCount + 1
        database.add(number);

        //след добавянето, очаквам:
        //1. Последния елемент, трябва да бъде равен на числото, което добавяме
        Integer lastElement = database.getElements()[database.getElements().length - 1];
        Assertions.assertEquals(number, lastElement);

        //2. Проверяваме броя на елементите след добавянето
        //добавяме елемент -> olsDatabaseElementsCount + 1
        int newElementsCount = database.getElements().length;
        Assertions.assertEquals(newElementsCount, oldDatabaseElementsCount + 1);
    }

    @Test
    public void whenRemoveElementFromDatabaseWithManyElements_thenElementSuccessfullyRemoved() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

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

        Integer[] elements = new Integer[]{10};
        Database database = new Database(elements);

        database.remove();

        //след като съм премахнал всички елементи в базата данни
        //при извикване на метода remove() -> Exception
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });

    }


}
