import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


class BinSTest {

    int[] ar1 = {1}, ar2 = {1,9};
    int[] ar3 = {0,3,6,8,9,13,25};
    int[] vk3 = {-1,5,10,30,   0,6,13,25};
    int[] vj3 = {-1,-1,-1,-1,   0,2,5,7};
    int[] ar4 = {-55,-6,13,47,69,70,71,89,96,134,259};

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    void test_ar3_VS(int a) {
        assertEquals(vj3[a], BinS.binS(ar3,vk3[a]));
    }

    @ParameterizedTest//ar1={1};
    @CsvSource({"-3, -1",  "1, 0",  "5, -1"})
    void test_ar1(int k,int ep)  {
        assertEquals(ep, BinS.binS(ar1,k));
    }

    @ParameterizedTest//ar2={1,9};
    @CsvSource({"-3, -1",  "1, 0",  "5, -1",  "9, 1",  "15, -1"})
    void test_ar2(int k,int ep)  {
        assertEquals(ep, BinS.binS(ar2,k));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, -1",  "5, -1",  "10, -1",  "30, -1",
            "0,   0",  "6,  2",  "13,  5",  "25,  6"
    })//ar3={0,3,6,8,9,13,25};{-1,5,10,30,   0,6,13,25}
    void test_ar3(int k,int ep)  {
        assertEquals(ep, BinS.binS(ar3,k));
    }

    @ParameterizedTest
    @CsvSource({
            "-60, -1","0, -1","50, -1","80, -1","99, -1","270, -1",
            "-55,  0","-6, 1","69,  4","71,  6","134, 9","259, 10"
    })//ar4={-55,-6,13,47,69,70,71,89,96,134,259};
    void test_ar4(int k,int ep)  {
        assertEquals(ep, BinS.binS(ar4,k));
    }
}

/*
    @Test
    void test() {
        //{1}
        assertEquals(-1, BinS.binS(ar1,-3));
        assertEquals(0, BinS.binS(ar1,1));
        assertEquals(-1, BinS.binS(ar1,5));
        //{1,9}
        assertEquals(-1, BinS.binS(ar2,-3));
        assertEquals(0, BinS.binS(ar2,1));
        assertEquals(-1, BinS.binS(ar2,5));
        assertEquals(1, BinS.binS(ar2,9));
        assertEquals(-1, BinS.binS(ar2,12));
        //{1,3,7,8,9,12,15,19} -1
        assertEquals(-1, BinS.binS(ar3,5));
        assertEquals(-1, BinS.binS(ar3,10));
        assertEquals(-1, BinS.binS(ar3,-5));
        assertEquals(-1, BinS.binS(ar3,25));
        //{1,3,7,8,9,12,15,19}  j
        assertEquals(2, BinS.binS(ar3,7));
        assertEquals(5, BinS.binS(ar3,12));
        assertEquals(0, BinS.binS(ar3,1));
        assertEquals(7, BinS.binS(ar3,19));
    }
*/

