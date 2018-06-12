package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
 TestJunit1.class ,TestJunit2.class
})



public class TestJunit1 {

   String message = "Robert";	
   
   
   @Test
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");    
      assertEquals(message, "Robert");     
   }
}
 class TestJunit2 {

	   String message = "Robert";	
	   
	 
	   @Test
	   public void testSalutationMessage() {
	      System.out.println("Inside testSalutationMessage()");
	      message = "Hi!" + "Robert";
	      assertEquals(message,"NoRobert");
	   }
	}