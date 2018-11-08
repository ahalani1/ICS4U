package DPQ;

public class HateNeighbour {

	public static void main(String[] args) {

		int[] donations = {10, 3, 2, 5, 7, 8}; //put donation values into this array

		System.out.println("The maximum amount of donations is $" + maxDonation(donations)); //prints answer 
	}

	private static int maxDonation(int[] donations) {

		if(donations.length == 0) //this is the case if the array is empty
			return 0;

		if(donations.length == 1) //this is the case for only 1 donation
			return donations[0]; 

		if(donations.length == 2) { //this is the case for only 2 neighbours 
			if (donations[0]>=donations[1])
				return donations[0];
			else
				return donations[1]; 
		}

		// divide starting array into 2 
		//one with the first value, the other with the last value
		int[] first = new int[donations.length - 1];

		int[] firstTotal = new int[donations.length - 1];

		int[] last = new int[donations.length - 1];

		int[] lastTotal = new int[donations.length - 1];

		for (int i = 0; i < donations.length - 1; i++) {
			first[i] = donations[i + 1];
			last[i] = donations[i];
		}

		firstTotal[0] = first[0];
		firstTotal[1] = Math.max(firstTotal[0], first[1]);
		lastTotal[0] = last[0];
		lastTotal[1] = Math.max(lastTotal[0], last[1]);

		for (int i = 2; i < donations.length - 1; i++) { // finds the max sum of both arrays 
			firstTotal[i] = Math.max(firstTotal[i - 1], firstTotal[i - 2] + first[i]);
			lastTotal[i] = Math.max(lastTotal[i - 1], lastTotal[i - 2] + last[i]);
		}	
		return Math.max(firstTotal[firstTotal.length - 1], lastTotal[lastTotal.length - 1]); // returns the greater maximum sum out of the two arrays
	}
}
