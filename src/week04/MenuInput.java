package week04;

import java.util.*;

public class MenuInput {

	static String hLine = "------------------------------";
	static Scanner input = new Scanner(System.in);
	private static final int SMALL_SCOOPS = 1;
	private static final int MEDIUM_SCOOPS = 3;
	private static final int LARGE_SCOOPS = 5;
	private static List<String> options = Arrays.asList("Vanilla", "Chocolate", "Mint Chocolate Chip", "Strawberry",
			"Black Raspberry", "Chocolate Peanut Butter Cup", "Bubble Gum", "Banana Fudge", "End Order");

	public static void main(String[] args) {
		List<IceCreamOrder> orders = new ArrayList<IceCreamOrder>();
		boolean finished = false;

		System.out.println(hLine + "\nWelcome to The Ice Cream Stand\n" + hLine);

		menu: while (!finished) {
			IceCreamOrder userOrder = new IceCreamOrder();

			// Setting the user ordering
			System.out.print("Enter a name for your order: ");
			String temp = input.next();
			userOrder.setUser(temp);
			System.out.println();

			// Setting the number of scoops to give
			printSizeOptions();
			int inputSize = validateSize(input.nextLine());
			while (inputSize == 0) {
				System.out.println("Please enter a valid ice cream size selection: ");
				inputSize = validateSize(input.nextLine());
			}
			userOrder.setScoops(inputSize);

			// confirmation message
			System.out.println("\n\n" + userOrder.getUser() + ", you may choose " + userOrder.getScoops()
					+ " flavors of ice cream!\n\n");

			// getting the flavors wanted
			int counter = 0;
			int userInput = 0;
			do {
				if (counter == 0) {
					printFlavorOptions();
				}

				if (counter < userOrder.getScoops()) {
					System.out.print("Enter your selection: ");
					userInput = input.nextInt();

					if (userInput > 0 && userInput < 9) {
						String choice = options.get(userInput - 1);
						System.out.println("How many scoops of " + choice + " would you like?");
						int num = input.nextInt();
						for (int i = num; i > 0; i--) {
							printChoice(choice, counter);
							userOrder.addFlavor(choice);
							counter++;
							if (counter == userOrder.getScoops()) {
								break;
							}
						}
						counter--;

					} else if (userInput == 9) {
						if (checkOrderCancellation()) {
							userInput = 0;
							counter--;
						} else {
							System.out.println("You have canceled this order.");
							break menu;
						}
					} else {
						System.out.println("Invalid Selection Choice");
						counter--;
					}
				}
				counter++;
			} while (userInput != 9 && counter <= userOrder.getScoops() + 1);

			// setting the container wanted
			int order = 0;
			printContainerOptions();
			order = input.nextInt();
			while (order <= 0 || order > 3) {
				System.out.println("Please enter a valid option: ");
				order = input.nextInt();
			}
			userOrder.setContainer(validateContainer(order));

			System.out.println("\n");
			userOrder.describe();
			System.out.println("\n");
			orders.add(userOrder);
			System.out.println(userOrder.getUser() + ", your order has been saved.");

			// add more useres or end the order here
			if (!checkOrderCancellation()) {
				finished = true;
			}
		}

		System.out.println("\n" + hLine + "\n" + hLine);
		System.out.println("Here is your full order. Have a good day!");
		System.out.println(hLine);
		for (IceCreamOrder order : orders) {
			order.describe();
		}
	}

	public static void printContainerOptions() {
		System.out.println("Choose what you would like your ice cream to be in: ");
		System.out.println(hLine);
		System.out.println("\t1) CUP");
		System.out.println("\t2) WAFFLE CONE");
		System.out.println("\t3) CAKE CONE");
		System.out.println(hLine);
		System.out.print("Enter your selection: ");
	}

	public static boolean checkOrderCancellation() {
		System.out.println();
		System.out.println("Would you like to continue your order?");
		System.out.println(hLine);
		System.out.println("\t1) Yes, continue the order!");
		System.out.println("\t2) No, END my order!");
		System.out.print("Enter your selection: ");
		int check = input.nextInt();
		while (check != 1 && check != 2) {
			System.out.print("Please enter a valid entry: ");
			check = input.nextInt();
		}
		System.out.println("You have chosen: ");
		if (check == 1) {
			System.out.println("CONTINUE Your Order\n");
			return true;
		} else {
			System.out.println("END Your Order\n");
			return false;
		}
	}

	public static int validateSize(String size) {
		switch (size.toLowerCase()) {
		case ("s"):
		case ("small"):
		case ("1"):
			return SMALL_SCOOPS;
		case ("m"):
		case ("medium"):
		case ("2"):
			return MEDIUM_SCOOPS;
		case ("l"):
		case ("large"):
		case ("3"):
			return LARGE_SCOOPS;
		default:
			return 0;
		}

	}

	public static String validateContainer(int container) {
		switch (container) {
		case (1):
			return "Cup";
		case (2):
			return "Waffle Cone";
		case (3):
			return "Cake Cone";
		default:
			return "";
		}
	}

	public static void printFlavorOptions() {
		System.out.println();
		System.out.println("Choose ice cream flavors:");
		System.out.println(hLine);
		for (int i = 0; i < options.size(); i++) {
			System.out.println("\t" + (i + 1) + ") " + options.get(i));
		}
		System.out.println(hLine);
	}

	public static void printChoice(String flavor, int counter) {
		System.out.println("Ice Cream Choice #" + (counter + 1) + ": " + flavor);
		System.out.println(hLine);
	}

	public static void printSizeOptions() {
		System.out.println("Sizes [number of scoops given]\n" + hLine);
		System.out.println("\t1) SMALL \t" + SMALL_SCOOPS);
		System.out.println("\t2) MEDIUM \t" + MEDIUM_SCOOPS);
		System.out.println("\t3) LARGE \t" + LARGE_SCOOPS);
		System.out.print("Enter your size selection: ");
	}

}
