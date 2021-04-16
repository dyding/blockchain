package com.translation.logging;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;//����java.swing���µ�JOptionPane��

import entity.User;
import service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// ����UserService����
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  1.��ȡ����
		 *  2.����service����
		 *  3.���ؽ�� 
		 */
		
		// ��ȡǰ���������������
		String pwd1 = request.getParameter("pwdName1");
		String pwd2 = request.getParameter("pwdName2");
		
		// ����user���󣬽�ǰ����������ݴ�������
		User user = new User();			
		user.setUsername(request.getParameter("userName"));
		
		if(pwd1.equals(pwd2)){
			// �ж����������Ƿ���ͬ����ʵ�������ǿ�����JavaScript��ǰ�˽����ж����������Ƿ���ͬ�������ͬ�ڻ�ȡ��������servlet�оͲ����ж��ˣ�
			user.setPassword(pwd1);
			
			// ����user������ݽ���ע��
			int row = userService.register(user);
			System.out.println("�ı��������"+row);
			
			// ���ؽ������������ע����Ϣrow���ڼ�������һ����ע��row=1
			if (row > 0) {
				System.out.println("ע��ɹ�");
				//��תע��ɹ�����,ע��ɹ���ͨ��ת����ת���µĽ��棬��ȻҲ����ʹ���ض�����������Ϊ�˼򵥲���ת��,������ת����������ֻҪ�޸�registerSuccess.jsp����
				request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
			} else {
				//��תע����沢��ʾ������Ϣ
				System.out.println("ע��ʧ��");
				JOptionPane.showMessageDialog(null, "ע��ʧ��", "����", JOptionPane.PLAIN_MESSAGE);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			
		}else {
			// �����������벻ͬ
			System.out.println("�������벻ͬ��ע��ʧ��");
			JOptionPane.showMessageDialog(null, "�������벻ͬ��ע��ʧ��", "����", JOptionPane.PLAIN_MESSAGE);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}

}
