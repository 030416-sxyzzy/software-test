import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AP_M_Test {

    static void luan(int[] vb, int[] ve, int[] ep) {
        //把活动的顺序随机打乱，模拟实际的申报顺序
        //vb ve 和 ep 的顺序随机调动
        int t,  n=vb.length;
        int[] vb2=new int[n], ve2=new int[n], ep2=new int[n];
        Integer[] id = new Integer[n];
        for(int i=0; i<n; i++) {
            id[i] = i;
            vb2[i]=vb[i];
            ve2[i]=ve[i];
            ep2[i]=ep[i];
        }
        List<Integer> list = Arrays.asList(id);
        Collections.shuffle(list);
        list.toArray(id);
        for(int i=0; i<n; i++) {
            t = id[i];
            vb[i] = vb2[t];
            ve[i] = ve2[t];
            ep[i] = ep2[t];
        }
    }

    @Test
    void anpaiM_test1() {
        //ep ~ expected results
        int m, epm=1;//安排上1个活动
        int [] vb1 = {30};
        int [] ve1 = {70};
        int [] ep1 = { 1};//1安排 0不排
        int [] ap1 = new int[vb1.length];

        luan(vb1,ve1,ep1);//打乱活动的顺序
        m = AP_M.ApM(vb1, ve1, ap1);
        assertEquals(epm, m);
        assertArrayEquals(ep1, ap1);

        int [] vb2 = {30,20,50, 70, -5,800};
        int [] ve2 = {70,80,75,100, 50,850};
        int [] ep2 = { 1, 0, 0,  0,  0,  0};
        int [] ap2 = new int[vb2.length];
        luan(vb2,ve2,ep2);
        m = AP_M.ApM(vb2, ve2, ap2);
        assertEquals(epm, m);
        assertArrayEquals(ep2, ap2);
    }

    @Test
    void anpaiM_test2() {

        int m,epm=2;
        int [] vb1 = {240, 450};
        int [] ve1 = {295, 520};
        int [] ep1 = {  1,   1};
        int [] ap1 = new int[vb1.length];
        luan(vb1,ve1,ep1);
        m = AP_M.ApM(vb1, ve1, ap1);
        assertEquals(epm,m);
        assertArrayEquals(ep1,ap1);

        int [] vb2 = {240, 450, 250, 280, 460, -10,780};
        int [] ve2 = {295, 520, 330, 400, 550, 100,860};
        int [] ep2 = {  1,   1,   0,   0,   0,   0,  0};
        int [] ap2 = new int[vb2.length];
        luan(vb2,ve2,ep2);
        m = AP_M.ApM(vb2, ve2, ap2);
        assertEquals(epm,m);
        assertArrayEquals(ep2,ap2);

    }

    @Test
    void anpaiM_testn() {

        int m,mep=7;
        int [] vb1 = { 5, 46,115,180,400,600,750};
        int [] ve1 = {45,110,130,220,500,690,800};
        int [] ep1 = { 1,  1,  1,  1,  1,  1,  1};
        luan(vb1,ve1,ep1);
        int[] ap1 = new int[vb1.length];
        m = AP_M.ApM(vb1, ve1, ap1);
        assertEquals(mep,m);
        assertArrayEquals(ep1,ap1);

        int [] vb2 = { 5, 46,115,180,400,600,750,   0, 10, 50,112,200,650,770,760};
        int [] ve2 = {45,110,130,220,500,690,800,  50, 65,120,150,230,730,810,840};
        int [] ep2 = { 1,  1,  1,  1,  1,  1,  1,   0,  0,  0,  0,  0,  0,  0,  0};
        luan(vb2,ve2,ep2);
        int[] ap2 = new int[vb2.length];
        m = AP_M.ApM(vb2, ve2, ap2);
        assertEquals(mep,m);
        assertArrayEquals(ep2,ap2);

    }

}