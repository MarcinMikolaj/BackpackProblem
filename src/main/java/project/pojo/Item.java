package project.pojo;

import org.apache.commons.math3.util.Precision;

public final class Item {
	
	private final String name;
	private final double value;
	private final double weight;
	private final double profitability;
	
	public Item(String name, double value, double weight) {
		super();
		this.name = name;
		this.value = value;
		this.weight = weight;
		this.profitability = Precision.round((value/weight), 3);
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public double getWeight() {
		return weight;
	}
	
	public double getProfitability() {
		return profitability;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", value=" + value + ", weight=" + weight + ", profitability=" + profitability
				+ "]";
	}

}
