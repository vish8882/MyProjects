package question;

import java.util.Stack;

public class HistogramArea {
	
	public static void main(String[] args) {
		int [] hist={2,1,2,3,1};
		findMaxArea(hist);
	}

	
	public static void findMaxArea(int[] hist){
		int area=0, maxArea=-1;
		int size=hist.length;
		Stack<Integer> s = new Stack<Integer>();
		int i;
		for(i=0;i<size;i++){
			if(s.isEmpty()){
				s.push(i);
			}
			else{
				if(hist[i]>=hist[s.peek()])
					s.push(i);
				else{
					while(!s.isEmpty()&& hist[i]<hist[s.peek()]){
						int top= s.pop();
						if(s.isEmpty())
							area=hist[top]*i;
						else
							area=hist[top]*(i-1-s.peek());
						if(area>maxArea)
							maxArea=area;
					}
					s.push(i);
				}
			}
		}
		while(!s.isEmpty()){
			int top= s.pop();
			if(s.isEmpty())
				area=hist[top]*i;
			else
				area=hist[top]*(i-1-s.peek());
			if(area>maxArea)
				maxArea=area;
		}
		
	System.out.println(maxArea);
	}
}
