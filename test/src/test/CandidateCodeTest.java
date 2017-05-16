package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CandidateCodeTest {
public static void main(String[] args) {
	int value=maxTreeDestroyed(6,7,6,"((6,6),(4,2),(2,5),(2,6),(3,4),(6,1))");
	System.out.println("Final Value"+value);
}
public static int maxTreeDestroyed(int row,int column,int plantsDestroyed,String position)
{
  
    if(plantsDestroyed<3||plantsDestroyed>(row*column))
    {
    System.out.println("-1");
    return -1;
    }
    position=position.substring(2,position.length()-2);
    System.out.println(position);
    String[] positionArray= position.split("\\),\\(");
    if(positionArray.length!=plantsDestroyed)
    	return -1;
    int finalCount=validateMonkeyJump(positionArray);
    System.out.println(finalCount);
    if(finalCount<3)
    return -1;
    else
    return finalCount;
}

public static int validateMonkeyJump(String[] positionArray)
{
	List<Integer> xCoordinate= new ArrayList<Integer>();
	List<Integer> yCoordinate= new ArrayList<Integer>();
	List<String> positionList =  Arrays.asList(positionArray);
	Collections.sort(positionList);
	for(String cordinates:positionList)
	{
		System.out.println(cordinates);
		String[] coordinates= cordinates.split(",");
		int x=Integer.parseInt(coordinates[0]);
		int y=Integer.parseInt(coordinates[1]);
		xCoordinate.add(x);
		yCoordinate.add(y);
	}
	int frequencyCount=countXandYFrequency(xCoordinate,yCoordinate);
	int finalCount=countXandYincremental(xCoordinate,yCoordinate);
	if(finalCount>frequencyCount)
	return finalCount;
	else 
	return frequencyCount;
}

public static int countXandYFrequency(List<Integer> xCoordinate, List<Integer> yCoordinate)
{
	int finalCount=0;
	for(int x:xCoordinate)
	{
		
	int number=Collections.frequency(xCoordinate, x);
	
	if(number>finalCount)
		finalCount=number;
	}
	for(int y:yCoordinate)
	{
		
	int number=Collections.frequency(xCoordinate, y);
	
	if(number>finalCount)
		finalCount=number;
	}
	System.out.println(finalCount);
	return finalCount;
}
public static int countXandYincremental(List<Integer> xCoordinate, List<Integer> yCoordinate){
	int count=0;
	
	
	int finalCount=0;
	
	for(int x: xCoordinate)
	{
		int diffIncrement=2;
		int increment=0;
		int next=0;
		count++;
		List<Integer> differenceList= new ArrayList<Integer>();
		for(int i=count;i<xCoordinate.size();i++)
		{
			next=xCoordinate.get(i);
			if(next!=x)
			{
			int xCoordinatesDiff=next-x;
			if(count+i-1<xCoordinate.size())
			{
			int yCoordinatesDiff=Math.abs(yCoordinate.get(count+i-2)-yCoordinate.get(count-1));
			differenceList.add(Integer.parseInt(xCoordinatesDiff+""+yCoordinatesDiff));
				if(xCoordinatesDiff==yCoordinatesDiff)
					increment++;
			}
				
			}		
		}
		Collections.sort(differenceList);
		int diffCount=0;
		for(int difference:differenceList)
		{
			diffCount++;
			int quotientCount=2;
			for(int i=diffCount;i<differenceList.size();i++)
			{
				int modulo=differenceList.get(i)%difference;
				if(modulo==0)
				{
					int quotient=differenceList.get(i)/difference;
					if(quotientCount==quotient){
					diffIncrement++;
					quotientCount++;
					}
				}
					
			}
			
		}

		if(increment>finalCount)
			finalCount=increment;
		else 
			if (diffIncrement>finalCount)
			finalCount=diffIncrement;
	}
	return finalCount;
}
}
