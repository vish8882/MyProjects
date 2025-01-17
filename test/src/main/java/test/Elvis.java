package test;

import java.util.Calendar;

public class Elvis {
	//private  final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	private  int beltSize;
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	public  static final Elvis INSTANCE = new Elvis();

	static{
		System.out.println("static block 1");
		
	}
	
	static{
		System.out.println("static 2");
	}
	
	// private static final int CURRENT_YEAR =
	// Calendar.getInstance().get(Calendar.YEAR);
	private Elvis() {
		System.out.println("Initialized");
		beltSize = beltSize + CURRENT_YEAR - 1930;
	}

	public int beltSize() {
		return beltSize;
	}

	public static void main(String[] args) {
		Elvis elvis = new Elvis();
		System.out.println("Elvis wears a size " + elvis.INSTANCE.beltSize() + " belt.");
	}
}