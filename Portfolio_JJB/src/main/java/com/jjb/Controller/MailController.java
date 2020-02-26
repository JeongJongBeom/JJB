package com.jjb.Controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/mail", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public boolean mailSending(String email, int randomNum) throws Exception{
		System.out.println("���� "+email);
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

			messageHelper.setTo(email);// �޴� ���
			messageHelper.setSubject("������ ���� �����Դϴ�.");// ����(������ ����)
			messageHelper.setText("������ ���� ���Ϸ� ������ �����ôٸ� ȸ������ ������ȣ���� ������ ���� �־��ֽñ� �ٶ��ϴ�.  ������ȣ : "+randomNum);// ���� ����

			mailSender.send(message);
			//String result="������ ���� ������ �߼۵Ǿ����ϴ�.";
			System.out.println("�Ϸ�");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//String result="���� �߼��� �����Ͽ����ϴ�.";
			return false;
		}
	}
}
