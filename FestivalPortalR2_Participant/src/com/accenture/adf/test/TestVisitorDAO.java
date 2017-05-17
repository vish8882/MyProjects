package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Visitor;

/**
 * JUnit test case for VisitorDAO class for testing all repository methods to
 * call database sub-routines
 * 
 */
public class TestVisitorDAO {

	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private ArrayList<Object[]> registeredEvents;
private EventDAO eventDAO;
	/**
	 * Setting up initial objects
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
		registeredEvents = new ArrayList<Object[]>();
		eventDAO=new EventDAO();
	}

	/**
	 * Deallocating objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitor = null;
		visitorDAO = null;
		registeredEvents = null;
	}

	/**
	 * Test case for method insertData
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testInsertData() throws ClassNotFoundException, SQLException, Exception {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call insertData method by passing this visitor object
		 * Search this new visitor object by calling searchUser method
		 * Assert the values of username
		 */	
		visitor.setUserName("Riju123");
		visitor.setPassword("Meri Shaadi karvayo");
		visitor.setFirstName("Riju");
		visitor.setLastName("Vaish");
		visitor.setEmail("abc@gmail.com");
		visitor.setPhoneNumber("123456789");
		visitor.setAddress("Kanpur");
		
		visitorDAO.insertData(visitor);
		visitor  =visitorDAO.searchUser("Riju123","Meri Shaadi karvayo");
		Assert.assertEquals("Riju123",visitor.getUserName());
	}	

	/**
	 * Test case for method searchUser
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testSearchUser() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call searchUser method for valid values of username
		 * and password and assert the value of username for the returned type of method
		 */
		String username="Riju123";
		String password="Meri Shaadi karvayo";
		visitor= visitorDAO.searchUser(username, password);
		Assert.assertEquals("Riju123",visitor.getUserName());
	}

	/**
	 * Test case for method registerVisitorToEvent
	 * @throws Exception 
	 */
	@Test
	public void testRegisterVisitorToEvent() throws Exception {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registerVisitorToEvent method
		 * and assert the value
		 */	String username="Riju123";
			String password="Meri Shaadi karvayo";
			visitor= visitorDAO.searchUser(username, password);	
			int eventid=1006;
			int sessionid=10008;
			visitorDAO.registerVisitorToEvent(visitor, eventid, sessionid);
		
			boolean b= eventDAO.checkEventsofVisitor(visitor,1006,10008);
			//System.out.println(b);
			Assert.assertEquals(true ,b);
		
	}	

	/**
	 * Test case for method registeredEvents
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisteredEvents() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to registeredEvents method
		 * and assert the value
		 */		
		String username="bsmith";
		String password="qaz";
		visitor= visitorDAO.searchUser(username, password);
		
		registeredEvents=visitorDAO.registeredEvents(visitor);	
		Assert.assertEquals(5,registeredEvents.size());
	
	}

	/**
	 * Test case for method updateVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUpdateVisitor() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Update the value in this visitor object
		 * Pass this visitor object to updateVisitor method
		 * and assert the value of changed value
		 * 
		 */
		String username="Riju123";
		String password="Meri Shaadi karvayo";
		visitor= visitorDAO.searchUser(username, password);
		visitor.setPassword("Meri Shaadi Karvao");
		visitor.setEmail("rijuv@gmail.com");
		int s=visitorDAO.updateVisitor(visitor);
		Assert.assertEquals(1,s);
	}

	/**
	 * Test case for method registeredEvents
	 * @throws Exception 
	 */
	@Test
	public void testUnregisterEvent() throws Exception {
		/**
		 * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
		 * Pass this visitor object and valid eventid to unregisterEvent method
		 * and assert the value
		 */		
		String username="Riju123";
		String password="Meri Shaadi karvayo";
		visitor= visitorDAO.searchUser(username, password);
		visitorDAO.unregisterEvent(visitor, 1006, 10008);
		boolean b= eventDAO.checkEventsofVisitor(visitor,1006,10008);
		//System.out.println(b);
		Assert.assertEquals(false ,b);
	}
	
	/**
	 * Test case for method change password
	 */
	/*@Test
	public void testChangePassword_VisitorNull() {
		*//**
		 * @TODO: Call changePassword method by passing visitor object as null
		 *//*		
	}*/
	
	/**
	 * Test case for method change password
	 */
	@Test
	public void testChangePassword_VisitorNull() {
		try {
			visitor = null;
			visitorDAO.changePassword(visitor);
		} catch (SQLException exception) {
			fail("SQL Exception");
		} catch (ClassNotFoundException exception) {
			fail("Class Not Found Exception");
		} catch (Exception exception) {
			fail("NULL Exception");
		}
	}

}
