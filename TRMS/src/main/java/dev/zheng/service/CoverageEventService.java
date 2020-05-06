package dev.zheng.service;

import java.util.List;

import dev.zheng.DAO.CoverageEventDAO;
import dev.zheng.DAO.CoverageEventDAOImpl;
import dev.zheng.employees.CoverageEvent;

public class CoverageEventService {
	
	public static CoverageEventDAO ced = new CoverageEventDAOImpl();
	
	public static boolean addCoverageEvent(CoverageEvent e) {
		return ced.addCoverageEvent(e);
	}
	
	public static List<CoverageEvent> getAllEvents(){
		return ced.getAllEvents();
	}
	
	public static CoverageEvent getCoverageEvent(int eventId) {
		return ced.getCoverageEvent(eventId);
	}
	
	public boolean updateCoverageEvent(CoverageEvent change) {
		return ced.updateCoverageEvent(change);
	}
	
	public boolean deleteCoverageEvent(int deleteId) {
		return ced.deleteCoverageEvent(deleteId);
	}

}
