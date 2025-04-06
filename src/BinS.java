public class BinS {
    public  static void main(String[] args){
        int[] arr = {1,9};
        //binSearch0(arr, 19);
    }


    public static int binS(int[] array, int key) {

        return binSearch0(array, key);//ok
        //return binSearch1(array, key);//bug1
        //return binSearch2(array, key);//bug2
        //return binSearch3(array, key);//bug3
        //return binSearch4(array, key);//bug4
    }


    public static int binSearch0(int[] array, int key) {
        int mid, low, high, found;

        low = 0;found=-1;
        high=array.length-1;
        while ( low <= high ) {             //w
            mid = (low+high)/2;
            if ( key == array[mid] ){       //i2
                found = mid;
                break;              }       //b
            else if ( key<array[mid])       //i3
                high = mid;              //t
            else
                low = mid+1 ;              //f
        }
        return found;                       //r
    }

    public static int binSearch00(int[] array, int key) {
        int mid, low, high, found;

        low = 0;found=-1;
        high=array.length-1;//bug1漏了-1
        while ( low <= high ) {//bug2少了=
            mid = (low+high)/2;
            if ( key == array[mid] ){
                found = mid;
                break;              }
            else if ( key<array[mid])
                high = mid-1;//少-1 bug3
            else
                low = mid + 1;//少+1 bug4
        }

        return found;
    }

    public static int binSearch1 (int[] array, int key) {
        int mid, low, high, found;
        low = 0;//0
        high = array.length;  //length-1
        found=-1;

        while ( low <= high ) {
            mid = (low+high)/2;
            if ( key == array[mid] ) {
                found = mid;
                break;
            }
            else if ( key < array[mid] )
                high = mid -1;
            else
                low = mid + 1;
        }

        return found;
    }

    public static int binSearch2 (int[] array, int key) {
        int mid, low, high, found;
        low = 0;
        high = array.length-1;
        found=-1;

        while ( low < high ) {  // <=
            mid = (low+high)/2;
            if ( key == array[mid] ) {
                found = mid;
                break;
            }
            else if ( key < array[mid] )
                high = mid -1;
            else
                low = mid + 1;
        }

        return found;
    }

    public static int binSearch3 (int[] array, int key) {
        int mid, low, high, found;
        low = 0;
        high = array.length - 1;
        found=-1;

        while ( low <= high ) {
            mid = (low+high)/2;
            if ( key == array[mid] ) {
                found = mid;
                break;
            }
            else if ( key < array[mid] )
                high = mid;  //mid-1
            else
                low = mid+1;
        }

        return found;
    }

    public static int binSearch4 (int[] array, int key) {
        int mid, low, high, found;
        low = 0;
        high = array.length - 1;
        found=-1;

        while ( low <= high ) {
            mid = (low+high)/2;
            if ( key == array[mid] ) {
                found = mid;
                break;
            }
            else if ( key < array[mid] )
                high = mid-1;
            else
                low = mid;  //mid+1
        }

        return found;
    }

}

