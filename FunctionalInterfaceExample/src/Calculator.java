
@FunctionalInterface
interface Calculation {    
	public abstract int calculate(int a, int b);
}




public class Calculator {
	public static void main(String[] args) {
		Calculation addition = (a, b) -> a + b;
		int sum = addition.calculate(5, 7);
		System.out.println("addition(5,7): "+ sum);

		Calculation subraction = (a, b) -> a - b;
		int diff = subraction.calculate(5, 3);
		System.out.println("subraction(5,3): "+ diff);

		Calculation multiply = (a, b) -> a * b;
		int prod = multiply.calculate(5, 3);
		System.out.println("multiplication(5,3): "+ prod);

		Calculation divide = (a, b) -> a / b;
		int div = divide.calculate(10, 5);
		System.out.println("division(10,3): "+ div);
		

		Calculation modulus = (a, b) -> a % b;
		int mod = modulus.calculate(10, 5);
		System.out.println("modulus(10,5):" + mod);
}
}



