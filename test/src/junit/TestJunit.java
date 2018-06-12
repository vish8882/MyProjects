package junit;


import junit.framework.TestCase;

import org.junit.Test;

import searches.BinarySearch;
import static org.junit.Assert.assertEquals;

public class TestJunit  {
	
	
   String message = "Hello World";	
   MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() {
      assertEquals(message,messageUtil.printMessage());
     
   }

   
   
}

