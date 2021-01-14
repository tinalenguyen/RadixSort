public class RadixTester{

  public static void main(String[] args){
    int x = 123456;
    int y = 987;
    int z = 783466;

    Radix test = new Radix();
    System.out.println(test.nth(x, 3));
    System.out.println(test.nth(y, 2));
    System.out.println(test.nth(z, 5));

    System.out.println(test.length(x));
    System.out.println(test.length(y));
    System.out.println(test.length(z));

    SortableLinkedList tester0 = new SortableLinkedList();
    MyLinkedList tester1 = new MyLinkedList();

  //  SortableLinkedList[] bucket = {tester1};

    tester0.add(3);
    tester0.add(9);
    tester0.add(-56);
    tester0.add(45);
    tester0.add(0);
    tester0.add(-44);
    tester0.add(45);
    tester0.add(-48);
    tester0.add(-47);
    tester0.add(46);

    Radix.radixSort(tester0);

    System.out.println("radix sort test: " + tester0.toString());


  }


}
