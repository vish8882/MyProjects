package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;

/**
 * Junit test class for EventDAO class
 * 
 */
public class TestEventDAO {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private ArrayList<Object[]> showAllEvents;
	private EventDAO dao;

	/**
	 * Sets up database connection before other methods are executed in this
	 * class
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpDatabaseConnection() throws Exception {
		connection = FERSDataConnection.createConnection();
	}

	/**
	 * Closes the database connection after all the methods are executed
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownDatabaseConnection() throws Exception {
		/**
		 * @TODO: Close connection object here  
		 */
		connection.close();
	}

	/**
	 * Sets up the objects required in other methods
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		showAllEvents = new ArrayList<Object[]>();
		dao = new EventDAO();
	}

	/**
	 * Deallocate the resources after execution of method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
		showAllEvents = null;
		dao = null;
	}

	/**
	 * Positive test case to test the method showAllEvents
	 */
	@Test
	public void testShowAllEvents_Positive() {
		/**
		 * @TODO: Call showAllEvents method and assert it for
		 * size of returned type list
		 */	
		String ename = "Rose Parade";
		try {
			showAllEvents = dao.showAllEvents(ename);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(1,showAllEvents.size());
	}
	
	/**
	 * Junit test case to test positive case for updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventDeletions for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 more then testSeatsAvailableAfter
		 */		
		int after=0;
		int before=0;
		String sql = "SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID = ?";
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1001);
			 resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				before=Integer.parseInt(resultSet.getString("seatsavailable"));	
			}
			//System.out.println(before);
			System.out.println();
			try {
				dao.updateEventDeletions(1001, 10001);
				
				statement = connection.prepareStatement(sql);
				statement.setInt(1, 1001);
				 resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					after=Integer.parseInt(resultSet.getString("seatsavailable"));	
				}
				//System.out.println(after);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(1, (after-before));
	}

	/**
	 * Negative test case for method updateEventDeletions
	 */
	@Test
	public void testUpdateEventDeletions_Negative() {
		/**
		 * @TODO: Call updateEventDeletions for incorrect eventid and it should
		 * throw an exception
		 */
			
			
				try {
					dao.updateEventDeletions(10001, 10001);
					Assert.fail();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}

	/**
	 * Positive test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Positive() {
		/**
		 * @TODO: Find out seats available for an event by opening a connection
		 * and calling the query SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?
		 * Call the updateEventNominations for eventId
		 * Again find out the seats available for this event
		 * testSeatsAvailableBefore should be 1 less then testSeatsAvailableAfter
		 */
		int after=0;
		int before=0;
		String sql = "SELECT SEATSAVAILABLE FROM EVENTSESSION WHERE EVENTID = ?";
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1001);
			 resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				before=Integer.parseInt(resultSet.getString("seatsavailable"));	
			}
			System.out.println(before);
			
			try {
				dao.updateEventNominations(1001, 10001);
				
				statement = connection.prepareStatement(sql);
				statement.setInt(1, 1001);
				 resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					after=Integer.parseInt(resultSet.getString("seatsavailable"));	
				}
				System.out.println(after);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(1, (before-after));
	}
		
	

	/**
	 * Negative test case for method updateEventNominations
	 */
	@Test
	public void testUpdateEventNominations_Negative() {
		/**
		 * @TODO: Call updateEventNominations for incorrect eventid and it should
		 * throw an exception
		 */	
		try {
			dao.updateEventNominations(100001, 10001);
			Assert.fail();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Positive test case for method checkEventsofVisitor
	 */
	@Test
	public void testCheckEventsOfVisitor_Positive() {
		/**
		 * @TODO: Create visitor object by setting appropriate values
		 * Call checkEventsofVisitor method by passing this visitor object and
		 * valid eventId
		 * Assert the value of return type 
		 */	
		Visitor visitor = new Visitor();
		boolean c = false;
		
		visitor.setVisitorId(1001);
		visitor.setUserName("bsmith");
		visitor.setPassword("password");
		visitor.setFirstName("Bob");
		visitor.setLastName("Smith");
		visitor.setEmail("bsmith@email.com");
		visitor.setPhoneNumber("748937487");
		visitor.setAddress(null);
		visitor.setAdmin(1);
		try {
			c = dao.checkEventsofVisitor(visitor, 1001, 10001);
			System.out.println(c);
			Assert.assertEquals(true, c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Junit test case for getEventCoordinator
	 */
	@Test
	public void testGetEventCoordinator(){
		/**
		 * @TODO: Call getEventCoordinator method
		 * Assert the size of return type arraylist
		 */		
		List<EventCoordinator> eventCoordinatorList = new ArrayList<EventCoordinator>();
		try {
			eventCoordinatorList = dao.getEventCoordinator();
			Assert.assertEquals(5, eventCoordinatorList.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Junit test case for getEvent
	 */
	@Test
	public void testGetEvent(){
		/**
		 * @TODO: Call getEvent method 
		 * Assert the returned Event type with the passed value of event id
		 */	
		Event e = new Event();
		try {
			e = dao.getEvent(1001, 10001);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Assert.assertEquals(1001, e.getEventid());
	}	
	
	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testInsertEvent(){
		/**
		 * @TODO: Create Event object by setting appropriate values
		 * Call insertEvent method by passing this event object
		 * Assert the status of return type of this insertEvent method
		 */		
		
		/*
		 * 
		 description*/
		Event e = new Event();
		int x = 0;
		e.setEventid(2001);
		e.setName("Shaadi");
		e.setDescription("RijuMere Ki");
		e.setPlace("Kanpur");
		e.setDuration("1200-2400");
		e.setEventtype("Wedding");
		e.setSeatsavailable(1000);
		e.setSessionId(1009);
		try {
			x = dao.insertEvent(e);
			Assert.assertEquals(1,x);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent(){
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method
		 * Update the values of event object
		 * Call updateEvent method by passing this modified event as object
		 * Assert the status of return type of updateEvent method
		 */		
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		try {
			eventList = dao.showAllEvents("Pavlova  - All World Tour");
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	Object[] Ob=new Object[8];
		Ob=eventList.get(0);
		Event e=new Event();
		/*eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");*/
		
		e.setEventid((Integer) Ob[0]);
		e.setName((String) Ob[1]);
		e.setDescription((String) Ob[2]);
		e.setDuration((String) Ob[3]);
		e.setEventtype((String) Ob[4]);
		e.setPlace((String) Ob[5]);
		e.setSeatsavailable(((Integer) Ob[6]));
		e.setEventSession((Integer) Ob[7]);
		
		
		
		try {
			int x = dao.updateEvent(e);
			//System.out.println("x value"+x);
			Assert.assertEquals(1, x);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Junit test case for deleteEvent
	 */
	@Test
	public void testDeleteEvent(){
		/**
		 * @TODO: Fetch Event object by calling showAllEvents method		 * 
		 * Call deleteEvent method by passing this event id and event session id as object
		 * Assert the status of return type of updateEvent method
		 */
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		try {
			eventList = dao.showAllEvents("Pavlova  - All World Tour");
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
				System.out.println(eventList.get(0));
		int eventid=(Integer) eventList.get(0)[0];
	
		int session_id=(Integer) eventList.get(0)[7];
			try {
			
		int x=dao.deleteEvent(eventid,session_id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FERSGenericException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
