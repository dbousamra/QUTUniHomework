package parameterPassing;

/* A brief demonstration of passing an object as a parameter,
 * to show that the argument in the calling program is
 * affected by changes made in the called method
 */

public class CallByReference {

	private static void doubleIt(Value b) {
		System.out.printf("Before doubling: b = %d%n", b.value);
		b.doubleIt();
		System.out.printf("After doubling:  b = %d%n", b.value);
	}

	public static void main(String[] args) {
		Value a = new Value(10);
		System.out.printf("Before calling:  a = %d%n", a.value);
		doubleIt(a);
		System.out.printf("After calling:   a = %d%n", a.value);
	}

}

class Value {
	public int value;

	public Value(int val) {
		value = val;
	}

	public void doubleIt() {
		value *= 2;
	}

}
