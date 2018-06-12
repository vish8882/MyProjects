package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import searches.BinarySearch;

public class TestJunitSearch  {

	   String message = "Hello World";	
	   MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testBinarySearch(){
		   assertEquals(3,BinarySearch.searchBinary(3) );
		   System.out.println("completed");
	   }
	   
	   
	}
