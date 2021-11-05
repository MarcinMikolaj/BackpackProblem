package project.pojo;

import java.util.List;
import java.util.ArrayList;

public final class Backpack {
	
	private final List<Item> itemList;
	private final double value;
	private final double maxWeight;
	private final double remainingLoadCapacity;
	
	public Backpack(List<Item> itemList, double value, double maxWeight, double remainingLoadCapacity) {
		super();
		this.itemList = new ArrayList<Item>(itemList);
		this.value = value;
		this.maxWeight = maxWeight;
		this.remainingLoadCapacity = remainingLoadCapacity;
	}

	public List<Item> getItemList() {
		return new ArrayList<Item>(itemList) ;	
	}

	public double getValue() {
		return value;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public double getRemainingLoadCapacity() {
		return remainingLoadCapacity;
	}


	@Override
	public String toString() {	
		return "Backpack [itemList=" + itemList + ", value=" + value + ", maxWeight=" + maxWeight
				+ ", remainingLoadCapacity=" + remainingLoadCapacity + "]";
	}
	
	//Umożliwia wyświetlenie wyników w przyjaznej formie
	public void printInConsole() {	
		System.out.println(ConsoleColors.GREEN_BOLD + "Backpack:" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BACKGROUND + "value: " + value + " (Wartość zapakowanych przedmiotów)" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND + "maxWeight: " + maxWeight + " (Maxymalna ładowność plecaka)" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BACKGROUND + "remainingLoadCapacity: " + remainingLoadCapacity + " (Pozostałe miejsce po spakowaniu)" + ConsoleColors.RESET);
		
		System.out.println("Spakowane przedmioty:");

		if(itemList != null && itemList.size() > 0) {
			itemList.stream()
		    .filter(q -> q != null)
		    .forEach(q -> System.out.println(q.toString()));
		}
	}
	
}
