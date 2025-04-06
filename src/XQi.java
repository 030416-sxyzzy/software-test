public class XQi {

    public static int pao(int[] A, int[] B, int qa, int[][] ju)
    {
        int res;//result 结果

        res = pao1(A,B,qa,ju);
        //res = pao2(A,B,qa,ju);
        //res = pao3(A,B,qa,ju);

        return res;
    }

    public static int pao1(int[] A, int[] B, int qa, int[][] ju)
    {
        //代码写这里 1行走，2吃子，3xx
        int ya = A[0];
        int xa = A[1];
        int yb = B[0];
        int xb = B[1];
        int qb = ju[yb][xb];  // 目标位置的棋子

        if (ya == yb && xa == xb) {
            System.out.println("炮A和B位置重合，无法走！");
            return -1;
        }
        // 检查是否有敌我方重复的情况，炮不能吃自己方的棋子
        if ((qa > 0 && qb > 0) || (qa < 0 && qb < 0)) {
            System.out.println("炮A炮B是友军不能走！");
            return -1;
        }

        // 判断炮是否在同一行或列
        if (ya == yb || xa == xb) {
            // 确定是否越过棋子：炮吃子时必须有棋子阻隔
            int step_y = (yb - ya) > 0 ? 1 : (yb - ya) < 0 ? -1 : 0;
            int step_x = (xb - xa) > 0 ? 1 : (xb - xa) < 0 ? -1 : 0;

            int x = xa + step_x;
            int y = ya + step_y;

            int blocker = 0; // 用来记录是否有棋子阻挡
            while (x != xb || y != yb) {
                if (ju[y][x] != 0) { // 如果遇到棋子
                    blocker++;
                }
                x += step_x;
                y += step_y;
            }

            if (blocker == 1 && qb != 0) { // 如果越过了1个棋子并且目标位置有棋子
                return 2; // 合法吃子
            } else if (blocker == 0 && qb == 0) {
                // 走到一个空位置但没有吃子
                return 1; // 合法走法
            } else {
                System.out.println("炮A和B之间的路径不符合规则，无法走！");
                return -1; // 路径不符合规则
            }
        } else {
            System.out.println("炮A和B必须在同一行或列上！");
            return -1; // 不在同一行或列上
        }
    }
    
    public static int pao2(int[] A, int[] B, int qa, int[][] ju) {
        int xa = A[0], ya = A[1];  // 起始位置 A
        int xb = B[0], yb = B[1];  // 目标位置 B
        int qb = ju[yb][xb]; // B 点的棋子

        // 判断是否是友军
        if ((qa > 0 && qb > 0) || (qa < 0 && qb < 0)) {
            System.out.println("棋A棋B是友军不能走！");
            return -1;
        }

        int count = 0; // 计数中间的棋子数量
        if (ya == yb) { // 同行
            int start = Math.min(xa, xb);
            int end = Math.max(xa, xb);
            for (int i = start + 1; i < end; i++) {
                if (ju[ya][i] != 0) {
                    count++;
                }
            }
        } else if (xa == xb) { // 同列
            int start = Math.min(ya, yb);
            int end = Math.max(ya, yb);
            for (int i = start + 1; i < end; i++) {
                if (ju[i][xa] != 0) {
                    count++;
                }
            }
        } else {
            System.out.println("炮A和B点应该同行/列！");
            return -1;
        }

        if (qb == 0 && count != 0) { // 移动时中间不能有棋子
            System.out.println("中间有棋子挡路！");
            return -1;
        }

        if (qb != 0 && count != 1) { // 吃子时中间必须隔一个棋子
            System.out.println("吃子时中间必须隔一个棋子！");
            return -1;
        }

        return 1; // 合法操作
    }

}
