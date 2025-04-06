import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Date_test2 {

    @ParameterizedTest
    @MethodSource("XiaoYue")
    void test_XiaoYue(int[] d1, int[] d2) {
        assertArrayEquals(d2, Date.ND(d1));
    }

    static Stream<Arguments> XiaoYue() {
        return Stream.of(          //     输入日期                预期输出
                Arguments.arguments(new int[]{2015, 4, 1}, new int[]{2015, 4, 2}),
                Arguments.arguments(new int[]{2015, 9,12}, new int[]{2015, 9,13}),
                Arguments.arguments(new int[]{2015, 6,29}, new int[]{2015, 6,30}),
                Arguments.arguments(new int[]{2015,11,29}, new int[]{2015,11,30}),
                Arguments.arguments(new int[]{2015, 4,30}, new int[]{2015, 5, 1}),
                Arguments.arguments(new int[]{2015, 6,30}, new int[]{2015, 7, 1}),
                Arguments.arguments(new int[]{2015, 9,30}, new int[]{2015,10, 1}),
                Arguments.arguments(new int[]{2015,11,30}, new int[]{2015,12, 1}),
                Arguments.arguments(new int[]{2015, 4,31}, new int[]{0, 0, 0}),
                Arguments.arguments(new int[]{2015, 6,31}, new int[]{0, 0, 0}),
                Arguments.arguments(new int[]{2015, 9,31}, new int[]{0, 0, 0}),
                Arguments.arguments(new int[]{2015,11,31}, new int[]{0, 0, 0})
        );
    }

    @ParameterizedTest
    @CsvSource({"1,1, 1,2",   "7,9,  7,10",
            "1,30,   1,31",   "1,31,  2,1",
            "3,30,   3,31",   "3,31,  4,1",
            "5,30,   5,31",   "5,31,  6,1",
            "7,30,   7,31",   "7,31,  8,1",
            "8,30,   8,31",   "8,31,  9,1",
            "10,30, 10,31",   "10,31, 11,1",
            "12,30, 12,31",   "12,31, 1,1",
    })
    void test_DaYue(int m,int d,  int m2,int d2) {
        int[] date = {2005, m, d};
        int[] expe = {2005,m2,d2};

        if (m==12 && d==31)
            expe[0]++;

        assertArrayEquals(expe, Date.ND(date));
    }





    static Stream<Arguments> XiaoYue2() {
        //这里与XiaoYue类似
        //d ~ input date,     r ~ result
        int[] d1={2015, 4, 1}, r1={2015, 4, 2};
        int[] d2={2015, 9,12}, r2={2015, 9,13};
        int[] d3={2015, 6,29}, r3={2015, 6,30};
        int[] d4={2015,11,29}, r4={2015,11,30};

        int[] d5={2015, 4,30}, r5={2015, 5, 1};
        int[] d6={2015, 4,31}, r6={0,0,0};

        int[] d7={2015, 6,30}, r7={2015, 7, 1};
        int[] d8={2015, 6,31}, r8={0,0,0};

        int[] d9={2015, 9,30}, r9={2015,10, 1};
        int[] d10={2015,9,31}, r10={0,0,0};

        int[] d11={2015,11,30},r11={2015,12,1};
        int[] d12={2015,11,31},r12={0,0,0};

        return Stream.of(
                Arguments.arguments(d1, r1),
                Arguments.arguments(d2, r2),
                Arguments.arguments(d3, r3),
                Arguments.arguments(d4, r4),
                Arguments.arguments(d5, r5),
                Arguments.arguments(d6, r6),
                Arguments.arguments(d7, r7),
                Arguments.arguments(d8, r8),
                Arguments.arguments(d9, r9),
                Arguments.arguments(d10, r10),
                Arguments.arguments(d11, r11),
                Arguments.arguments(d12, r12)
        );
    }
}
