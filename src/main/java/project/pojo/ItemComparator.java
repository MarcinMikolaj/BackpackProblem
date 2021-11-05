package project.pojo;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.getProfitability() > o2.getProfitability()) return -1;
		if(o1.getProfitability() < o2.getProfitability()) return 1;
		return 0;
	}

}
