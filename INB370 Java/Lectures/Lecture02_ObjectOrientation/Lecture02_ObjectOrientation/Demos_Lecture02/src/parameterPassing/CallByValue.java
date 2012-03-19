package parameterPassing;

/* A brief demonstration of parameter passing by value,
 * to show that the argument in the calling program is
 * unaffected by changes made in the called method
 */

public class CallByValue {

   private static void doubleIt(int b) {
      System.out.printf("Before doubling: b = %d%n", b);
      b *= 2;
      System.out.printf("After doubling:  b = %d%n", b);
   }

   public static void main(String[] args) {
      int a = 10;
      System.out.printf("Before calling:  a = %d%n", a);
      doubleIt(a);
      System.out.printf("After calling:   a = %d%n", a);
   }
}
