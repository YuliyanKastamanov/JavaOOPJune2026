import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p04_BubbleSortTest.Bubble;

public class P04_BubbleTest {


    @Test
    public void whenProvideUnSortedArrayOfNumbers_thenArrayToBeSorted(){

        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        Bubble.sort(array);

        //Какво очаквам да се случи с моя масив от цели числа
        int[] orderedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Assertions.assertArrayEquals(array, orderedArray);

    }
}
