package question;
import java.io.*;
import java.util.*;

public class BhopalJailEscape {
	public static int GetJumpCount(int input1,int input2,int[] input3)
    {
		int numberOfWall=input3.length;
	    int count=0;
	    
	    for(int i=0; i<numberOfWall; i++){
	        int height=input3[i];
	       if(height<=input1)
	       count++;
	       else{
	       int newJump=input1-input2;
	       int n=(height-input1)/newJump;
	       int curr=n*newJump;
	       if(curr+input1>=height)
	       count=count+n+1;
	       else
	       count=count+n+2;
	       }
	    }
	    return count;  
    }
	
	 public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        int output = 0;
	        int ip1 = Integer.parseInt(in.nextLine().trim());
	        int ip2 = Integer.parseInt(in.nextLine().trim());
	        int ip3_size = 0;
	        ip3_size = Integer.parseInt(in.nextLine().trim());
	        int[] ip3 = new int[ip3_size];
	        int ip3_item;
	        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
	            ip3_item = Integer.parseInt(in.nextLine().trim());
	            ip3[ip3_i] = ip3_item;
	        }
	        output = GetJumpCount(ip1,ip2,ip3);
	        System.out.println(String.valueOf(output));
	    }

}
