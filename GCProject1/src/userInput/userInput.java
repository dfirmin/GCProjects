package userInput;

import java.util.ArrayList;
import java.util.Scanner;

public class userInput {
	static ArrayList<String> userAnswer = new ArrayList<String>();

	private static ArrayList<String> getNumbers() {
		Scanner userNumbers = new Scanner(System.in);
		int a = 0;
		int b = 0;
		String stringA = null;
		String stringB = null;

		while (a <= 0) { // obtains first number from user and converts to string
			System.out.println("Type first number");
			a = userNumbers.nextInt();
			if (a <= 0) {
				System.out.println("Enter a valid number");
			} else {
				stringA = Integer.toString(a);
			}
		}

		while (b <= 0) { // obtains first number from user and converts to string
			System.out.println("Type second number");
			b = userNumbers.nextInt();
			if (b <= 0) {
				System.out.println("Enter a valid number");
			} else {
				stringB = Integer.toString(b);
			}
			if (stringA.length() != stringB.length()) {
				System.out.println("Both numbers should have the same numbers of digits");
			}
			userAnswer.add(stringA);// adds first number obtained to an array
			userAnswer.add(stringB);// adds second number to array
			userNumbers.close();

		}
		System.out.println("Your numbers are " + userAnswer.get(0) + " and " + userAnswer.get(1));
		return userAnswer;// return array additions to class variable, I decided to use an array instead
							// of two separate methods.

	}

	public static void checkAnswer() {
		ArrayList<Integer> checkArray = new ArrayList<Integer>();
		Boolean allEquals = true;// will change to false if numbers to not add up to same number
		String a = userAnswer.get(0);// pulling numbers that were obtained from the previous method
		String b = userAnswer.get(1);// pulling numbers that were obtained from the previous method
		char[] ListA = new char[a.length()];// using char array to check the first digit of each number
		char[] ListB = new char[a.length()];

		for (int i = 0; i < a.length(); i++) {// looping through the numbers obtained to get each digit
			ListA[i] = a.charAt(i);
			for (int j = 0; j < b.length(); j++) {
				ListB[j] = b.charAt(j);
			}
		}
		for (int number = 0; number < ListA.length; number++) {// adding the numbers for each placement
			checkArray.add(Character.getNumericValue(ListA[number]) + Character.getNumericValue(ListB[number]));

		}

		for (int i = 1; i < checkArray.size(); i++) {// if numbers are not equal, system will print false
			if (checkArray.get(i - 1) != checkArray.get(i)) {
				allEquals = false;
			}
		}
		System.out.println(checkArray);
		System.out.println(allEquals);

	}

	public static void main(String[] args) {
		getNumbers();
		checkAnswer();

	}
}
