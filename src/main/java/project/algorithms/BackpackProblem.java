package project.algorithms;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

import project.pojo.Item;
import project.pojo.ItemComparator;
import project.pojo.Backpack;

import java.util.stream.Collectors;

@Component
public class BackpackProblem {
	
	public Backpack greedyAlgorithms(List<Item> itemList, double backpackMaxWeight) {
		
		double currentWeight = backpackMaxWeight;
		double currentValue = 0;
		List<Item> thingsToPack = new ArrayList<Item>();
		int c = 0;
				
		List<Item> items = itemList.stream()
			 .filter(q -> q != null)	 
		     .sorted(new ItemComparator())
		     .collect(Collectors.toList());
		
	
		while(c < items.size()) {	
			if(currentWeight >= items.get(c).getWeight()) {		
				thingsToPack.add(items.get(c));
				currentWeight = currentWeight - items.get(c).getWeight();
				currentValue = currentValue + items.get(c).getValue();
			}else {
				c++;
			}	
		}
		
		return new Backpack(thingsToPack, Precision.round(currentValue, 3), backpackMaxWeight, Precision.round(currentWeight, 3));
	}

}
