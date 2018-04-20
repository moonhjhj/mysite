package com.javaex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;

//localhost:8088/mysite/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");

		/************ 회원가입 폼 **************/
		if ("joinform".equals(actionName)) {// 회원가입 폼
			WebUtil.forward(request, response, "WEB-INF/views/user/joinform.jsp");

			/*************** 회원정보 저장 ***************/
		} else if ("join".equals(actionName)) {// 회원정보 저장(저장로직에 들어가야 함)
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");

			// 묶어줄 애 필요->vo 필요함 -> vo 만듬
			UserVo vo = new UserVo(name, email, password, gender);
			System.out.println(vo.toString());

			// dao 필요 ->dao 만듬
			UserDao userDao = new UserDao();
			userDao.insert(vo);

			WebUtil.forward(request, response, "/WEB-INF/views/user/joinsuccess.jsp");

			
		} else if ("loginform".equals(actionName)) {
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");

			
		} else if ("login".equals(actionName)) {
			// loginform에서 버튼 누르면 여기로 넘어옴?
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			UserDao userDao = new UserDao();
			UserVo userVo = userDao.getUser(email, password);

			if (userVo == null) {// 로그인 실패
				System.out.println("로그인 실패");
				WebUtil.redirect(request, response, "/mysite/user?a=loginform&result=fail");

				
			} else {// 로그인 성공
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("authUser", userVo);
				WebUtil.redirect(request, response, "/mysite/main");// redirect는 web-inf/로 하면 안됨?
			}
			
		}else if("logout".equals(actionName)) {
			HttpSession session = request.getSession();
			session.removeAttribute("authUser");
			session.invalidate();
			WebUtil.redirect(request, response, "/mysite/main");
			
			
		}else if("modifyform".equals(actionName)) {
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/modifyform.jsp");
			
			
		}else if("modify".equals(actionName)) {
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			UserDao userDao = new UserDao();
			int no = authUser.getNo();
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			authUser.setName(name);
			authUser.setPassword(password);
			authUser.setGender(gender);
			
			UserVo vo = new UserVo(no, name, password, gender);
			userDao.modify(vo);
			WebUtil.redirect(request, response, "/mysite/main");
			

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
