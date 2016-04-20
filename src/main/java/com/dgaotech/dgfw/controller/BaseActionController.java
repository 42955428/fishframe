package com.dgaotech.dgfw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.*;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dgaotech.base.exception.BussinessProcessException;
import com.dgaotech.base.util.Constants;
import com.dgaotech.dgfw.entity.ResultMessage;

@Controller
public class BaseActionController {

	static Logger logger = LoggerFactory.getLogger(BaseActionController.class);
	
	public String getRequestParameter(HttpServletRequest request,String param,String defauleValue){
		return request.getParameter(param)==null?defauleValue:request.getParameter(param);
	} 
	
	public void write(HttpServletResponse response,String outStr){
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(outStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void writeJson(HttpServletResponse response,String outStr){
		response.setContentType("application/json;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(outStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void writeXml(HttpServletResponse response,String outStr){
		response.setContentType("text/xml;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(outStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    public String getIpAdddress(HttpServletRequest request) {
		return request.getHeader("x-forwarded-for") == null?request.getRemoteAddr():request.getHeader("x-forwarded-for");
	}
  
    
	public ModelAndView systemError(ResultMessage message) {
		return new ModelAndView("error/success", "message", message);
	}
	
	public ResultMessage handleException(ResultMessage message,
			Exception ex)
	{
		ex.printStackTrace();
		if(ex instanceof BussinessProcessException){
			message.setCode(Constants.CODE_PARAMETER_ERROR);
			message.setMessage(ex.getMessage());
		}else{
			message.setCode(Constants.CODE_SYSTEM_ERROR);
			message.setMessage(Constants.MESSAGE_SYSTEM);
		}
		return message;
	}
	
	public void handleException(JSONObject object,
			Exception ex)
	{
		ex.printStackTrace();
		if(ex instanceof BussinessProcessException){
			object.put(Constants.JSON_RETURN_CODE, Constants.CODE_PARAMETER_ERROR);
			object.put(Constants.JSON_RERUTN_MESSAGE, ex.getMessage());
		}else{
			object.put(Constants.JSON_RETURN_CODE, Constants.CODE_SYSTEM_ERROR);
			object.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_SYSTEM);
		}
	}
	
	
	public void handleException(Map object,
			Exception ex)
	{
		ex.printStackTrace();
		if(ex instanceof BussinessProcessException){
			object.put(Constants.JSON_RETURN_CODE, Constants.CODE_PARAMETER_ERROR);
			object.put(Constants.JSON_RERUTN_MESSAGE, ex.getMessage());
		}else{
			object.put(Constants.JSON_RETURN_CODE, Constants.CODE_SYSTEM_ERROR);
			object.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_SYSTEM);
		}
	}
	
    @RequestMapping("/exception")
	public ModelAndView error(HttpServletRequest request, 
			HttpServletResponse response) {
    	
    	String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header))
        {
        	JSONObject json = new JSONObject();
        	json.put(Constants.JSON_RETURN_CODE, Constants.CODE_PARAMETER_ERROR);
        	json.put(Constants.JSON_RERUTN_MESSAGE, "test");
        	write(response,json.toString());
        	return null;
        }
		return new ModelAndView("exception/message", "message", new ResultMessage(Constants.CODE_PARAMETER_ERROR,"test"));
	}   
}
