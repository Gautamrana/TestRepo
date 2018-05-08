package org.test.berlinclock;

import java.util.Arrays;
import java.util.stream.Stream;

public class BerlinClock {
	private String formattedTimeForPrintOutput;
	 public String changeInputTimeToBerlinTime(String time) {
	        int[] inputArray = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
	        return formattedTimeForPrintOutput= Arrays.toString(new String[]{calculateSeconds(inputArray[2]), calculateUpperRowHours(inputArray[0]), calculateLowerRowHours(inputArray[0]),calculateUpperRowMinutes(inputArray[1]), calculateLowerRowMinutes(inputArray[1])});
	    }
	 
     
		protected String calculateSeconds(int number) {
	        if (number % 2 == 0) return "Y";
	        else return "O";
	    }
	 
	    protected String calculateUpperRowHours(int number) {
	        return findSwitchStatusOnOff(4, findTopNumberOfOnSigns(number));
	    }
	 
	    protected String calculateLowerRowHours(int number) {
	        return findSwitchStatusOnOff(4, number % 5);
	    }
	 
	    protected String calculateUpperRowMinutes(int number) {
	        return findSwitchStatusOnOff(11, findTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
	    }
	 
	    protected String calculateLowerRowMinutes(int number) {
	        return findSwitchStatusOnOff(4, number % 5, "Y");
	    }
	 
	    private String findSwitchStatusOnOff(int lamps, int onSigns) {
	        return findSwitchStatusOnOff(lamps, onSigns, "R");
	    }
	    private String findSwitchStatusOnOff(int lamps, int onSigns, String onSign) {
	        String out = "";
	        for (int i = 0; i < onSigns; i++) {
	            out += onSign;
	        }
	        for (int i = 0; i < (lamps - onSigns); i++) {
	            out += "O";
	        }
	        return out;
	    }
	 
	    private int findTopNumberOfOnSigns(int number) {
	        return (number - (number % 5)) / 5;
	    }
	    
	    @Override
	    public String toString() {
	        return this.formattedTimeForPrintOutput;
	    }

}
