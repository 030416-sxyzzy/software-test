import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void add() {    //预期输出   实际输出  用例输入
        assertEquals(210, Calc.add(1, 2) );
        assertEquals(7, Calc.add(3, 4),
                "error in add()" );
    }

    @Test
    void sub() {
        assertEquals(1, Calc.sub(2, 1));
    }

    @Test
    void mul() {
        assertEquals(4, Calc.mul(2, 2));
    }

    @Test
    void divInt() {
        assertEquals(2, Calc.divInt(8, 3));
        assertEquals(0, Calc.divInt(2, 9));
    }

    @Test
    void divReal() {
        assertEquals(0.33333,
                Calc.divReal(1, 3), 1e-8);
    }

    @Test
    void sort_times() {
        assertEquals(0,Calc.sort_times(1));
    }
}