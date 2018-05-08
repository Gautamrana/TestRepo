package org.test.berlinclock;

public class Main {
    public static void main(String[] args) {
		BerlinClock berlinClock=new BerlinClock();
		String getTimeInBerlinTimeFormate=berlinClock.changeInputTimeToBerlinTime("16:37:16");
		System.out.println(getTimeInBerlinTimeFormate);
		
		
	}
}
