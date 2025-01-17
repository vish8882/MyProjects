/*
 * There are N students sitting behind each other. There are three types of pencils P1, P2, P3 and price of each pencil
 * is different for each student. Eg: S[i] will have price as P1[i], P2[i], P3[i].
 * A student can't take a pencil that is taken by a student next to him. Find the minimum cost in which all the student's can
 * buy the pencil.
 */

package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StudentPencil {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int[][] c = new int[N][3];
         for(int i_c=0; i_c<N; i_c++)
         {
            String[] arr_c = br.readLine().split(" ");
            for(int j_c=0; j_c<arr_c.length; j_c++)
            {
                c[i_c][j_c] = Integer.parseInt(arr_c[j_c]);
            }
         }

         int out_ = mincost(c, N);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int mincost(int[][] c, int N){
    	int[][] dpArr = new int[N][3];
    	return findSum(0, c, 0, -1, N, dpArr);
    }
    
    static int findSum(int sum, int[][] arr, int i, int prevJ, int N, int[][] dpArr) {
    	int min = Integer.MAX_VALUE;
        if(i == N){
            return 0;
        }
        for(int j=0;j<3;j++) {
        	if(dpArr[i][j]>0){
        		if(j==prevJ)
        			continue;
        		min = Math.min(min, dpArr[i][j]);
            	continue;
            }
            if(j!=prevJ){
                sum=sum+ arr[i][j];
            }
            else{
                continue;
            }
        int cost = findSum(sum, arr, i+1, j, N, dpArr);
        	sum = sum - arr[i][j];
        	if(cost+arr[i][j] < min)
        		min = cost + arr[i][j];
        	dpArr[i][j] = cost+arr[i][j];
        }
        return min;
    }
}
