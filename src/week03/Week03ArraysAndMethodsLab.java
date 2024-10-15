package week03;

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {

		String hl = "--------------------------";

		//
		// Arrays:
		//

		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
		int[] firstArray = { 1, 5, 3, 8, 13, 6 };

		// 2. Print out the first element in the array
		System.out.println(firstArray[0]);

		// 3. Print out the last element in the array without using the number 5
		System.out.println(firstArray[firstArray.length - 1]);

		// 4. Print out the element in the array at position 6, what happens?

		// System.out.println(firstArray[6]); throws an exception

		// 5. Print out the element in the array at position -1, what happens?

		// System.out.println(firstArray[-1]); throws an exception

		// 6. Write a traditional for loop that prints out each element in the array
		System.out.println(hl);
		for (int i = 0; i < firstArray.length; i++) {
			System.out.print(" " + firstArray[i]);
		}
		System.out.println();

		// 7. Write an enhanced for loop that prints out each element in the array
		System.out.println(hl);
		for (int num : firstArray) {
			System.out.print(" " + num);
		}
		System.out.println();
		System.out.println(hl);

		// 8. Create a new variable called sum, write a loop that adds
		// each element in the array to the sum
		int sum = 0;

		for (int num : firstArray) {
			sum += num;
		}
		System.out.println(sum);

		// 9. Create a new variable called average and assign the average value of the
		// array to it
		int average = sum / firstArray.length;
		System.out.println(average);
		System.out.println(hl);

		// 10. Write an enhanced for loop that prints out each number in the array
		// only if the number is odd
		for (int num : firstArray) {
			if (num % 2 != 0) {
				System.out.print(" " + num);
			}
		}
		System.out.println();
		System.out.println(hl);

		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and
		// "Robert"
		String[] names = { "Sam", "Sally", "Thomas", "Robert" };

		// 12. Calculate the sum of all the letters in the new array
		sum = 0;

		for (String name : names) {
			System.out.println(name + " has " + name.length() + " letters");
			sum += name.length();
		}
		System.out.println(sum);
		System.out.println(hl);
		

		//
		// Methods:
		//

		// 13. Write and test a method that takes a String name and prints out a
		// greeting.
		// This method returns nothing.
		String firstName = "Billy";
		greeting(firstName);

		// 14. Write and test a method that takes a String name and
		// returns a greeting. Do not print in the method.
		System.out.println(greetingMessage(firstName));
		System.out.println(hl);

		// Compare method 13 and method 14:
		// a. Analyze the difference between these two methods.
		// b. What do you find?
		// c. How are they different?

		// 15. Write and test a method that takes a String and an int and
		// returns true if the number of letters in the string is greater than the int
		String word = "hellos";
		int numOfChars = 5;
		System.out.printf("'%s' has more than %d letters, true or false? %b\n", word, numOfChars,
				isLonger(word, numOfChars));

		// 16. Write and test a method that takes an array of string and a string and
		// returns true if the string passed in exists in the array
		String test = "!";
		String[] stringArray = { "Hello", "Worlds", "!" };
		System.out.println(containsString(stringArray, test));

		// 17. Write and test a method that takes an array of int and
		// returns the smallest number in the array
		int[] intArray = { 1, 0, 7, 9, -10 };
		System.out.println(minNum(intArray));

		// 18. Write and test a method that takes an array of double and
		// returns the average
		double[] doubleArray = { 1.5, 1.5, 2, 2, 1, 1 };
		System.out.println(getAverage(doubleArray));

		// 19. Write and test a method that takes an array of Strings and
		// returns an array of int where each element
		// matches the length of the string at that position
		int[] results = getLengths(stringArray);

		for (int index : results) {
			System.out.print(" " + index);
		}
		System.out.println();

		// 20. Write and test a method that takes an array of strings and
		// returns true if the sum of letters for all strings with an even amount of
		// letters
		// is greater than the sum of those with an odd amount of letters.
		System.out.println(evensGreaterThanOdds(names));
		System.out.println(evensGreaterThanOdds(stringArray));
		System.out.println(hl);
		
		// 21. Write and test a method that takes a string and
		// returns true if the string is a palindrome
		test = "racecar";
		System.out.println(isPalindrome(test));
		
		
		System.out.println(hl);
		System.out.println(hl);
		
		int[] arr = { -11, 43, 901, 72, -5};
		int[] arr2 = arr.clone();

		System.out.println(arr2[3]);

	}

	// Method 13:
	public static void greeting(String name) {
		System.out.printf("Hello there %s! You don't have to worry about doing anything with this message.\n", name);
	}

	// Method 14:
	public static String greetingMessage(String name) {
		return "Howdy " + name + ", this is being passed back.";
	}

	// Method 15:
	public static boolean isLonger(String string, int num) {
		return string.length() > num;
	}

	// Method 16:
	public static boolean containsString(String[] array, String string) {
		for (String index : array) {
			if (index.equals(string)) {
				return true;
			}
		}
		return false;
	}

	// Method 17:
	public static int minNum(int[] array) {
		int min = Integer.MAX_VALUE;
		for (int num : array) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	}

	// Method 18:
	public static double getAverage(double[] array) {
		double sum = 0;
		for (double num : array) {
			sum += num;
		}
		return sum / array.length;
	}

	// Method 19:
	public static int[] getLengths(String[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].length();
		}
		return result;
	}

	// Method 20:
	public static boolean evensGreaterThanOdds(String[] array) {
		int evenSum = 0;
		int oddSum = 0;
		for (String word : array) {
			if (word.length() % 2 == 0) {
				evenSum += word.length();
			} else {
				oddSum += word.length();
			}
		}
		return evenSum > oddSum;
	}
	

	// Method 21:
	public static boolean isPalindrome(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) return false;
		}
		return true;
	}

}
