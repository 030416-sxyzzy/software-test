import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class IPC23Test {

    @Test
    void IP_type() {

        String s1 = "192.168.0.2";
        assertEquals(12, IP_c23.IP_type(s1));
        String s2 = "010.220.0.3";
        assertEquals(-1, IP_c23.IP_type(s2));
        String s3 = "127.255.255.255";
        assertEquals(0, IP_c23.IP_type(s3));
        String s4 = "172.16.0.0";
        assertEquals(11, IP_c23.IP_type(s4));
        String s5 = "192.167.0.0";
        assertEquals(2, IP_c23.IP_type(s5));
        String s6 = "255.168.0";
        assertEquals(-1, IP_c23.IP_type(s6));
        String s7 = "255.255.255.255";
        assertEquals(4, IP_c23.IP_type(s7));
    }
}