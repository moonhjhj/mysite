package com.javaex.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	//forward, redirect는 항상 있어야 하므로 static으로 만들어버리긔~
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		
		response.sendRedirect(url);
		
	}

}
