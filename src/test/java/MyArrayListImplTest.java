import org.example.MyArrayListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayListImplTest {
    MyArrayListImpl <Integer> arrayList;
    MyArrayListImpl <String> arrayListString;

    @BeforeEach
    void initArrayList(){
        arrayList=new MyArrayListImpl<>();
        int [] ints = {1, 5, 55, 10, 3};

        for(int d : ints) {
            arrayList.add(d);
        }

        arrayListString = new MyArrayListImpl<>();
        String[] strings = {"1", "44", "22", "4", "16"};

        for (String d : strings) {
            arrayListString.add(d);
        }
    }

    @Test
    void arrayList_AddElement_ShouldSuccess(){
        Integer[] expected = {1, 5, 55, 10, 3};
        String[] expectedString = {"1", "44", "22", "4", "16"};

        assertArrayEquals(expected, arrayList.getObjects());
        assertArrayEquals(expectedString, arrayListString.getObjects());
    }

    @Test
    void arrayList_GetElement_ShouldReturnCorrectResult(){
        assertEquals(10 ,arrayList.get(3));
        assertEquals("22" ,arrayListString.get(2));
    }
    @Test
    void arrayList_RemoveElement_ShouldSuccess(){
        arrayList.remove(10);
        arrayListString.remove("22");

        Integer[] expected = {1, 5, 55, 3};
        String[] expectedString = {"1", "44", "4", "16"};

        assertArrayEquals(expected, arrayList.getObjects());
        assertArrayEquals(expectedString, arrayListString.getObjects());

    }
    @Test
    void arrayList_Clear_ShouldSuccess(){
        arrayList.clear();
        arrayListString.clear();

        assertArrayEquals(new Integer[0], arrayList.getObjects());
        assertArrayEquals(new String[0], arrayListString.getObjects());

    }

    @Test
    void arrayList_SortInteger_ShouldReturnCorrectResult(){
        Integer[] expected = {1, 3, 5, 10, 55};

        arrayList.sort();
        assertArrayEquals(expected, arrayList.getObjects());

        Exception exception = assertThrows(IllegalArgumentException.class, ()->  {
            arrayListString.sort();
        });

        String expectedMessage = "Упс!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void arrayList_SortString_ShouldReturnException(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->  {
            arrayListString.sort();
        });

        String expectedMessage = "Упс!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

