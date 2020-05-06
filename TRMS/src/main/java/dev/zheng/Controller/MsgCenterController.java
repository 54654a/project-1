package dev.zheng.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.zheng.employees.MsgCenter;
import dev.zheng.service.MsgCenterService;

public class MsgCenterController {

	public static Gson gson = new Gson();
	public static void getMsgCenter(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		String id = request.getParameter(
				"employee.id");
		int employeeId = Integer.parseInt(id);
		List<MsgCenter> mList = MsgCenterService.getAllMsg(employeeId);

		if(mList != null) {
			response.getWriter().append(gson.toJson(mList));
		}else {
			response.getWriter().append("{}");
		}
	}
	
	public static void addMsg(HttpServletRequest request,
	HttpServletResponse response) throws IOException{
//		String employeeId = request.getParameter(
//				"newRequest[count].employeeId");
//		String strMsg = request.getParameter("tempMsg.msgInfo");
//		int senderId = Integer.parseInt(request.getParameter("tempMsg.senderId"));
//		MsgCenter mc = new MsgCenter(Integer.parseInt(employeeId),strMsg, senderId);
//		
//		MsgCenterService.addMsgCenter(mc);
//		response.getWriter().append(gson.toJson(mc));	
		MsgCenter msg =gson.fromJson(request.getReader(),MsgCenter.class);
		System.out.println("this is msg from web"+msg);
		MsgCenterService.addMsgCenter(msg);
		
		response.getWriter().append(gson.toJson(msg));
	
	} 
	
	public static void updateMsg(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String employeeId = request.getParameter(
				"msg[m].msgId");
		String strMsg = request.getParameter("readState");
		MsgCenter mc = new MsgCenter(Integer.parseInt(employeeId),strMsg);
		
		MsgCenterService.addMsgCenter(mc);
		response.getWriter().append(gson.toJson(mc));	
	}
}
