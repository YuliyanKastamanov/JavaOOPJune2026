package mushroomKingdom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MushroomKingdomTests {

//TODO write unit tests here covering all the methods


    private Field field;
    private Mushroom mushroom;


    @BeforeEach
    public void setUp(){
        this.field = new Field("Rila", 10);
        //манатарка
        mushroom = new Mushroom("Boletus", "nutty flavor", true, 0);
    }


    @Test
    public void whenCreateMushroom_thenCreatedSuccessfully(){
        Assertions.assertEquals("Boletus", mushroom.getName());
        Assertions.assertEquals("nutty flavor", mushroom.getFlavor());
        Assertions.assertEquals(0, mushroom.getToxicity());
        Assertions.assertTrue(mushroom.isEdible());
    }

    @Test
    public void whenCreateFieldWithNullName_thenExceptionIsThrown(){
        Assertions.assertThrows(NullPointerException.class, () ->
            field = new Field(null, 10));
    }

    @Test
    public void whenCreateFieldWithNegativeCapacity_thenExceptionIsThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                field = new Field("New Field", -10));
    }

    @Test
    public void whenAddMushroomWithNotEnoughCapacity_thenExceptionIsThrown(){
        Field newField = new Field("new field", 1);
        newField.addMushroom(mushroom);

        Mushroom newMushroom = new Mushroom("field mushroom", "flavor", true, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> newField.addMushroom(newMushroom));

    }

    @Test
    public void whenAddExistingMushroom_thenExceptionIsThrown(){
        Field newField = new Field("new field", 2);
        newField.addMushroom(mushroom);

        Mushroom newMushroom = new Mushroom("field mushroom", "flavor", true, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> newField.addMushroom(mushroom));

    }

    @Test
    public void whenRemoveMushroom_thenMushroomRemovedSuccessfully(){
        field.addMushroom(mushroom);
        Assertions.assertTrue(field.removeMushroom("Boletus"));
    }

    @Test
    public void testGetMostPoisonousMushroom(){
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils mushroom", "n/a", false, 5);

        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        Assertions.assertEquals("red fly agaric", field.getMostPoisonousMushroom());
    }

    @Test
    public void testGetInedibleMushrooms(){
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils mushroom", "n/a", false, 5);

        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        List<Mushroom> inEdibleMushrooms = new ArrayList<>();
        inEdibleMushrooms.add(redFlyAgaric);
        inEdibleMushrooms.add(devilsMushroom);

        Assertions.assertEquals(inEdibleMushrooms, field.getInedibleMushrooms());
    }


    @Test
    public void testGetByFlavorMushrooms(){
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils mushroom", "n/a", false, 5);

        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        List<Mushroom> byFlavor = new ArrayList<>();
        byFlavor.add(redFlyAgaric);
        byFlavor.add(devilsMushroom);

        Assertions.assertEquals(byFlavor, field.getMushroomsByFlavor("n/a"));
    }


    @Test
    public void testGetCount(){
        field.addMushroom(mushroom);
        Assertions.assertEquals(1, field.getCount());
    }

    @Test
    public void testGetMushroom(){
        field.addMushroom(mushroom);
        Assertions.assertEquals(mushroom, field.getMushroom("Boletus"));
    }


    @Test
    public void testGetName(){
        Assertions.assertEquals("Rila", field.getName());
    }

}
