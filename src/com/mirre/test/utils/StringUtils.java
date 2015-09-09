package com.mirre.test.utils;

public class StringUtils {

	private static final String[] integerStrings = {
		"Noll", "Ett", "Tv�", "Tre", "Fyra", "Fem", "Sex", "Sju", "�tta", "Nio", "Tio", "Elva", "Tolv", "Tretton"
	};
	
	public static String stringifyIntegers(String string){
		for(int i = 0; i < integerStrings.length;  i++){
			if(string.contains("" + i)){
				string = string.replaceAll("" + i, integerStrings[i]);
			}
		}
		return string;
	}
	
}
