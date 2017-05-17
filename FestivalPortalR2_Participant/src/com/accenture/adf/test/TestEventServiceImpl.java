package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {

	private List<Object[]> eventList;
	private List<EventCoordinator> eventList1;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		eventServiceImpl = null;
		visitor = null;
		
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */	
		
		eventList=eventServiceImpl.getAllEvents();
        Assert.assertEquals(7, eventList.size());   
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		/**
		 * @TODO: Call checkEventsofVisitor and assert the returned type of this method
		 * for appropriate return type
		 */
		boolean b=false;
		visitor.setVisitorId(1001);
		b=eventServiceImpl.checkEventsofVisitor(visitor,1002,10002);
		Assert.assertEquals(true, b);
	}

	/**
	 * Test case to test the method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this method
		 */	
		Event e=eventServiceImpl.getEvent(1006, 10008);
		int before=(e.getSeatsavailable());
		eventServiceImpl.updateEventDeletions(1006,10008);
        e=eventServiceImpl.getEvent(1006, 10008);
		int after=(e.getSeatsavailable());
		Assert.assertEquals(after-1, before);
		
	}

	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getAllEventCoordinators and assert the size of return type of this method
		 */	
		eventList1=eventServiceImpl.getAllEventCoordinators();
		Assert.assertEquals(5, eventList1.size());
		
		
	}

	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent and assert the event id of this event with 
		 * passed event id 
		 */		
		Event e=eventServiceImpl.getEvent(2002,10009);
	    Assert.assertEquals(2002, e.getEventid());
	    Assert.assertEquals("Radsad", e.getName());
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Call insertEvent
		 * Create event object by setting appropriate values
		 * Assert the status of insertEvent method
	*/
		int a=0;
		Event e=new Event();
		e.setName("Rv");
		e.setDescription("FUN");
		e.setPlace("KP");
	    e.setDuration("1200-1300");
		e.setEventtype("dad");
		e.setEventCoordinatorId(104);
		e.setSeatsavailable(10032);
		e.setEventSession(4);
		a=eventServiceImpl.insertEvent(e);
		Assert.assertEquals(1, a);
		
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call updateEvent method
		 * Assert the status of updateEvent method
		 */	
		
		
		Event e=new Event();
		//e.setName("Rv");
		e.setEventid(2002);
		e.setEventSession(10009);
		e.setSeatsavailable(10032);
	    int c=eventServiceImpl.updateEvent(e);
		int z=(e.getSeatsavailable());
		Assert.assertEquals(10032, z);
		
	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Test
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call deleteEvent method
		 * Assert the status of deleteEvent method
		 */	
		//Event e=new Event();
		//int eid=
		int value=eventServiceImpl.deleteEvent(2009,10016);
		Assert.assertEquals(1,value);
	
	
	}

}
