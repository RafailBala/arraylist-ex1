import org.example.MyArrayListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListImplTest {
    MyArrayListImpl <Integer> arrayList;
    MyArrayListImpl <String> arrayListString;

    @BeforeEach
    public void initArrayList(){
        arrayList=new MyArrayListImpl<>();
        int [] args={1, 5, 10, 3};

        for(int d:args) {
            arrayList.add(d);
        }
        arrayList.add(2,55);
    }
    @BeforeEach
    public void initArrayListString(){
        arrayListString=new MyArrayListImpl<>();
        String [] args={"1", "44", "4", "16"};

        for(String d:args) {
            arrayListString.add(d);
        }
        arrayListString.add(2,"22");
    }

    @Test
    public void arrayList_AddElement_ShouldSuccess(){
        Integer[] expected = {1, 5, 55, 10, 3};
        String[] expectedString = {"1", "44", "22", "4", "16"};

        assertArrayEquals(expected, arrayList.getObjects());
        assertArrayEquals(expectedString, arrayListString.getObjects());

    }

    @Test
    public void arrayList_GetElement_ShouldReturnCorrectResult(){
        assertEquals(10 ,arrayList.get(3));
        assertEquals("22" ,arrayListString.get(2));
    }
    @Test
    public void arrayList_RemoveElement_ShouldSuccess(){
        arrayList.remove(10);
        arrayListString.remove("22");

        Integer[] expected = {1, 5, 55, 3};
        String[] expectedString = {"1", "44", "4", "16"};

        assertArrayEquals(expected, arrayList.getObjects());
        assertArrayEquals(expectedString, arrayListString.getObjects());

    }
    @Test
    public void arrayList_Clear_ShouldSuccess(){
        arrayList.clear();
        arrayListString.clear();

        assertArrayEquals(new Integer[0], arrayList.getObjects());
        assertArrayEquals(new String[0], arrayListString.getObjects());

    }

    @Test
    public void arrayList_SortInteger_ShouldReturnCorrectResult(){
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
    public void arrayList_SortString_ShouldReturnException(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->  {
            arrayListString.sort();
        });

        String expectedMessage = "Упс!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

