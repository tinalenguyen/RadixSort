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
      int longestLength = 0;

      for (int i = 0 ; i < data.size() ; i++){
        if (length(data.get(i)) > longestLength ) longestLength = length(data.get(i));
      }

      for (int i = 0 ; i < longestLength ; i++){
        SortableLinkedList bucket0 = new SortableLinkedList();
        SortableLinkedList bucket1 = new SortableLinkedList();
        SortableLinkedList bucket2 = new SortableLinkedList();
        SortableLinkedList bucket3 = new SortableLinkedList();
        SortableLinkedList bucket4 = new SortableLinkedList();
        SortableLinkedList bucket5 = new SortableLinkedList();
        SortableLinkedList bucket6 = new SortableLinkedList();
        SortableLinkedList bucket7 = new SortableLinkedList();
        SortableLinkedList bucket8 = new SortableLinkedList();
        SortableLinkedList bucket9 = new SortableLinkedList();

        for (int j = 0 ; j < data.size() ; j++){
          if (nth(data.get(j),i) == 0) bucket0.add(data.get(j));
          else if (nth(data.get(j),i) == 1) bucket1.add(data.get(j));
          else if (nth(data.get(j),i) == 2) bucket2.add(data.get(j));
          else if (nth(data.get(j),i) == 3) bucket3.add(data.get(j));
          else if (nth(data.get(j),i) == 4) bucket4.add(data.get(j));
          else if (nth(data.get(j),i) == 5) bucket5.add(data.get(j));
          else if (nth(data.get(j),i) == 6) bucket6.add(data.get(j));
          else if (nth(data.get(j),i) == 7) bucket7.add(data.get(j));
          else if (nth(data.get(j),i) == 8) bucket8.add(data.get(j));
          else bucket9.add(data.get(j));

        }
        SortableLinkedList[] buckets = {bucket1,bucket2,bucket3,bucket4,bucket5,bucket6,bucket7,bucket8,bucket9};
        merge(bucket0, buckets);
        //clear data
        int h = data.size()-1;
        while (h >=0){
          data.remove(h);
          h--;
        }
        //combine for sorting again
        data.extend(bucket0);
    }
  }


    public static void radixSort(SortableLinkedList data){
//sorts any interger value
        radixSortSimple(data);
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

        int o = data.size()-1;
        while (o >=0){
          data.remove(o);
          o--;
        }
        //data is empty now
        for (int e = negBucket.size()-1 ; e >=0 ; e--){
          data.add(negBucket.get(e)*-1);

        }
        data.extend(posBucket);

    }
}
