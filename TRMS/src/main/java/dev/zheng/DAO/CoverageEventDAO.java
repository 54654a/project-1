package dev.zheng.DAO;

import java.util.List;

import dev.zheng.employees.CoverageEvent;

public interface CoverageEventDAO {

	public boolean addCoverageEvent(CoverageEvent e);
	public List<CoverageEvent> getAllEvents();
	public CoverageEvent getCoverageEvent(int eventId);
	public boolean updateCoverageEvent(CoverageEvent change);
	public boolean deleteCoverageEvent(int deleteId);
	
}
