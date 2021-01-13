public class Radix{


    public static int nth(int n, int col){
//get nth digit of an int, where 0 is the ones column, 1 is the tens
      int temp =  (int) (n / Math.pow(10,col) );
      int ans = (int) ( temp % 10);
    //  int ans = (int) Math.round( (n / (Math.pow(10,col) ) ) % (Math.pow(10,col) ) );
      return ans;

    }

    public static int length(int n){
//return the number of digits in n
      int ans = (int) (Math.log10(n));
      return ans+1;
    }

    public static void merge(MyLinkedList original, MyLinkedList[] buckets){
//merge all the linked lists in the bucket array into your original linked list
      String filler = "";
    }


}
