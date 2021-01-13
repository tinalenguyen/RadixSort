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

    MyLinkedList tester0 = new MyLinkedList();
    MyLinkedList tester1 = new MyLinkedList();

    MyLinkedList[] bucket = {tester1};

    tester0.add("3");
    tester0.add("9");
    tester1.add("56");
    tester1.add("-45");

    Radix.merge(tester0, bucket);
    System.out.println("Merge Test: " + tester0.toString());


  }


}
