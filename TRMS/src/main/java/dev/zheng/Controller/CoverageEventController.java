package dev.zheng.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.CoverageEvent;
import dev.zheng.service.CoverageEventService;

public class CoverageEventController {

	public static Gson gson = new Gson();
	public static void getCoverageEvent(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		String eventId = request.getParameter("eventId");
		CoverageEvent re = CoverageEventService.getCoverageEvent(
				Integer.parseInt(eventId));
		if(re != null) {
			response.getWriter().append(gson.toJson(re));
		}else {
			response.getWriter().append("{}");
		}
	}
}
