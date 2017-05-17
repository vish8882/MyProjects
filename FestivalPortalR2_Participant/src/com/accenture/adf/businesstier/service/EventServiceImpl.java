package com.accenture.adf.businesstier.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 * SERVICE class for the EVENT objects with DAO layer
 */
public class EventServiceImpl implements EventFacade {

	// LOGGER for handling all exceptions
	private static Logger log = Logger.getLogger(EventServiceImpl.class);

	/**
	 * SERVICE CLASS for displaying all events from DAO
	 */
	public List<Object[]> getAllEvents() {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEvents();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}

	/**
	 * SERVICE CLASS for identifying all events for visitor
	 */
	public boolean checkEventsofVisitor(Visitor visitor, int eventid,
			int sessionid) {
		EventDAO dao = new EventDAO();
		boolean status = false;
		try {
			status = dao.checkEventsofVisitor(visitor, eventid, sessionid);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return status;
	}

	/**
	 * SERVICE CLASS for deleting events for visitor
	 */
	public void updateEventDeletions(int eventid, int eventsessionid) {
		EventDAO dao = new EventDAO();
		try {
			dao.updateEventDeletions(eventid, eventsessionid);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (Exception exception) {
			log.info("Exception is :" + exception.getMessage());
		}

	}

	/**
	 * SERVICE CLASS for displaying all events based on eventname from DAO
	 */

	public List<Object[]> getAllEvents(String eventname) {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEvents(eventname);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}

	/**
	 * SERVICE CLASS for displaying all events from DAO in Ascending Order
	 */
	public List<Object[]> getAllEventsAsc() {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEventsAsc();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}

	/**
	 * SERVICE CLASS for displaying all events from DAO in Descending Order
	 */
	public List<Object[]> getAllEventsDesc() {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEventsDesc();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}

	public List<Object[]> getAllEventsPAsc() {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEventsPAsc();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}

	/**
	 * SERVICE CLASS for displaying all events from DAO in Descending Order
	 */
	public List<Object[]> getAllEventsPDesc() {

		EventDAO dao = new EventDAO();
		ArrayList<Object[]> showEvents = new ArrayList<Object[]>();
		try {
			showEvents = dao.showAllEventsPDesc();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showEvents;
	}
	/**
	 * SERVICE CLASS for displaying event from DAO in on the basis of event id
	 */
	@Override
	public Event getEvent(int eventId, int sessionId) {
		EventDAO dao = new EventDAO();
		Event event = new Event();
		try {
			event = dao.getEvent(eventId, sessionId);
		} catch (ClassNotFoundException exception) {			
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());			
		}
		return event;
	}

	/**
	 * SERVICE CLASS for displaying event from DAO in on the basis of event id
	 */ 
	@Override
	public int updateEvent(Event event) {
		EventDAO dao = new EventDAO();
		int status = 1;
		try {
			status = dao.updateEvent(event);
		} catch (ClassNotFoundException exception) {			
			log.info("Exception is :" + exception.getMessage());
			return 0;
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());			
			return 0;
		}
		return status;
	}

	/**
	 * SERVICE CLASS for displaying event from DAO in on the basis of event id
	 */
	@Override
	public int deleteEvent(int eventId, int sessionId) {
		EventDAO dao = new EventDAO();
		int status = 1;
		try {
			status = dao.deleteEvent(eventId, sessionId);
		} catch (ClassNotFoundException exception) {			
			log.info("Exception is :" + exception.getMessage());
			return 0;
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());			
			return 0;
		} catch (FERSGenericException exception) {
			log.info("Exception is :" + exception.getMessage());			
			return 0;
		}
		return status;
	}

	/**
	 * SERVICE CLASS for displaying event from DAO in on the basis of event id
	 */
	@Override
	public int insertEvent(Event event) {
		EventDAO dao = new EventDAO();
		int status = 1;
		try {
			status = dao.insertEvent(event);
		} catch (ClassNotFoundException exception) {			
			log.info("Exception is :" + exception.getMessage());
			
			return 0;
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
			return 0;
		}
		return status;
	}

	/**
	 * SERVICE CLASS fetching eventCoordinators from DAO
	 */
	@Override
	public List<EventCoordinator> getAllEventCoordinators() {
		EventDAO dao = new EventDAO();
		List<EventCoordinator> eventCoordinatorList = new ArrayList<EventCoordinator>();
		try {
			eventCoordinatorList = dao.getEventCoordinator();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());			
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());			
		}
		return eventCoordinatorList;
	}

}
