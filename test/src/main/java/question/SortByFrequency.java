package question;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {
	public static void main(String[] args) {
		int[]arr = {1,4,9,1,9,9,4,7,8,9,4,4,1,1};
		List<Integer> list = new ArrayList<>();
		for(int i:arr)
			list.add(i);
		sort(list);
	}
	static class Pair{
		int number;
		int count;
		int occurence;
		public Pair(int number, int count, int occur){
			this.number = number;
			this.count = count;
			this.occurence = occur;
		}
	}
	public static void sort(List<Integer> list) {
		Map<Integer,Pair> map = new HashMap<>();
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.count > o2.count)
					return -1;
				else if(o1.count == o2.count){
					return o1.occurence-o2.occurence;
				}
				else
					return 1;
			}
		});
		int j=0;
		for(int i : list) {
			if(map.containsKey(i)) {
				Pair p = map.get(i);
				p.count = p.count+1;
				q.remove(p);
				q.add(p);
			} else
			{
				Pair p = new Pair(i,1,j);
				map.put(i,p);
				q.add(p);
			}
			j++;
		}
		map.clear();
		List<Integer> newList = new ArrayList<>();
		while(!q.isEmpty()){
			newList.add(q.poll().number);
		}
		for(int i : newList){
			System.out.print(i+" ");
		}
	}
}
