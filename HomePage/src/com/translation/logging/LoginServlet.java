package com.translation.logging;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;//����java.swing���µ�JOptionPane��

import entity.User;
import service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// ����UserService����
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. ��ȡ���� 2. ��֤�û� 3. ���ؽ��
		 */
		/**
		 * 1.��ȡ����
		 * request.getParameter("userName");������Ĳ���username����ǰ��<input>��ǩ�е�name,����д��
		 */
		String username = request.getParameter("userName");
		String password = request.getParameter("pwdName");
		
		// ����userService�����е�login������֤��¼�û�
		User user = userService.login(username,password);
		System.out.println(user==null);
		
		if (user != null) {
			// �û���Ϊ�գ������û����ڣ��ɹ���¼
			System.out.println("��¼�ɹ�");
		
			/*
			 * ����һ��session�����洢user
			 * session��javaweb��һ������洢���ݵģ��൱�����Կ�װ�����ʱ��user�������е�һ��Կ�ף�
			 * ��user������ڣ���Ҫ��ʱ����ȡ��������ǰ��jspҳ��ǳ����ã������׵�ͬѧ����ȥѧһ������Ͳ�׸����
			 * */
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// ��¼�ɹ���ͨ��ת����ת���µĽ��棬��ȻҲ����ʹ���ض�����������Ϊ�˼򵥲���ת��,������ת����������ֻҪ�޸�loginSuccess.jsp����
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);// ת��
		} else {
			// userΪ�գ������û�������
			System.out.println("��½ʧ��");
			JOptionPane.showMessageDialog(null, "�˺Ż������������������", "����", JOptionPane.PLAIN_MESSAGE);
			// ��¼ʧ��ͨ��ת�����ڻص���¼����������е�¼
			request.getRequestDispatcher("index.jsp").forward(request, response);// ת��
		}
		
	}

}
