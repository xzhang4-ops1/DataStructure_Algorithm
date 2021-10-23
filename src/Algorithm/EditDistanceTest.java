package Algorithm;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

    @Test
    public void Test1() {
        String str1 = "abcd";
        String str2 = "dbcf";
        assertEquals(EditDistance.minDistance(str1,str2), 3);
    }

    @Test
    public void Test2() {
        String str1 = "goodmorning";
        String str2 = "goodevening";
        assertEquals(EditDistance.minDistance(str1,str2), 6);
    }

    @Test
    public void Test3() {
        String str1 = "bad";
        String str2 = "good";
        assertEquals(EditDistance.minDistance(str1,str2), 5);
    }

    @Test
    public void Test4() {
        String str1 = "abcde";
        String str2 = "abcde";
        assertEquals(EditDistance.minDistance(str1,str2), 0);
    }

    @Test
    public void Test5() {
        String str1 ="MICHAELANGELO";
        String str2 = "HIEROGLYPHOLOGY";
        assertEquals(EditDistance.minDistance(str1,str2), 18);
    }

}
