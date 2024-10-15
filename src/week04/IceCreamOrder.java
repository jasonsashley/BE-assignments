package week04;

import java.util.*;

public class IceCreamOrder {

	private StringBuilder user = new StringBuilder();
	private int scoops = 0;
	private StringBuilder container = new StringBuilder();
	private List<String> flavors;

	public IceCreamOrder() {
		this(new ArrayList<String>(), "", 0, "");
	}

	public IceCreamOrder(List<String> flavors, String user) {
		this(flavors, user, 0, "");
	}

	public IceCreamOrder(List<String> flavors, String user, int scoops, String container) {
		setUser(user);
		setScoops(scoops);
		setContainer(container);
		setFlavors(flavors);
	}

	public String getUser() {
		return this.user.toString();
	}

	public void setUser(String user) {
		this.user.replace(0, this.user.length(), user);
	}

	public int getScoops() {
		return scoops;
	}

	public void setScoops(int scoops) {
		this.scoops = scoops;
	}
	
	public String getContainer() {
		return this.container.toString();
	}
	
	public void setContainer(String container) {
		container = container.toLowerCase();
		switch (container) {
		case("waffle cone"): case("cake cone"): case ("cup"): case ("cone"):
			this.container.replace(0, this.container.length(), container);
			break;
		}
	}
	
	public List<String> getFlavors(){
		return this.flavors;
	}
	
	public void setFlavors(List<String> flavors) {
		this.flavors = flavors;
	}
	
	public void addFlavor(String flavor) {
		this.flavors.add(flavor);
	}
	
	public void describe() {
		int num = 0;
		int boxSize = 40;
		char star = '*';
		
		for (int i = 0; i < boxSize; i++) {
			System.out.print(star);
		}
		System.out.println("\nIce Cream Order:\n----------------");
		System.out.print("Name:\n\t" + this.user + "\nOrder: \n\t");
		System.out.print(this.container + " with " + this.scoops + " scoop");
		if (scoops > 1) {
			System.out.print("s");
		}
		System.out.println();
		
		if (this.flavors.size() > 1) {
			System.out.print("Flavors:\n\t");
		} else {
			System.out.print("Flavor:\n\t");
		}
		
		if (this.flavors.isEmpty()) {
			System.out.println("No ice cream flavors were chosen!");
		} else {
			for (String flavor : flavors) {
				System.out.print(flavor);
				num++;
				if (num == flavors.size() - 1) {
					System.out.print(" & \n\t");
				} else if (num == flavors.size()){
					System.out.print("\n\t");
				} else {
					System.out.print(", \n\t");
				}
			}
		}
		System.out.println();
		for (int i = 0; i < boxSize; i++) {
			System.out.print(star);
		}
		System.out.println();
	}

}
