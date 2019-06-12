package com.datsk.menu;

import java.util.Random;

public class Coin {
		private static String sideUp;
		private static int tailsCount = 0;
		private static int headsCount = 0;
		
		public static void toss() {
		Random random = new Random();
		int randomNumber;
		
		randomNumber = random.nextInt(2);
		if(randomNumber == 1) {
			sideUp = "Heads";
			headsCount = headsCount + 1;
		}
		else {
			sideUp = "Tails";
			tailsCount = tailsCount + 1;
			}
		}
		
		public String getSideUp() {
			return sideUp;
		}
		
		public int getTailsCount() {
			return tailsCount;
		}
		
		public int getHeadsCount() {
			return headsCount;
		}
		
		public Coin() {
			toss();
	}
		
}
	
