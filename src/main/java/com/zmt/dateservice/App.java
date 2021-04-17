package com.zmt.dateservice;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String[] record = null;
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
		  
			if( !line.contains(Constants.INPUT_RECORD_SEPARATOR) ) {
				System.err.println("Error, the dates should be seperated by a space ");
				continue;
			}  
			record = line.split(Constants.INPUT_RECORD_SEPARATOR);
		  
			if( !(DateService.isValid(record[0]) && DateService.isValid(record[1])) ) {
				System.err.println("Error, the dates should be in ISO INSTANT format ");
				continue;
			}
			
			if(DateService.printVectauryFormat(record).equals("")) {
				System.err.println("Error, the difference should not be negatif or zero ");
				continue;
			}
			else {
				System.out.println(DateService.printVectauryFormat(record));
			}
		}
		scanner.close();	  
	}
}
