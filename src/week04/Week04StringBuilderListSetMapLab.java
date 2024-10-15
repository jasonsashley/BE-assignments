//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04;

import java.util.*;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// a. Instantiate a new StringBuilder
		// b. Append the characters 0 through 9 to it separated by dashes
		// Note: make sure no dash appears at the end of the StringBuilder
		StringBuilder sb = new StringBuilder();
		int num = 9;
		for (int i = 0; i < num + 1; i++) {
			sb.append(i);
			if (i != num) {
				sb.append("-");
			}	
		}
		System.out.println(sb);

		// 2. List of String:
		// a. Create a list of Strings
		// b. Add 5 Strings to it, each with a different length
		List<String> strings = new ArrayList<String>();
		strings.add("Hello");
		strings.add("Hi");
		strings.add("!");
		strings.add("boo");
		strings.add("Hippopotamus");

		// 3. Write and test a method that takes a list of strings
		// and returns the shortest string
		System.out.println(getShortest(strings));

		// 4. Write and test a method that takes a list of strings
		// and returns the list with the first and last element switched
		System.out.println(strings);
		System.out.println(swapFirstAndLast(strings));

		// 5. Write and test a method that takes a list of strings
		// and returns a string with all the list elements concatenated to each other,
		// separated by a comma
		System.out.println(listToString(strings));

		// 6. Write and test a method that takes a list of strings and a string
		// and returns a new list with all strings from the original list
		// containing the second string parameter (i.e. like a search method)
		System.out.println(hasSubString(strings, "hi"));

		// 7. Write and test a method that takes a list of integers
		// and returns a List<List<Integer>> with the following conditions specified
		// for the return value:
		// a. The first List in the returned value contains any number from the input
		// list
		// that is divisible by 2
		// b. The second List contains values from the input list that are divisible by
		// 3
		// c. The third containing values divisible by 5, and
		// d. The fourth all numbers from the input List not divisible by 2, 3, or 5
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			nums.add(i);
		}
		System.out.println(nums);
		System.out.println(getMultiples(nums));

		// 8. Write and test a method that takes a list of strings
		// and returns a list of integers that contains the length of each string
		System.out.println(getLengths(strings));

		// 10. Write and test a method that takes a set of strings and a character
		// and returns a set of strings consisting of all the strings in the
		// input set that start with the character parameter.
		Set<String> stateSet = new HashSet<String>();
		stateSet.add("Alaska");
		stateSet.add("Alabama");
		stateSet.add("Arizona");
		stateSet.add("Indiana");
		stateSet.add("Michigan");
		stateSet.add("Illinois");

		System.out.println(startsWithChar(stateSet, 'I'));

		// 11. Write and test a method that takes a set of strings
		// and returns a list of the same strings
		List<String> stateList = setToList(stateSet);
		System.out.println(stateList);

		// 12. Write and test a method that takes a set of integers
		// and returns a new set of integers containing only even numbers
		// from the original set
		nums.add(10);
		Set<Integer> numSet = new HashSet<Integer>(nums);
		System.out.println(getEvenSet(numSet));

		// 13. Create a map of string and string and add 3 items to it where the key of
		// each
		// is a word and the value is the definition of the word
		Map<String, String> definitions = new HashMap<String, String>();
		definitions.put("rendition", "the act or result of rendering something");
		definitions.put("calculate", "to determine by mathematical processes");
		definitions.put("leak", "to enter or escape through an opening usually by a fault or mistake");

		// 14. Write and test a method that takes a Map<String, String> and a string
		// and returns the value for a key in the map that matches the
		// string parameter (i.e. like a language dictionary lookup)
		System.out.println(getValue(definitions, "leak"));

		// 15. Write and test a method that takes a List<String>
		// and returns a Map<Character, Integer> containing a count of
		// all the strings that start with a given character
		System.out.println(startingChars(strings));
		System.out.println(startingChars(stateList));

	}

	// Method 15:
	public static Map<Character, Integer> startingChars(List<String> list) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for (String string : list) {
			char c = string.charAt(0);
			if (result.containsKey(c)) {
				result.replace(c, result.get(c) + 1);
			} else {
				result.put(c, 1);
			}
		}
		return result;
	}

	// Method 14:
	public static String getValue(Map<String, String> map, String word) {
		if (map.containsKey(word)) {
			return map.get(word);
		}
		return "";
	}

	// Method 12:
	public static Set<Integer> getEvenSet(Set<Integer> set) {
		Set<Integer> result = new HashSet<Integer>();
		for (int num : set) {
			if (num % 2 == 0) {
				result.add(num);
			}
		}
		return result;
	}

	// Method 11:
	public static List<String> setToList(Set<String> set) {
		return new ArrayList<String>(set);
	}

	// Method 10:
	public static Set<String> startsWithChar(Set<String> set, char letter) {
		Set<String> result = new HashSet<String>();
		for (String string : set) {
			if (string.charAt(0) == letter) {
				result.add(string);
			}
		}
		return result;
	}

	// Method 8:
	public static List<Integer> getLengths(List<String> list) {
		List<Integer> result = new ArrayList<Integer>();
		for (String string : list) {
			result.add(string.length());
		}
		return result;
	}

	// Method 7:
	public static List<List<Integer>> getMultiples(List<Integer> list) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < 4; i++) {
			result.add(new ArrayList<Integer>());
		}

		for (int num : list) {
			boolean isMultiple = false;
			if (num % 2 == 0) {
				result.get(0).add(num);
				isMultiple = true;
			}
			if (num % 3 == 0) {
				result.get(1).add(num);
				isMultiple = true;
			}
			if (num % 5 == 0) {
				result.get(2).add(num);
				isMultiple = true;
			}
			if (!isMultiple) {
				result.get(3).add(num);
			}
		}
		return result;
	}

	// Method 6:
	public static List<String> hasSubString(List<String> list, String sub) {
		List<String> result = new ArrayList<String>();
		sub = sub.toLowerCase();

		for (String word : list) {
			if (word.toLowerCase().contains(sub)) {
				result.add(word);
			}

			/*
			 * boolean isSame = true; for (int i = 0; i < word.length(); i++) { int k = 0;
			 * while (k < sub.length() && isSame) { if (word.toLowerCase().charAt(i + k) !=
			 * sub.charAt(k)) { isSame = false; } k++; } if (isSame) { result.add(word); } }
			 */
		}
		return result;
	}

	// Method 5:
	public static String listToString(List<String> list) {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < list.size() - 1; i++) {
			result.append(list.get(i) + ",");
		}
		result.append(list.getLast());
		return result.toString();
	}

	// Method 4:
	public static List<String> swapFirstAndLast(List<String> list) {
		list.addFirst(list.getLast());
		list.removeLast();
		list.addLast(list.get(1));
		list.remove(1);
		return list;
	}

	// Method 3:
	public static String getShortest(List<String> list) {
		String result = list.getFirst();
		for (String string : list) {
			if (string.length() < result.length()) {
				result = string;
			}
		}
		return result;
	}

}
