import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DateTest {

    @Test
    void ND() {

    }

    @Test
    void ND1() {
        int [] d1 = {1900,12,32};
        //int [] d2 = {1900,1,31};//用例1
        int [] wuxiao = {0,0,0};
        assertArrayEquals(wuxiao,Date.ND(d1));
    }

    @Test
    void ND2() {
        int [] d1 = {2005,12,31};
        int [] d2 = {2006,1,1};//用例2
        assertArrayEquals(d2,Date.ND(d1));
    }
}