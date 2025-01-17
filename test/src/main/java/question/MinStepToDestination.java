package question;

public class MinStepToDestination {
	
	public static void main(String[] args) {
		minSteps(0, 11, 0);
		System.out.println(minTotal);
	}
	static int minTotal = Integer.MAX_VALUE;
	public static void minSteps(int steps, int dest, int total) {
		if(Math.abs(steps) > dest)
			return;
		if(steps==dest){
			minTotal = Math.min(minTotal, total);
			return;
		}
		minSteps(steps+total+1, dest, total+1);
		minSteps(steps - (total+1), dest, total+1);
	}
}
