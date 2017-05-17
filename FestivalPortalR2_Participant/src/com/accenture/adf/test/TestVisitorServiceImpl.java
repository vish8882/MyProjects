package com.accenture.adf.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;

	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		visitorServiceImpl = null;
		visitor = null;
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testCreateVisitor() {
		/**
		 * @TODO: Set the appropriate values for visitor object and
		 * call the method createVisitor by passing an argument of this visitor 
		 * object and then asserting the returned type of this method
		 */
		visitor.setUserName("abc");
		visitor.setFirstName("roma");
		visitor.setLastName("walli");
		visitor.setPassword("pwd");
		visitor.setPhoneNumber("12345");
		visitor.setEmail("r@gmail.com");
		visitor.setAddress(null);
		boolean b =visitorServiceImpl.createVisitor(visitor);
		Assert.assertEquals(true, b);
		
	}

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		/**
		 * @TODO: Call searchVisitor method by passing the appropriate arguments 
		 * and then asserting the returned type visitor username with the argument passed
		 */		
		visitor=visitorServiceImpl.searchVisitor("abc", "pwd");
		Assert.assertEquals("abc",visitor.getUserName());
	}

	/**
	 * Test case for method RegisterVisitor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testRegisterVisitor() throws ClassNotFoundException, SQLException {
		/**
		 * @TODO: Call RegisterVisitor method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of RegisterVisitor method 
		 */		
		EventServiceImpl e=new EventServiceImpl();
		visitor=visitorServiceImpl.searchVisitor("abc", "pwd");
		visitorServiceImpl.RegisterVisitor(visitor,1003,10005);
		//System.out.println("Registered");
		boolean b=e.checkEventsofVisitor(visitor, 1003, 10005);
		Assert.assertEquals(true,b);
	}

	/**
	 * Test case for method showRegisteredEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		/**
		 * @TODO: Call showRegisteredEvents method by passing visitor object which 
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of showRegisteredEvents method 
		 */		
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		visitor=visitorServiceImpl.searchVisitor("abc", "pwd");
		showEvents=visitorServiceImpl.showRegisteredEvents(visitor);
		Assert.assertEquals(0, showEvents.size());
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		/**
		 * @TODO: Call updateVisitorDetails method by passing the visitor object which
		 * can be retrieved using searchVisitor method and then asserting the returned
		 * type of updateVisitorDetails
		 */		
		visitor=visitorServiceImpl.searchVisitor("abc", "pwd");
		visitor.setUserName("martha");
		int a=visitorServiceImpl.updateVisitorDetails(visitor);
		Assert.assertEquals(1, a);
	}

	/**
	 * Test case for method unregisterEvent
	 */
	@Test
	public void testUnregisterEvent() {
		/**
		 * @TODO: Call unregisterEvent method by passing the visitor object which can be
		 * retrieved using searchVisitor method and then asserting the returned type 
		 * of unregisterEvent
		 */		
		EventServiceImpl e=new EventServiceImpl();
		visitor=visitorServiceImpl.searchVisitor("martha", "pwd");
		visitorServiceImpl.unregisterEvent(visitor,1003,10005);
		boolean b=e.checkEventsofVisitor(visitor, 1003, 10005);
		Assert.assertEquals(false,b);
	}

}
