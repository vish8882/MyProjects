package thread;

import java.io.IOException;

public class LongesNIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
    	int arr[] = {2,1,3,1,6,2};
    	increasingSubsequence(arr);
    }

    static int[] increasingSubsequence(int[] A) {
          int[] max = new int[A.length]; 
          max[0] = 1;
        
        int curr = A.length-1;
			int subSeq[] = new int[curr + 1];
			for (int k = 0; k <= curr; k++)
				subSeq[k] = 1;
			for (int i = 1; i <=curr; i++) {
				for (int j = 0; j <i; j++) {
					if (A[i] >= A[j] && subSeq[i] < subSeq[j] + 1)
						subSeq[i] = subSeq[j] + 1;
				}
			}
		for(int i=0; i < subSeq.length; i++) {
			System.out.print(subSeq[i]+" ");
		}
		return subSeq;
    }
}
