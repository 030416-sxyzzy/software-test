// test
public class AP_M {

    static public int ApM(int[] vb, int[] ve, int[] ap) {
        int m = 0;
        //m = ApM_b6(vb,ve,ap);

        //m = ApM_1a(vb,ve,ap);
        m = ApM_1b(vb,ve,ap);

        return m;
    }

    static public int ApM_b6(int[] vb, int[] ve, int[] ap) {
        return 1;
    }
    static public int ApM_1a(int[] vb, int[] ve, int[] ap) {
        if (vb==null || ve==null || ap==null)  //v~vector
            return -1;
        if (vb.length==0 || ve.length==0 || ap.length==0)
            return -2;
        int L  = vb.length;
        if (L != ve.length || L != ap.length)
            return -3;

        // vap排号范围：1~m
        // 第1个活动排号1，最后1个活动的排号m，取消的活动-1和0
        int[] vap = new int[L];
        int[] vid = new int[L];//活动的初始申请号(排序前) [0,L)

        for (int i=0; i<L; i++) {
            vid[i] = i;//活动初始顺序号
            if(ve[i]<=vb[i])
                return -4;
        }

        int t1,t2,t3;//按ve来排序
        for(int i=0; i<L; i++) {
            boolean canBreak = true;
            for(int j=i; j<L; j++) {
                if(ve[j]<ve[i]) {
                    t1=ve[i];  ve[i]=ve[j];  ve[j]=t1;//替换ve
                    t2=vb[i];  vb[i]=vb[j];  vb[j]=t2;//替换vb
                    t3=vid[i];vid[i]=vid[j];vid[j]=t3;//替换id
                    canBreak = false;
                }
            }
            if (canBreak)
                break;
        }
        //选择排序
//        for (int i = 0; i < L - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < L; j++) {
//                if (ve[j] < ve[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            // 交换ve[i]和ve[minIndex]
//            t1 = ve[i]; ve[i] = ve[minIndex]; ve[minIndex] = t1;
//
//            // 交换vb[i]和vb[minIndex]
//            t2 = vb[i]; vb[i] = vb[minIndex]; vb[minIndex] = t2;
//
//            // 交换vid[i]和vid[minIndex]
//            t3 = vid[i]; vid[i] = vid[minIndex]; vid[minIndex] = t3;
//        }
        //冒泡排序
        for (int i = 0; i < L - 1; i++) {
            for (int j = 0; j < L - i - 1; j++) {
                if (ve[j] > ve[j + 1]) {
                    t1=ve[j];  ve[j]=ve[j+1];  ve[j+1]=t1;//替换ve
                    t2=vb[j];  vb[j]=vb[j+1];  vb[j+1]=t2;//替换vb
                    t3=vid[j];vid[j]=vid[j+1];vid[j+1]=t3;//替换id
                }
            }
        }


        int m=0,t=-1;//进行活动安排，达到最多活动数m个
        for(int i=0; i<L; i++) {
            if(vb[i]<0 || 840<ve[i]) {
                vap[i]=-1;
                continue;
            }
            if(m==0 || t<vb[i]) {
                vap[i]=++m;
                t=ve[i];
            } else
                vap[i]=0;
        }

        for(int i=0; i<L; i++)
            if(vap[i]>0)
                ap[ vid[i] ]=1;
        //  vid[i] 是排序前的活动号

        return m;
    }
    static public int ApM_1b(int[] vb, int[] ve, int[] ap) {
        //检查输入是否合法（空数组，数组长度不一致，数组长度为0）
        if (vb==null || ve==null || ap==null)  //v~vector
            return -1;
        if (vb.length==0 || ve.length==0 || ap.length==0)
            return -2;
        int L  = vb.length;
        if (L != ve.length || L != ap.length)
            return -3;
        // vap排号范围：1~m
        // 第1个活动排号1，最后1个活动的排号m，取消的活动-1和0
        int[] vap = new int[L];
        int[] vid = new int[L];//活动的初始申请号(排序前) [0,L)
        //开始时间应该早于结束时间
        for (int i=0; i<L; i++) {
            vid[i] = i;//活动初始顺序号
            if(ve[i]<=vb[i])
                return -4;
        }
        //按结束时间早的顺序进行冒泡排序
        int t1,t2,t3;//按ve来排序
        for(int i=1; i<L; i++) {
            for(int j=0; j<L-i; j++) {
                if(ve[j+1]<ve[j]) {
                    t1=ve[j];  ve[j]=ve[j+1];  ve[j+1]=t1;//替换ve
                    t2=vb[j];  vb[j]=vb[j+1];  vb[j+1]=t2;//替换vb
                    t3=vid[j];vid[j]=vid[j+1];vid[j+1]=t3;//替换id
                }
            }
        }

        int m=0,t=-1;//进行活动安排，达到最多活动数m个
        //时间范围检查
        for(int i=0; i<L; i++) {
            if(vb[i]<0 || 840<ve[i]) {
                vap[i]=-1;
                continue;
            }//前一天的结束时间要早于当天活动的开始时间
            if(m==0 || t<vb[i]) {
                vap[i]=++m;
                t=ve[i];
            } else
                vap[i]=0;
        }

        for(int i=0; i<L; i++)
            if(vap[i]>0)
                ap[ vid[i] ]=1;
        //  vid[i] 是排序前的活动号

        return m;
    }

}



