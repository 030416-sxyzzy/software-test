import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XQiTest {

    @Test
    void pao() {
        int qa, r;
        int[] A=new int[2], B=new int[2];

/* 后面提供了ju和ju2两个棋局。
 如果A选用棋局上的炮，则每个用例要特定的棋局，上机练习比较麻烦。
 本代码运行时，强行在ju中加入炮A，安排在棋局上的某空位上。
 输入炮A的棋子号qa：2炮 / -2砲。A也可以加在有棋子的位置。   */
        //横线-0子-无
        A[0]=2; A[1]=2;
        B[0]=2; B[1]=6;
        r = XQi.pao(A, B, -2, ju);
        assertEquals(1,r);
        //横线-0子-友
        A[0]=7; A[1]=2;
        B[0]=7; B[1]=7;
        r = XQi.pao(A, B, 2, ju);
        assertEquals(-1,r);
        //横线-0子-敌
        A[0]=2; A[1]=3;
        B[0]=2; B[1]=7;
        r = XQi.pao(A, B, 2, ju);
        assertEquals(-1,r);
        //纵线-1子-无
        A[0]=2; A[1]=4;
        B[0]=5; B[1]=4;
        r = XQi.pao(A, B, -2, ju);
        assertEquals(-1,r);//-1
        //纵线-1子-友
        A[0]=1; A[1]=6;
        B[0]=6; B[1]=6;
        r = XQi.pao(A, B, 2, ju);
        assertEquals(-1,r);
        //纵线-1子-敌
        A[0]=2; A[1]=4;
        B[0]=6; B[1]=4;
        r = XQi.pao(A, B, -2, ju);
        assertEquals(2,r);//2
        //斜线-0子-友
        A[0]=8; A[1]=5;
        B[0]=6; B[1]=4;
        r = XQi.pao(A, B, 2, ju);
        assertEquals(-1,r);
        //横线-多子-无
        A[0]=3; A[1]=1;
        B[0]=3; B[1]=7;
        r = XQi.pao(A, B, -2, ju);
        assertEquals(-1,r);//-1
        //AB重合
        A[0]=3; A[1]=1;
        B[0]=3; B[1]=1;
        r = XQi.pao(A, B, 2, ju);
        assertEquals(-1,r);//-1

    }
    static int[][] ju = { //y10 x9         y  yx
            {-3,-4,-5,-6,-7,-6,-5,-4,-3},//0  00 01 02 03
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//1
            { 0,-2, 0, 0, 0, 0, 0,-2, 0},//2
            {-1, 0,-1, 0,-1, 0,-1, 0,-1},//3
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//4
//  x         0  1  2  3  4  5  6  7  8
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//5
            { 1, 0, 1, 0, 1, 0, 1, 0, 1},//6
            { 0, 2, 0, 0, 0, 0, 0, 2, 0},//7
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//8
            { 3, 4, 5, 6, 7, 6, 5, 4, 3} //9   90 91 92 93
    };

    static int[][] ju2 = { //y10 x9        y  yx
            {-3, 0, 0,-6,-7,-6,-5, 0, 0},//0  00 01 02 03
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//1
            { 0, 0,-4, 0,-5, 0,-4,-2, 0},//2
            {-1, 0,-1, 0,-1, 0, 0, 3, 0},//3
            { 0, 0, 0,-3, 0, 0,-1, 0,-1},//4
//  x         0  1  2  3  4  5  6  7  8
            { 0, 0, 1, 0, 0, 3, 5, 0, 0},//5
            { 1,-2, 0, 0, 1, 0, 1, 0, 1},//6
            { 0, 2, 4, 0, 0, 0, 0, 2, 0},//7
            { 0, 0, 0, 0, 0, 0, 0, 0, 0},//8
            { 0, 0, 0, 6, 7, 6, 5, 4, 0} //9   90 91 92 93
    };

}