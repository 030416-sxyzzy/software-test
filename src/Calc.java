/**
 * The Calculator class provides static methods for
 *  arithmetic operations on two integers.
 */
public class Calc {
    public static int add(int n1, int n2) {
        if (n1<0)
            n1 = -n1;
        if (n2<0)
            n2 = -n2;

        return n1 + n2;
    }

    public static int sub(int n1, int n2) {
        return n1 - n2;
    }

    public static int mul(int n1, int n2) {
        return n1 * n2;
    }

    // Integer divide. Return a truncated int.
    public static int divInt(int n1, int n2) {
        if (n2 == 0) //
            //throw new ArithmeticException("/ by zero");
            //return 0;
            throw new IllegalArgumentException("/ by zero");

        return n1 / n2;

    }

    // Real number divide. Return a double.
    public static double divReal(int n1, int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Cannot divide by 0!");
        }
        return (double) n1 / n2;
    }

    public static int sort_times(int n) {
        int[] a = new int[n];
        int i,j,temp, k=0;

        for(i=0; i<n; i++)
            a[i] = (int) (Math.random() * n);
        for(i=0; i<n; i++) {
            boolean ok = true;
            for (j=i+1; j<n; j++, k++)
                if (a[j] < a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    ok = false;
                }
            if(ok)
                break;
        }

        return k;
    }

}