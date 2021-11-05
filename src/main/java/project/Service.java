package project;

import org.springframework.stereotype.Component;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import project.algorithms.BackpackProblem;
import project.pojo.ConsoleColors;
import project.pojo.Item;
import project.pojo.Backpack;

@Component
public class Service {
	
	private final Random random = new Random();
	private final Scanner scanner = new Scanner(System.in);
	private BackpackProblem backpackProblem;
	
	@Autowired
	public Service(BackpackProblem backpackProblem) {	
		this.backpackProblem = backpackProblem;
	}
	
	public void menu() {
		
		for(;;) {
		
	    System.out.println("***BACKPACK ALGORITHM***");
		
	    System.out.println("Wprowadz maxymalną wagę jaką może pomieścić plecak");
		double maxBackpackWeight = scanner.nextDouble();
		
		System.out.println("Wybierz sposób wprowadzenia nazwy, ceny oraz wagi przedmiotów");
		System.out.println("1 - Wykonaj test");
		System.out.println("2 - Wprowadz losowo");
		System.out.println("3 - Wprowadz z pliku");
		System.out.println("4 - Wprowadz z klawiatury");
		System.out.println("Inna Liczba - Zakończ");
		
		int choose = scanner.nextInt();
		List<Item> itemList = new ArrayList<Item>();
		
		if(choose == 1) {
			itemList = test();
		}
		
		else if(choose == 2) {
			itemList = generate(5, 100, 0, 10, 0);
		}
		
		else if(choose == 3) {
			try {
				System.out.println("Wprowadz nazwę pliku:");
				String fileName = scanner.next();
				itemList = formTheFile(fileName);
			} catch (IOException e) {
				
				System.out.println(ConsoleColors.RED + "Podany plik nie istnieje" + ConsoleColors.RESET);
				menu();
			}
		}	
		else if(choose == 4) {
			itemList = fromTheKeyboard();
		}
		else {
			System.out.println("END");
			System.exit(0);
		}
		
		System.out.println("Lista przedmiotów możliwych do zapakowania:");
		printList(itemList);
		backpackProblem.greedyAlgorithms(itemList, maxBackpackWeight).printInConsole();	
		}
	}
	
	private List<Item> test() {
		
		Item item1 = new Item("Przedmiot 1", 3, 1.5);
		Item item2 = new Item("Przedmiot 2", 1, 1);
		Item item3 = new Item("Przedmiot 3", 2.5, 5);
		Item item4 = new Item("Przedmiot 4", 1, 5);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
				
		return itemList;
	}
	
	private List<Item> generate(int numbers, double maxValue, double minValue, double maxWeight, double minWeight) {
		
		if(minValue<0 || minValue > maxValue) {
			throw new IllegalArgumentException("minValue<0 || minValue > maxValue");
		}
		
		List<Item> itemList = new ArrayList<Item>();
		
		for(int i=0; i<numbers; i++) {
			
			double value = minValue + (maxValue - minValue) * random.nextDouble();
			double weight = minWeight + (maxWeight - minWeight) * random.nextDouble();
			
			value = Precision.round(value, 3);
			weight =Precision.round(weight, 3);
		
			itemList.add(new Item("item " + i, value,weight));		
		}
		
		return itemList;
		
	}
	
	//Umożliwia pobranie elemtów z pliku
	private List<Item> formTheFile(String filename) throws IOException {
		
		List<Item> itemList = new ArrayList<Item>();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
		String oneLineFromFile = bufferedReader.readLine();
		
		while(oneLineFromFile != null) {
				
			String name = oneLineFromFile = bufferedReader.readLine();		
			name = oneLineFromFile = bufferedReader.readLine();	
			
			if(oneLineFromFile == null)
				break;
			
			double value = Double.parseDouble(name);
			name = oneLineFromFile = bufferedReader.readLine();	
			double weight = Double.parseDouble(name);	
			
			itemList.add(new Item(name, value, weight));	
		}
	
		bufferedReader.close();
		return itemList;
		
	}
	
	//Umożliwia pobranie elementów podanuch w konsoli
	private List<Item> fromTheKeyboard() {
		
		List<Item> itemList = new ArrayList<Item>();
		
		for(;;) {
			System.out.println("Czy chcesz wprowadzić kolejny przedmiot ? (1-tak, 2-nie)");
			int choose = scanner.nextInt();
			
			if(choose == 1) {
				
				System.out.println("Podaj nazwę przedmiotu:");
				String name = scanner.next();
				System.out.println("Podaj wartość przedmiotu:");
				double value = scanner.nextDouble();
				System.out.println("Podaj wagę przedmiotu:");
				double weight = scanner.nextDouble();
				
				itemList.add(new Item(name, value, weight));
				
				
			}
			else if(choose == 2) 
				break;
			else 
				break;
	
		}
		
		return itemList;
		
	}
	
	//Umożliwia drukowanie w konsoli wszystkich elementów listy
		private <T> void printList(List<T> list) {
			
			int l = list.size();
			
			if(list == null || l <= 0)
				throw new IllegalArgumentException("You cannot print an empty list");
			
			Iterator<T> iterator = list.iterator();
			
			while(iterator.hasNext()) {
				T object = iterator.next();
				System.out.println(object.toString());
			}	
		}
	
}
