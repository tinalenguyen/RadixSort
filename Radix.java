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

    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
//merge all the linked lists in the bucket array into your original linked list
      int i = 0;
      while (i<buckets.length){
        original.extend(buckets[i]);
        i++;
      }
    }

    public static void radixSortSimple(SortableLinkedList data){
//sorts non negative integer values / assume there are no negative values
      int longestLength = 1;
      SortableLinkedList[] buckets = new SortableLinkedList[10];
        for (int c = 0 ; c < buckets.length ; c++) {
          buckets[c] = new SortableLinkedList();
        }
    //  for (int i = 0 ; i < longestLength ; i++){
        int i = 0 ;
        while (i < longestLength){
        while (0 < data.size()){
          if (length(data.get(0)) > longestLength && i==0) {
            longestLength = length(data.get(0));
          }
          int bucketer = nth(data.get(0), i);
          buckets[bucketer].add(data.get(0));

          data.remove(0);

        }
        merge(data, buckets);
        i++;
    }
  }


    public static void radixSort(SortableLinkedList data){
//sorts any interger value
        SortableLinkedList negBucket = new SortableLinkedList();
        SortableLinkedList posBucket = new SortableLinkedList();


        for (int i = 0 ; i < data.size() ; i++){
          if (data.get(i) < 0){
            negBucket.add(data.get(i)*-1);
        }
        else if (data.get(i) >=0) posBucket.add(data.get(i));

        }

        radixSortSimple(negBucket);
        radixSortSimple(posBucket);

        for (int p = data.size()-1 ; p >=0; p--){

          data.remove(p);

        }

        //data is empty now
        for (int e = negBucket.size()-1 ; e >=0 ; e--){
          data.add(negBucket.get(e)*-1);

        }
       data.extend(posBucket);

    }
}
