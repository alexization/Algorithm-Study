import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int number = 0;
		for (int i = 0; i < 3; i++) {
			String value = sc.nextLine();
			int temp = (int) value.charAt(0);
			if (temp == 70 || temp == 66) continue;
			number = Integer.parseInt(value) + (3 - i);
		}
		
		if (number % 3 == 0) {
			if (number % 5 == 0) System.out.println("FizzBuzz");
			else System.out.println("Fizz");
		} else if (number % 5 == 0) System.out.println("Buzz");
		else System.out.println(number);
		
		sc.close();
	}
}