import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IPTest {
    @ParameterizedTest//加用例
    @CsvSource({"1.4.6", "231.233.254.26.7", //n<7,n>15
            "2.4.34.56.", ".21.8.5.3 ",//分隔符位置在最左边/右边
            "255.233.21","38.24.23.43.2",//分割后的长度不为4
            "3...255","23.21..13","3..23.32",//分割后长度为4
            "1155.200.178.115","0.0.0.0",//数字超出范围
            "012.1.1.1 ", "1.1.1.09 ",//前导零
            "10.1.1.a","2.2.2.,"//特殊字符
            })
    void test_IP_false(String s) {
        //无效地址，返回负数
        assertEquals(-1,IP.Ip(s));
    }
    @ParameterizedTest//加用例
    @CsvSource({"192.168.0.2,  12",//C类私有
            "127.1.1.1,  0",//A类
            "191.3.2.255,  1",//B类
            "192.255.1.1,  2",//C类
            "10.0.1.0,  10",//A类私有
            "172.16.0.255,  11",//B类私有
            "224.23.43.1,  3",//D类
            "255.255.255.255,  4"//E类
    })
    void test_IP_true(String s, int r) {
        //A类返回0，B~1，C~2，D~3，E~4
        //私有地址+10，分别是 10，11，12
        assertEquals(r,IP.Ip(s));
    }
}