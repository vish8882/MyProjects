package question;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MagicSquare {
	
	 public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        int output = 0;
	        int ip1_rows = 0;
	        int ip1_cols = 0;
	        ip1_rows = Integer.parseInt(in.nextLine().trim());
	        ip1_cols = Integer.parseInt(in.nextLine().trim());
	        
	        int[][] ip1 = new int[ip1_rows][ip1_cols];
	        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
	            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
	                ip1[ip1_i][ip1_j] = in.nextInt();
	                
	            }
	        }
	        output = SolveMagicSquare(ip1);
	        System.out.println(String.valueOf(output));
	    }
	 
	 public static int SolveMagicSquare(int[][] input1)
	    {
		int length = input1[0].length;
		int n= (int)Math.sqrt(length);
	    for(int i=0; i<length;i++){
	        Set<Integer> column = new HashSet<Integer>();
	        Set<Integer> row =new HashSet<Integer>();
	        for(int j=0;j<n;j++){
	            if(input1[i][j]!=0)
	            {
	                if(!column.add(input1[i][j]))
	                    return 0;
	            }
	            if(input1[j][i]!=0)
	            {
	                if(!row.add(input1[i][j]))
	                    return 0;
	            }
	            
	        }
	        
	        i=0;
	        int rowCount=0;
	        boolean add=true;
	        Set<Integer> set= new HashSet<Integer>();
	    	for(int j=0; i<n;i++){
	    		 
	    	    if(input1[i][j]!=0&&add){
	    	       set.add(input1[i][j]); 
	    	    }
	    	    if(j==(n-1)){
	    	        j=0;
	    	        i=i+n;
	    	        if(set.size()!=0)
	    	        	add=false;
	    	        else
	    	        	set= new HashSet<Integer>();
	    	        if(i>length){
	    	        	i=rowCount;
	    	        	rowCount++;
	    	        	if(i>n)
	    	        		break;
	    	        }
	    	    }
	    	    if(set.size()>0&& i!=0){
	    	    	
	    	    }
	    	}
	    }
		
		return 1;
	    }

}
