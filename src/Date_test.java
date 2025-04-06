import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Date_test {

    //@Test
    public void a_simple_try() {
        int [] d1 = {2015,2,3};
        int [] d2 = {2015,2,4};//用例1
        assertArrayEquals(d2,Date.ND(d1));
        //如果这句不Equal，代码会停止，后面的2个用例不会运行

        int [] d3 = {2017,2,30};
        int [] wuxiao = {0,0,0};//用例2
        assertArrayEquals(wuxiao,Date.ND(d3));

        int [] d4 = {2017,3,31};
        int [] d5 = {2017,4,1};//用例3
        assertArrayEquals(d5,Date.ND(d4));
    }

    @Test//小月
    public void test_xiaoyue() {
        int[]  wuxiao = {0,0,0};

        int[]  d1 = {2015,4,1};
        int[]  d2 = {2015,4,2};
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]= 9; d1[2]=12;
        d2[1]= 9; d2[2]=13;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]= 4; d1[2]=30;
        d2[1]= 5; d2[2]= 1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]= 4; d1[2]=31;
        assertArrayEquals(wuxiao,Date.ND(d1));


        d1[1]= 6; d1[2]=29;
        d2[1]= 6; d2[2]=30;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]= 6; d1[2]=30;
        d2[1]= 7; d2[2]= 1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]= 6; d1[2]=31;
        assertArrayEquals(wuxiao,Date.ND(d1));

        d1[1]=9; d1[2]=30;
        d2[1]=10; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=9; d1[2]=31;
        assertArrayEquals(wuxiao,Date.ND(d1));

        d1[1]=11; d1[2]=29;
        d2[1]=11; d2[2]=30;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=11; d1[2]=30;
        d2[1]=12; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=11; d1[2]=31;
        assertArrayEquals(wuxiao,Date.ND(d1));
    }

    @Test
    public void test_dayue() {
        //da yue
        int[]  d1 = {2015,1,1};
        int[]  d2 = {2015,1,2};
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=5; d1[2]=15;
        d2[1]=5; d2[2]=16;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=1; d1[2]=30;
        d2[1]=1; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=1; d1[2]=31;
        d2[1]=2; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=3; d1[2]=30;
        d2[1]=3; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=3; d1[2]=31;
        d2[1]=4; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=5; d1[2]=30;
        d2[1]=5; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=5; d1[2]=31;
        d2[1]=6; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=7; d1[2]=30;
        d2[1]=7; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=7; d1[2]=31;
        d2[1]=8; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=8; d1[2]=30;
        d2[1]=8; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=8; d1[2]=31;
        d2[1]=9; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=10; d1[2]=30;
        d2[1]=10; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=10; d1[2]=31;
        d2[1]=11; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));

        d1[1]=12; d1[2]=30;
        d2[1]=12; d2[2]=31;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=12; d1[2]=31;
        d2[1]=1; d2[2]=1; d2[0]=2016;
        assertArrayEquals(d2,Date.ND(d1));
    }

    @Test
    public void test_2() {
        //2 yue
        int[]  wuxiao = {0,0,0};
        int[]  d1 = {2015,2,1};
        int[]  d2 = {2015,2,2};
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=12;		d2[2]=13;
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=31;
        assertArrayEquals(wuxiao,Date.ND(d1));
        //2015
        d1[1]=2; d1[2]=28;
        d2[1]=3; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=29;
        assertArrayEquals(wuxiao,Date.ND(d1));
        //1900
        d1[0]=1900;
        d2[0]=1900;

        d1[1]=2; d1[2]=28;
        d2[1]=3; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=29;
        assertArrayEquals(wuxiao,Date.ND(d1));

        //2016
        d1[0]=2016;
        d2[0]=2016;
        d1[1]=2; d1[2]=28;
        d2[1]=2; d2[2]=29;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=2; d1[2]=29;
        d2[1]=3; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=30;
        assertArrayEquals(wuxiao,Date.ND(d1));
        //2000
        d1[0]=2000;
        d2[0]=2000;
        d1[1]=2; d1[2]=28;
        d2[1]=2; d2[2]=29;
        assertArrayEquals(d2,Date.ND(d1));
        d1[1]=2; d1[2]=29;
        d2[1]=3; d2[2]=1;
        assertArrayEquals(d2,Date.ND(d1));
        d1[2]=30;
        assertArrayEquals(wuxiao,Date.ND(d1));
    }

}
