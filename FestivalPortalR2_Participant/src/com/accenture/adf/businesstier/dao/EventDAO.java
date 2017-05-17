package com.accenture.adf.businesstier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;
import com.accenture.adf.helper.FERSDbQuery;
import com.mysql.jdbc.Statement;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * A Data Access Object (DAO) class for handling and managing event related data
 * requested, updated, and processed in the application and maintained in the
 * database. The interface between the application and event data persisting in
 * the database. <br/>
 * 
 * @author krishna.kishore
 * 
 */
public class EventDAO {

	// LOGGER for handling all transaction messages in EVENTDAO
	private static Logger log = Logger.getLogger(EventDAO.class);

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private FERSDbQuery query;

	// Default constructor for injecting Spring dependencies for SQL queries
	public EventDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		query = (FERSDbQuery) context.getBean("SqlBean");
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table. <br/>
	 * Execute the SQL statement and keep a reference to the result set.<br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set.<br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Object[]> showAllEvents() throws ClassNotFoundException,
			SQLException {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getSearchEvent());
		resultSet = statement.executeQuery();
		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		log.info("All Events retreived from Database :" + eventList);
	
		while (resultSet.next()) {
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			eventList.add(eventObject);
	
			
		}
		resultSet.close();
		FERSDataConnection.closeConnection();
		return eventList;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO for updating events after the visitor registers for an event <br/>
	 * 
	 * @return void
	 * 
	 * @param eventid
	 * @param sessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */

	public void updateEventNominations(int eventid, int sessionid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateEvent());
		statement.setInt(1, sessionid);
		statement.setInt(2, eventid);
		int status = statement.executeUpdate();
		if (status <= 0)
			throw new FERSGenericException("Records not updated properly",
					new Exception());
		log.info("Event registration status was updated in Database and Seat allocated");
		FERSDataConnection.closeConnection();

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * DAO for checking visitor has already registered for EVENT or not. Sends
	 * boolean values about status.<br/>
	 * 
	 * @return boolean
	 * 
	 * @param visitor
	 * @param eventid
	 * @param sessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public boolean checkEventsofVisitor(Visitor visitor, int eventid,
			int sessionid) throws ClassNotFoundException, SQLException {
		connection = FERSDataConnection.createConnection();
		log.info("Status obtained for Visitor :" + visitor.getFirstName()
				+ " to event with ID :" + eventid);
		
		statement = connection.prepareStatement(query.getCheckEvent());
		statement.setInt(1, sessionid);
		statement.setInt(2, visitor.getVisitorId());
		statement.setInt(3, eventid);
		resultSet = statement.executeQuery();
		int status = 0;
		while (resultSet.next()) {
			status = resultSet.getInt("EVENTCOUNT");
		}
		//System.out.println(status+"fgg");
		resultSet.close();
		log.info("No of times visitor registered for Event :" + status);
		FERSDataConnection.closeConnection();
		if (status >= 1)
			return true;
		else
			return false;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for update event database after unregistering event by visitor <br/>
	 * 
	 * @return void
	 * 
	 * @param eventid
	 * @param eventsessionid
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */

	public void updateEventDeletions(int eventid, int eventsessionid)
			throws ClassNotFoundException, SQLException, Exception {
		connection = FERSDataConnection.createConnection();
		statement = connection.prepareStatement(query.getUpdateDeleteEvent());
		statement.setInt(1, eventsessionid);
		statement.setInt(2, eventid);
		int status1 = statement.executeUpdate();
		/*statement = connection.prepareStatement(query.getDeleteEventS());
		statement.setInt(1, eventsessionid);
		statement.setInt(2, eventid);*/
		//int status = statement.executeUpdate();
		if (status1 <= 0)
			throw new FERSGenericException("Records not updated properly",
					new Exception());
		log.info("Event registration status was updated in Database and Seat released");
		FERSDataConnection.closeConnection();

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database with
	 * names that contain the text entered by the user. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * @param eventname
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */

	public ArrayList<Object[]> showAllEvents(String eventname)
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		int nos=0;
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSearchByEventName());
		//System.out.println(eventname);
		stmt.setString(1,eventname);
		resultSet = stmt.executeQuery();

	
		while(resultSet.next())
		{ 
			Object[] eventObject = new Object[8];
			eventObject[0] = resultSet.getInt("eventid");
			eventObject[1] = resultSet.getString("name");
			eventObject[2] = resultSet.getString("description");
			eventObject[3] = resultSet.getString("duration");
			eventObject[4] = resultSet.getString("eventtype");
			eventObject[5] = resultSet.getString("places");
			eventObject[6] = resultSet.getInt("seatsavailable");
			eventObject[7] = resultSet.getInt("eventsessionid");
			
			eventList.add(eventObject);
			
			
			//System.out.println("seats"+e.getSeatsavailable());
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		}
		//
	
		//System.out.println(eventList.size());
		stmt.close();
		con.close();
		return eventList;
	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database in
	 * ascending order. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table in ascending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */

	public ArrayList<Object[]> showAllEventsAsc()
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSearchEventAsc());
		
		resultSet = stmt.executeQuery();
	
		while(resultSet.next())
		{	Object[] eventObject = new Object[8];
		eventObject[0] = resultSet.getInt("eventid");
		eventObject[1] = resultSet.getString("name");
		eventObject[2] = resultSet.getString("description");
		eventObject[3] = resultSet.getString("duration");
		eventObject[4] = resultSet.getString("eventtype");
		eventObject[5] = resultSet.getString("places");
		eventObject[6] = resultSet.getInt("seatsavailable");
		eventObject[7] = resultSet.getInt("eventsessionid");
		
		
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document.
		eventList.add(eventObject);
		}
		
		//System.out.println(eventList.contains(o));

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return eventList;

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database in
	 * descending order. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table in descending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Object[]> showAllEventsDesc()
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSearchEventDesc());
		
		resultSet = stmt.executeQuery();
		/*rs.last();
System.out.println(rs.getRow());
rs.beforeFirst();	*/	
while(resultSet.next())
		{	Object[] eventObject = new Object[8];
		eventObject[0] = resultSet.getInt("eventid");
		eventObject[1] = resultSet.getString("name");
		eventObject[2] = resultSet.getString("description");
		eventObject[3] = resultSet.getString("duration");
		eventObject[4] = resultSet.getString("eventtype");
		eventObject[5] = resultSet.getString("places");
		eventObject[7] = resultSet.getInt("eventsessionid");
		eventObject[6] = resultSet.getInt("seatsavailable");
		
		
		eventList.add(eventObject);
		
		}
		

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return eventList;

	}
	
	/**
	 * This method fetch the event on basis of eventId
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event
	 * from the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set by using getGetEvent method. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the Event object to the calling method. <br/>
	 * 
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	
	public ArrayList<Object[]> showAllEventsPAsc()
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSearchEventPAsc());
		
		resultSet = stmt.executeQuery();
	
		while(resultSet.next())
		{	Object[] eventObject = new Object[8];
		eventObject[0] = resultSet.getInt("eventid");
		eventObject[1] = resultSet.getString("name");
		eventObject[2] = resultSet.getString("description");
		eventObject[3] = resultSet.getString("duration");
		eventObject[4] = resultSet.getString("eventtype");
		eventObject[5] = resultSet.getString("places");
		eventObject[6] = resultSet.getInt("seatsavailable");
		eventObject[7] = resultSet.getInt("eventsessionid");
		
		
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document.
		eventList.add(eventObject);
		}
		
		//System.out.println(eventList.contains(o));

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return eventList;

	}

	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * DAO for displaying all the Events in the Event Table in the Database in
	 * descending order. <br/>
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the events
	 * from the event table in descending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * Event object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the ArrayList to the calling method. <br/>
	 * 
	 * 
	 * @return Collection of Events
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public ArrayList<Object[]> showAllEventsPDesc()
			throws ClassNotFoundException, SQLException {

		ArrayList<Object[]> eventList = new ArrayList<Object[]>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSearchEventPDesc());
		
		resultSet = stmt.executeQuery();
		/*rs.last();
System.out.println(rs.getRow());
rs.beforeFirst();	*/	
while(resultSet.next())
		{	Object[] eventObject = new Object[8];
		eventObject[0] = resultSet.getInt("eventid");
		eventObject[1] = resultSet.getString("name");
		eventObject[2] = resultSet.getString("description");
		eventObject[3] = resultSet.getString("duration");
		eventObject[4] = resultSet.getString("eventtype");
		eventObject[5] = resultSet.getString("places");
		eventObject[7] = resultSet.getInt("eventsessionid");
		eventObject[6] = resultSet.getInt("seatsavailable");
		
		
		eventList.add(eventObject);
		
		}
		

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return eventList;

	}
	
	
	public Event getEvent(int eventId, int sessionId)
			throws ClassNotFoundException, SQLException {
		
		Event event = new Event();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getGetEvent());
		
		stmt.setInt(1,eventId);
		stmt.setInt(2, sessionId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
		{
			event.setEventid(rs.getInt("eventid"));
			event.setName(rs.getString("name"));
			event.setDescription(rs.getString("description"));
			event.setPlace(rs.getString("places"));
			event.setDuration(rs.getString("duration"));
			event.setEventSession(rs.getInt("eventsessionid"));
			event.setEventtype(rs.getString("eventtype"));
			
			event.setSeatsavailable(rs.getInt("seatsavailable"));		}
		
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return event;
		
		
	}

	/**
	 * This method updates the event
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection 

	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Update the event object by calling getUpdateEventSession method
	 * Event is updated in database. <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param updateEvent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateEvent(Event updateEvent) throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getUpdateTEvent());
		//System.out.println("session"+updateEvent.getEventSession());
		//System.out.println(updateEvent.getSeatsavailable()+" "+updateEvent.getEventSession()+"  "+updateEvent.getEventid());
		stmt.setString(1, updateEvent.getName());
		stmt.setString(2,updateEvent.getDescription());
		stmt.setString(3,updateEvent.getPlace());
		stmt.setString(4,updateEvent.getDuration());
		stmt.setString(5,updateEvent.getEventtype());
		stmt.setInt(6, updateEvent.getEventid());
		
		int b = stmt.executeUpdate();
		stmt.close();
		con.close();
		con = FERSDataConnection.createConnection();
		
		System.out.println(updateEvent.getSessionId());
		System.out.println(updateEvent.getEventid());
		System.out.println(updateEvent.getSeatsavailable());
		stmt=con.prepareStatement(query.getUpdateEventSession());
		stmt.setInt(1,updateEvent.getSeatsavailable() );
		stmt.setInt(2, updateEvent.getSessionId());
		stmt.setInt(3, updateEvent.getEventid());
		int d=stmt.executeUpdate();
		System.out.println(d);
		
	if(b>=0)
		{
		
		log.info("Event Updated");
		}
	else{
		log.info("Event Not Updated");
	}

		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
	stmt.close();
	con.close();
		return b;
	}

	/**
	 * This method inserts new event in database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event
	 * from the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Insert the event object by calling getInsertEvent method
	 * Event object is inserted in database  <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param insertEvent
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertEvent(Event insertEvent) throws ClassNotFoundException,
			SQLException {
		Connection con = null;
		con = FERSDataConnection.createConnection();
		con.setAutoCommit(false);
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getInsertEvent(),Statement.RETURN_GENERATED_KEYS);
		//EVENTID, NAME, DESCRIPTION, PLACES, DURATION, EVENTTYPE
		//stmt.setInt(1,insertEvent.getEventid());
		int s=insertEvent.getEventSession();
		int i=1,c=0;
	
		stmt.setString(1,insertEvent.getName());
		stmt.setString(2, insertEvent.getDescription());
		stmt.setString(3, insertEvent.getPlace());
		stmt.setString(4,insertEvent.getDuration());
		stmt.setString(5, insertEvent.getEventtype());
        int a = stmt.executeUpdate();
		if(a!=0)
		{
			log.info("Value Updated");
		}
		else{
			log.info("Unable To Update");
		}
		
		ResultSet keys=stmt.getGeneratedKeys();
		int eventId = 0;
		if(keys.next())
		 eventId = keys.getInt(1);
		stmt.close();
		
		while(i<=s)
		{
		//INSERT INTO EVENTSESSION(EVENTSESSIONiD, EVENTCOORDINATORID, EVENTID, SEATSAVAILABLE)
		stmt = con.prepareStatement(query.getInsertEventSession());
		
		//ResultSet keys1=stmt.getGeneratedKeys();
		//stmt.setInt(1, keys1.getInt(1));
		
		//stmt.setInt(1,insertEvent.getSessionId());
		
		stmt.setInt(1,insertEvent.getEventCoordinatorId());
		stmt.setInt(2, eventId);
		stmt.setInt(3, insertEvent.getSeatsavailable());
		
		 c = stmt.executeUpdate();
		if(c!= 0)
		{
			log.info("Value Updated In Session Table");
		}
		else{
			log.info("Value Not Updated In Session Table");
		}
		stmt.close();
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		con.commit();
		i++;
		}
		con.close();
		return c;
			}	
	

	/**
	 * This method deletes the event on basis of eventid and eventsessionid from database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that get an event
	 * from the event table for provided event id. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Delete the event object by calling getDeleteEventSession and getDeleteEvent method
	 * Event and EventSession object is deleted from database  <br/>
	 * Return the status of executed query. <br/>
	 * 
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FERSGenericException
	 */
	public int deleteEvent(int eventId, int sessionId)
			throws ClassNotFoundException, SQLException, FERSGenericException {

		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getDeleteEventSessionSignup());
		stmt.setInt(1, sessionId);
		stmt.setInt(2,eventId);
		int r = stmt.executeUpdate();
		//System.out.println("value"+r);
		stmt = con.prepareStatement(query.getDeleteEventSession());
		stmt.setInt(1,sessionId);
		int w = stmt.executeUpdate();
		//System.out.println("value1"+w);
		int value=0;
		stmt = con.prepareStatement(query.getDeleteEvent());
		stmt.setInt(1,eventId);
		int q = stmt.executeUpdate();
		//System.out.println("value2"+q);
		if(w!=0 && q!=0 && r!=0){
			value=1;
			log.info("Event Deleted");
		}
		else{
			log.info("Unable To Delete");
		}
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document
		stmt.close();
		con.close();
		return value;	
	}

	/**
	 * This method fetches the list of event coordinator from database
	 * 
	 * PSEUDOCODE: <br/>
	 * Create a new connection to the database. <br/>
	 * Prepare a statement object using the connection that gets all the eventcoordinator username
	 * from the eventcoordinator table in descending order. <br/>
	 * Execute the SQL statement and keep a reference to the result set. <br/>
	 * Using a WHILE LOOP, store each record in the result set returned in an
	 * EventCoordinator object by setting the values of the Event attributes as the
	 * corresponding values in the Result set. <br/>
	 * Return the List to the calling method. <br/>
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<EventCoordinator> getEventCoordinator()
			throws ClassNotFoundException, SQLException {
		
		List<EventCoordinator> eventCoordinatorList = new ArrayList<EventCoordinator>();
		Connection con = null;
		con = FERSDataConnection.createConnection();
		PreparedStatement stmt =null;
		stmt = con.prepareStatement(query.getSelectEventCoordinator());
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			EventCoordinator e=new EventCoordinator();
			e.setUserName(rs.getString("username"));
			e.setEventcoordinatorid(rs.getInt("eventcoordinatorid"));
			eventCoordinatorList.add(e);
		}
		
		
		// TODO: Add code here.....
		// TODO: Pseudo-code are in the block comments above this method.
		// TODO: For more comprehensive pseudo-code with details,
		// refer to the Component/Class Detail Design Document		
		stmt.close();
		con.close();
		return eventCoordinatorList;
	}
}
