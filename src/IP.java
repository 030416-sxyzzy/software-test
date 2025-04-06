import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class IP{

    public static int Ip(String ip) {

        int r;

        //r = Ip_a3(ip); //10分  分数为一些用例
        // = Ip_b12(ip);//10分  的测试结果打分
        //r = Ip_b15(ip);//8分
        //r = Ip_b16(ip);//10分  以上23-2-4大班代码
        r = Ip_mt(ip);//美团的代码//9分
        //r = Ip_a14(ip);//8分   以下23-2-6大班代码
        //r = Ip_a18(ip);//9分
        //r = Ip_a20(ip);//9分
        //r = Ip_b1(ip); //6分
        //r = Ip_c18(ip);//7分
        return r;

    }

    public static int Ip_new(String ip) {
        if (ip==null)
            return -1;
        int L=ip.length();
        if (L<7 || 15<L)
            return -1;

        int no=0;//o~.
        int[] vio = new int[15];
        for (int i=0; i<L; i++) {
            char c=ip.charAt(i);
            if (c=='.') {
                vio[no]=i;
                no++;
            }
            else if(c<'0' || '9'<c)
                return -1;
        }
        if(no!=3)
            return -1;

        int i1=vio[0], i2=vio[1], i3=vio[2];
        //.ddd   i1=0    ddd. i1=3
        if(i1==0 || 3<i1)
            return -1;

        //dd.d.  2  dd.ddd. 4
        if(i2-i1<2 || 4<i2-i1)
            return -1;

        if(i3-i2<2 || 4<i3-i2)
            return -1;
        //dd.ddd.ddd.
        if(i3+1==L)//len改L
            return -1;

        if(ip.charAt(0)=='.' ||
                ip.charAt(ip.length()-1)=='.')
            return -1;

        String[] arr = ip.split("\\.");
        //...

        return 1;
    }



    public static int Ip_a3(String ip) {
        int i = -1, idx = 0, cnt = 0;
        String[] ipString = new String[4];
        List<Integer> list = new ArrayList<>();
        try {
            while ((i = ip.indexOf(".", i + 1)) != -1) {
                ipString[idx++] = ip.substring(cnt, i);
                cnt = i + 1;
            }
            ipString[idx] = ip.substring(cnt);
            for (String t : ipString) {
                if (t.isEmpty()) {
                    throw new Exception();
                }
                if (t.charAt(0) == '0' && Integer.parseInt(t) != 0) {
                    throw new Exception();
                }
                if (Integer.parseInt(t) < 0 || Integer.parseInt(t) > 255) {
                    throw new Exception();
                }
                boolean flag = false;
                for (int j = 0; j < t.length(); j++) {
                    if (t.charAt(j) != '0') {
                        flag = true;
                        break;
                    }
                }
                if (!flag && t.length() > 1) {
                    throw new Exception();
                }
                list.add(Integer.parseInt(t));
            }
            if (list.get(0) == 0) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            return -1;
        }
        if (list.get(0) >= 1 && list.get(0) <= 127) {
            if (list.get(0) == 10) {
                return 10;
            }
            return 0;
        }
        else if (list.get(0) >= 128 && list.get(0) <= 191) {
            if (list.get(0) == 172 && list.get(1) >= 16 && list.get(1) <= 31) {
                return 11;
            }
            return 1;
        }
        else if (list.get(0) >= 192 && list.get(0) <= 223) {
            if (list.get(0) == 192 && list.get(1) == 168) {
                return 12;
            }
            return 2;
        }
        else if (list.get(0) >= 224 && list.get(0) <= 239) {
            return 3;
        }
        else {
            return 4;
        }
    }

    public static int Ip_b12(String ip) {

        int type = 0;
        boolean legal = false;
        boolean pri = false;
        //分隔符位置没有分析，出现bug
        String[] ipAll = ip.split("\\.");
        if (ipAll.length != 4){
            return -1;
        }else {
            for (String s : ipAll) {
                //0
                if (s.length() > 1 && s.charAt(0) == '0') {
                    return -1;
                }
            }
            int a0,a1,a2,a3;
            try {
                a0 = Integer.parseInt(ipAll[0]);
                a1 = Integer.parseInt(ipAll[1]);
                a2 = Integer.parseInt(ipAll[2]);
                a3 = Integer.parseInt(ipAll[3]);
            }catch (Exception e){
                return -1;
            }

            if(a0 >= 1 && a0<=127  &&a1 >=0 && a1<=255
                    && a2 >= 1 && a2<=255  &&a3 >=0 && a3<=255){//a2>=0
                legal = true;
                if (a0 == 10){
                    pri = true;
                }
            }
            if (a0 >= 128 && a0<=191  &&a1 >=0 && a1<=255
                    && a2 >= 1 && a2<=255  &&a3 >=0 && a3<=255){//a2>=0
                legal = true;
                type = 1;
                if (a0 == 172 && a1 >= 16 &&a1 <= 31) {
                    pri = true;
                }
            }
            if (a0 >= 192 && a0<=223  &&a1 >=0 && a1<=255
                    && a2 >= 1 && a2<=255  &&a3 >=0 && a3<=255){//a2>=0
                legal = true;
                type =2;
                if (a0 == 192 && a1 == 168){
                    pri = true;
                }
            }

            if (a0 >= 224 && a0<=239  &&a1 >=0 && a1<=255
                    && a2 >= 1 && a2<=255  &&a3 >=0 && a3<=255){//a2>=0
                legal = true;
                type = 3;
            }
            if (a0 >= 240 && a0<=255  &&a1 >=0 && a1<=255
                    && a2 >= 1 && a2<=255  &&a3 >=0 && a3<=255){//a2>=0
                legal = true;
                type = 4;
            }
        }
        if (pri)
            type = type+10;
        if (!legal)
            return -1;
        else
            return type;
    }

    public static int Ip_b15(String ip) {
        String[] ipString = ip.split("\\.");
        if (ipString.length != 4) {
            return -1;
        }
        for (String s : ipString) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return -1;
            }
            if (s.charAt(0) == '0' && Integer.parseInt(s) != 0) {
                return -1;
            }
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '0') {
                    flag = true;
                    break;
                }
            }
            if (!flag && s.length() > 1) {
                return -1;
            }
        }
        if (Integer.parseInt(ipString[0]) == 0) {
            return -1;
        }
        int cnt = 0;
        int[] list = new int[4];
        for (String t : ipString) {
            list[cnt++] = Integer.parseInt(t);
        }
        if (list[0] >= 1 && list[0] <= 127) {
            if (list[0] == 10) {
                return 10;
            }
            return 0;
        }
        else if (list[0] >= 128 && list[0] <= 191) {
            if (list[0] == 172 && list[1] >= 16 && list[1] <= 31) {
                return 11;
            }
            return 1;
        }
        else if (list[0] >= 192 && list[0] <= 223) {
            if (list[0] == 192 && list[1] == 168) {
                return 12;
            }
            return 2;
        }
        else if (list[0] >= 224 && list[0] <= 239) {
            return 3;
        }
        else {
            return 4;
        }
    }

    public static int Ip_b16(String ip) {
        if (!Pattern.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)" +
                "\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$", ip))
        {
            return -1;
        }
        String[] ipString = ip.split("\\.");
        int[] list = new int[4];
        int idx = 0;
        for (String t : ipString)
        {
            list[idx++] = Integer.parseInt(t);
        }
        if (list[0] >= 1 && list[0] <= 127)
        {
            if (list[0] == 10)
            {
                return 10;
            }
            return 0;
        }
        else if (list[0] >= 128 && list[0] <= 191)
        {
            if (list[0] == 172 && list[1] >= 16 && list[1] <= 31)
            {
                return 11;
            }
            return 1;
        }
        else if (list[0] >= 192 && list[0] <= 223)
        {
            if (list[0] == 192 && list[1] == 168)
            {
                return 12;
            }
            return 2;
        }
        else if (list[0] >= 224 && list[0] <= 239)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }

    public static int Ip_mt(String ip) {
        boolean legal = true;//美团的代码
        int type = 0;//0-4
        boolean pri = false;
        //7≤n≤15
        if (ip.length() < 7 || ip.length() > 15) {
            legal = false;
            //.左~~~~右. 排除
        } else if(ip.charAt(0)=='.' ||
                ip.charAt(ip.length()-1)=='.') {
            legal = false;
        } else {
            String[] arr = ip.split("\\.");
            //4段中间得有3个. 有四种情况s1.s2.s3.s4   s1s4不空
            //s1...s4  s1.s2..s4  s1..s3.s4   s2s3为空
            if (arr.length != 4) {
                legal = false;
            } else {
                //前导零检查
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].length() > 1 && arr[i].charAt(0) == '0') {
                        legal = false;
                    }
                    //每个字符范围为0~9
                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9') {
                            legal = false;
                        }
                    }
                }                     //  上机四重点测试以上代码
                if (legal) {         //   本行以下代码不做为上机四的测试对象
                    for (int i = 0; i < arr.length; i++) {
                        int temp = Integer.parseInt(arr[i]);
                        if (i == 0) {
                            //s0:1~255   s2-4:0~255
                            if (temp < 1 || temp > 255) {
                                legal = false;
                            }
                        } else {
                            if (temp < 0 || temp > 255) {
                                legal = false;
                            }
                        }
                    }
                }
                if (legal) {
                    int a0 = Integer.parseInt(arr[0]);
                    int a1 = Integer.parseInt(arr[1]);
                    int a2 = Integer.parseInt(arr[2]);
                    int a3 = Integer.parseInt(arr[3]);
                    if (a0 >= 1 && a0 < 128) {
                        type = 0;
                        if (a0 == 10) {
                            pri = true;
                        }
                    } else if (a0 >= 128 && a0 < 192) {
                        type = 1;
                        if (a0 == 172 && a1 >= 16 && a1 < 32) {
                            pri = true;
                        }
                    } else if (a0 >= 192 && a0 < 224) {
                        type = 2;
                        if (a0 == 192 && a1 == 168) {
                            pri = true;
                        }
                    } else if (a0 >= 224 && a0 < 240) {
                        type = 3;
                    } else {
                        type = 4;
                    }
                }
            }
        }
        if (pri)
            type = type+10;
        if (!legal)
            return -1;
        else
            return type;

    }

    public static int Ip_a14(String ip) {

        int type = 0;
        boolean leagal = false;
        boolean pri = false;

        System.out.println(ip);
        String temp [] = ip.split("\\.");


        int temp_len= temp.length;
        if(temp_len!=4)
        {

            return -1;
        }
        else
        {
            //判断是否有前导0
            for(int i=0;i<temp_len;i++)
            {
                if(temp[i].charAt(0)=='0'&&temp[i].length()>1)
                {
                    //含有前导0
                    return -1;
                }
            }
            int temp_1=Integer.parseInt(temp[0]);
            int temp_2=Integer.parseInt(temp[1]);
            int temp_3=Integer.parseInt(temp[2]);
            int temp_4=Integer.parseInt(temp[3]);

            //判断是A类
            if(temp_1>1&&temp_1<127&&temp_2>0&&temp_2<255&&temp_3>0&&temp_3<255&&temp_4>0&&temp_4<255)
            {
                //A类私有
                if(temp_1==10) pri=true;
                leagal=true;

            }
            if(temp_1>128&&temp_1<191&&temp_2>0&&temp_2<255&&temp_3>0&&temp_3<255&&temp_4>0&&temp_4<255)
            {
                type=1;
                if(temp_1==172&&temp_2>16&&temp_2<31) pri=true;
                leagal=true;

            }
            if(temp_1>192&&temp_1<223&&temp_2>0&&temp_2<255&&temp_3>0&&temp_3<255&&temp_4>0&&temp_4<255)
            {
                type=2;
                if(temp_1==192&&temp_2==168) pri=true;
                leagal=true;
            }

            if(temp_1>224&&temp_1<239&&temp_2>0&&temp_2<255&&temp_3>0&&temp_3<255&&temp_4>0&&temp_4<255)
            {
                type=3;
                leagal=true;
            }
            if(temp_1>240&&temp_1<255&&temp_2>0&&temp_2<255&&temp_3>0&&temp_3<255&&temp_4>0&&temp_4<255)
            {
                type=4;
                leagal=true;
            }

        }

        if (pri)
            type = type+10;
        if (!leagal)
            return -1;
        else
            return type;

    }

    public static int Ip_a18(String ip) {

        int type = 0;
        boolean leagal = false;
        boolean pri = false;
        // ...
        if (ip == null) {
            return -1;
        }
        if (ip.length() < 7 || ip.length() > 15) {
            return -1;
        }
        if (ip.charAt(0) == '.' || ip.length() - 1 == '.') {
            return -1;
        }
        String[] c = ip.split("\\.");// 分割字符串
        if (c.length != 4) {
            return -1;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i].length() > 1 && c[i].charAt(0) == '0') {
                return -1;
            }
            for (int k = 0; k < c[i].length(); k++) {
                if (c[i].charAt(k) < '0' || c[i].charAt(k) > '9') {
                    return -1;
                }
            }
        }
        for (int i = 0; i < c.length; i++) {
            int m = Integer.parseInt(c[i]);
            int l = Integer.parseInt(c[1]);
            if (i == 0) {
                if (m < 1 || m > 255) {
                    return -1;
                }
                if (m >= 1 && m <= 127 && m != 10) {
                    type = 0;
                }
                if (m == 10) {
                    type = 10;
                }
                if (m == 172 && l >= 16 && l <= 31) {
                    type = 11;
                }
                if (m >= 128 && m <= 191 && m != 172) {
                    type = 1;
                }
                if (m == 172 && (l < 16 || l > 31)) {
                    type = 1;
                }
                if (m == 192 && l == 168) {
                    type = 12;
                }
                if (m >= 192 && m <= 223 && (m != 192 || l != 168)) {
                    type = 2;
                }
                if (m >= 224 && m <= 239) {
                    type = 3;
                }
                if (m >= 240 && m <= 255) {
                    type = 4;
                }
            } else {
                if (m < 0 || m > 255) {
                    return -1;
                }
            }
        }
        return type;

    }

    public static int Ip_b1(String ip) {

        int type = 0;
        boolean legal = true;
        boolean pri = false;
        Integer ip_0=0,ip_1=0,ip_2=0,ip_3=0;
        Map<String, Integer> variables = new HashMap<>();
        try {
            int index_0 = ip.indexOf(".");
            int index_1 = ip.indexOf(".", index_0 + 1);
            int index_2 = ip.indexOf(".", index_1 + 1);
            ip_0 = Integer.valueOf(ip.substring(0, index_0));
            ip_1 = Integer.valueOf(ip.substring(ip.substring(0, index_0).length() + 1, index_1));
            ip_2 = Integer.valueOf(ip.substring(ip.substring(0, index_1).length() + 1, index_2));
            ip_3 = Integer.valueOf(ip.substring(ip.substring(0, index_2).length() + 1));
            variables.put("ip_0", ip_0);
            variables.put("ip_1", ip_1);
            variables.put("ip_2", ip_2);
            variables.put("ip_3", ip_3);
        }catch (Exception e){
            return -1;
        }


        for (int i = 0; i < 4; i++) {
            String variableName = "ip_" + i;
            String value = String.valueOf(variables.get(variableName));
            String c = String.valueOf(value.charAt(0));
            if (!value.equals("0") && c.equals("0")) {
                System.out.println(value.charAt(0));
                legal = false;
            }
        }
        if (ip_0 >= 1 && ip_0 <= 127 && ip_1 >= 0 && ip_1 <= 255
                && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
            if (ip_0 == 10) pri = true;
        } else if (ip_0 >= 128 && ip_0 <= 191 && ip_1 >= 0 && ip_1 <= 255
                && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
            if(ip_0==172&&ip_1>=16&&ip_1<=31) pri=true;
            type=1;
        } else if (ip_0 >= 192 && ip_0 <= 223 && ip_1 >= 0 && ip_1 <= 255
                && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
            if(ip_0==192&&ip_1==168) pri=true;
            type=2;
        } else if (ip_0 >= 224 && ip_0 <= 239 && ip_1 >= 0 && ip_1 <= 255
                && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
            type=3;
        } else if (ip_0 >= 240 && ip_0 <= 255 && ip_1 >= 0 && ip_1 <= 255
                && ip_2 >= 0 && ip_2 <= 255 && ip_3 >= 0 && ip_3 <= 255) {
            type=4;
        }
        if (pri)
            type = type + 10;
        if (!legal)
            return -1;
        else
            return type;
    }

    public static int Ip_a20(String ip) {

        int type = 0;
        boolean leagal = false;
        boolean pri = false;
        int flag = 0;
        //判断无效
        if(ip.length() < 7 || ip.length() > 15)   return -1;
        for (int i = 0; i < ip.length(); i ++)
        {
            //有前导零
            if(ip.charAt(0) == '0')  return -1;
            if(ip.charAt(i) == '.' && ip.charAt(i + 1) == '0' && ip.charAt(i + 2) != '.')  return -1;
            //判断·的合理性
            if(ip.charAt(i) == '.' && ip.charAt(i + 1) == '.')  return -1;

            if (ip.charAt(i) == '.')  flag++;
            if(i == ip.length() - 1 && flag != 3)  return -1;
        }



        //...
        String array[] = ip.split("\\.");
        int array0 = Integer.parseInt(array[0]);
        int array1 = Integer.parseInt(array[1]);
        int array2 = Integer.parseInt(array[2]);
        int array3 = Integer.parseInt(array[3]);

        //A
        if((array0 >= 1 && array0 <= 127) && (array1 >=0 && array1 <= 255) && (array2 >=0 && array2 <= 255) && (array3 >=0 && array3 <= 255))
        {
            leagal = true;
            type = 0;
            if(array0 == 10) pri = true;
        }
        //B
        if((array0 >= 128 && array0 <= 191) && (array1 >=0 && array1 <= 255) && (array2 >=0 && array2 <= 255) && (array3 >=0 && array3 <= 255))
        {
            leagal = true;
            type = 1;
            if(array0 == 172 && (array1 >= 16 && array1 <= 31) && (array2 >=0 && array2 <=255) && (array3 <= 255 && array3 >= 0)) pri = true;
        }
        //C
        if((array0 >= 192 && array0 <= 223) && (array1 >=0 && array1 <= 255) && (array2 >=0 && array2 <= 255) && (array3 >=0 && array3 <= 255))
        {
            leagal = true;
            type = 2;
            if(array0 == 192 && array1 == 168 && (array2 <= 255 && array2 >=0) && (array3 >=0 && array3 <= 255)) pri = true;
        }
        //D
        if((array0 >= 224 && array0 <= 239) && (array1 >=0 && array1 <= 255) && (array2 >=0 && array2 <= 255) && (array3 >=0 && array3 <= 255))
        {
            leagal = true;
            type = 3;
        }
        //E
        if((array0 >= 240 && array0 <= 255) && (array1 >=0 && array1 <= 255) && (array2 >=0 && array2 <= 255) && (array3 >=0 && array3 <= 255))
        {
            leagal = true;
            type = 4;
        }



        if (pri)
            type = type+10;
        if (leagal == false)
            return -1;
        else
            return type;

    }

    public static int Ip_c18(String ip) {

        int type = 0;
        boolean legal = false;
        boolean pri = false;
        //...
        String[] ip_String=ip.split("\\.");
        int[] ip_Int=new int[ip_String.length];
        for(int i=0;i<ip_String.length;i++){
            ip_Int[i]=Integer.parseInt(ip_String[i]);
            if(ip_String[i].charAt(0)-'0'==0&&ip_String[i].length()>1||ip_Int[i]>255) {
                legal = false;break;}
            else{legal=true;}
        }
        if(1<=ip_Int[0]&&ip_Int[0]<=127){
            if(ip_Int[0]==10){
                pri=true;
            }
        }
        else if(128<=ip_Int[0]&&ip_Int[0]<=191){
            type=1;
            if(ip_Int[0]==172){
                pri=true;
            }
        }
        else if(192<=ip_Int[0]&&ip_Int[0]<=223){
            type=2;
            if(ip_Int[0]==192){
                pri=true;
            }
        }
        else if(224<=ip_Int[0]&&ip_Int[0]<=239){
            type=3;
        }
        else if(240<=ip_Int[0]&&ip_Int[0]<=255){
            type=4;
        }
        if (pri)
            type = type+10;
        if (!legal)
            return -1;
        else
            return type;

    }

}
