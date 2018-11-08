package DPQ;

public class ZigZag {
	public static void main(String[] args) {

		int[] sequence = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

		int longestZigZag = longestZigZag(sequence);
		System.out.println(longestZigZag);		
	}

	private static int longestZigZag(int[] sequence) {	

		if (sequence.length <= 2) { //case if sequence has a length of 2 or less
			return sequence.length;
		}	

		int[] up = new int[sequence.length]; // array for numbers increasing 

		int[] down = new int[sequence.length]; // array for numbers decreasing

		boolean goingUp = false;

		up[0] = 1;
		down[0] = 1;
		up[1] = 2;
		down[1] = 2;

		// see if we start going up or down first
		if (sequence[1] > sequence[0]) {
			goingUp = false;
		} else if (sequence[1] < sequence[0]) {
			goingUp = true;
		}

		for (int i = 2; i < sequence.length; i++) {
			if (goingUp) {
				if (sequence[i] > sequence[i - 1]) {
					up[i] = Math.max(up[i - 1], down[i - 1]) + 1;
					down[i] = up[i];
					goingUp = false;
				} else if (sequence[i] <= sequence[i - 1]) {
					up[i] = Math.max(up[i - 1], down[i - 1]);
					down[i] = Math.max(up[i - 1], down[i - 1]);
				}
			} else if (!goingUp) {
				if (sequence[i] >= sequence[i - 1]) {
					down[i] = Math.max(up[i - 1], down[i - 1]);
					up[i] = Math.max(up[i - 1], down[i - 1]);
				} else if (sequence[i] < sequence[i - 1]) {
					down[i] = Math.max(up[i - 1], down[i - 1]) + 1;
					up[i] = down[i];
					goingUp = true;
				}
			}	
		}		
		return Math.max(up[up.length - 1], down[down.length - 1]); // return the bigger length of the two arrays
	}
}





