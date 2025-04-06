//每次加入1个bug，跑用例测试。记录结果之后，改正确。
//重复以上过程ND1跑8-10次。
//然后跑ND2的测试跑8-10次。
//如果代码乱了，可以把Datezzz的代码复制过来，删“zzz”。
//Datezzz的代码不要动，保持完全正确。

public class Date {

    public static int[] ND(int[] date)
    {//每次要搞清楚，测试的是ND1，还是ND2。
        //return ND1(date);
        return ND2(date);
    }

    public static int[] ND1(int[] date)
    {//P115
        int y,m,d;// input
        int y2,m2,d2;// output
        int [] wuxiao = {0,0,0};

        y = date[0];
        m = date[1];
        d = date[2];
        y2 = y; m2 = m;	d2 = d;
        //------- 请在以下范围内 编写计算下一天的代码。
        //（假设输入的日期都是1-12 1-31的）
        int lastday=28;//计算某个月的月末日期
        if((m%2==1&& m<=8)||(m%2==0 && m>=8))
            lastday=31;
        else if(m==4 || m==6 || m==9 || m==11)
            lastday=30;
        else {

            if((y%4==0&&y%100!=0)||y%400==0)
                lastday=29;
            else
                lastday=28;
        }

        if(d == lastday)//月末日期
        {
            d2=1;
            if(m==12)//年末日期
            {
                m2=1;
                y2++;
            }
            else //月末日期
                m2++;
        }
        else if (d > lastday)
        {
            return wuxiao;
        }
        else //普通日期
            d2++;

        int[] date2 = {y2,m2,d2};
        return date2;
    }

    public static int[] ND2(int[] date)
    {//简单代码
        int y,m,d;// input
        int y2,m2,d2;// output
        int [] wuxiao = {0,0,0};

        y = date[0];
        m = date[1];
        d = date[2];
        y2 = y; m2 = m;	d2 = d;

        //------- 请在以下范围内 编写计算下一天的代码。
        //（假设输入的日期都是1-12 1-31的）
        if (m==1||m==3||m==5||m==7||m==8||m==10) {
            if (d<31)
                d2++;
            else {
                d2=1; m2++; }
        }

        if (m==4||m==6||m==9||m==11) {
            if (d<30)
                d2++;
            else if (d==30) {
                d2=1; m2++; }
            else if (d>30)
                return wuxiao;
        }


        if (m==12) {
            if (d<31)
                d2++;
            else { //
                d2=1; m2=1; y2++; }
        }

        if (m==2) {
            //if (y%4==0)  {//
            if ((y%4==0 && y%100!=0) || y%400==0) {
                if (d<29) //d2 yu d
                    d2++;
                else if (d==29){
                    d2=1; m2=3;}
                else if (d>29)
                    return wuxiao;
            } else {
                if (d<28)
                    d2++;
                else if (d==28){
                    d2=1; m2=3; }
                else if (d>28)
                    return wuxiao;
            }
        }

        //-------

        int[] date2 = {y2,m2,d2};
        return date2;
    }
}
