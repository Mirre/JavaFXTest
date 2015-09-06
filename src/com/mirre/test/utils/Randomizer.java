package com.mirre.test.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer<T> {
	
	private final List<Integer> usedIndexes = new ArrayList<Integer>();
	private final T[] objects;
	
	@SafeVarargs
	public Randomizer(T... objects){
		this.objects = objects;
	}
	
	public T random(){
		int index = -666;
		while(usedIndexes.contains(index) || index == -666){
			index = new Random().nextInt(objects.length);
		}
		usedIndexes.add(index);
		return objects[index];
	}
	
	@SafeVarargs
	public static <T> T pickRandom(T... objects){
		int index = new Random().nextInt(objects.length);
		return objects[index];
	}
	
	public static <T> List<T> pickRandomUniqueAmount(int amount, List<T> array){
		if(array.size() == amount)
			return array;
		Random random = new Random();
		while(array.size() != amount){
			array.remove(random.nextInt(array.size()));
		}
		return array;
	}

}
