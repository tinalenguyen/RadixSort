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
  }


}
