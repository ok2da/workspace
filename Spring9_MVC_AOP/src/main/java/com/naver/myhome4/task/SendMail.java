package com.naver.myhome4.task;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.naver.myhome4.domain.MailVO;

@Component
public class SendMail {

   private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

   @Autowired
   private JavaMailSenderImpl mailSender;
   
   @Value("${sendfile}")
   private String sendfile;
   
   // ������Ʈ ��Ŭ�� -> Properties -> Project Facets -> �ڹ� ���� 11�� ���߼���
   public void sendMail(MailVO vo) {

      MimeMessagePreparator mp = new MimeMessagePreparator() {
         // �������̽� �͸�Ŭ����
         /*
          * MimeMessage : �� Ŭ������ MIME ��Ÿ�� �̸��� �޽����� ��Ÿ���ϴ�. MIME (����: Multipurpose Internet
          * Mail Extensions)�� ���� ������ ���� ���ͳ� ǥ�� �����Դϴ�.
          */

         @Override
         public void prepare(MimeMessage mimeMessage) throws Exception {
            /*
             * MimeMessageHelper
             */
            // �ι�° ���� true�� ��Ƽ ��Ʈ �޽����� ����ϰڴٴ� ���Դϴ�.
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(vo.getFrom());
            helper.setTo(vo.getTo());
            helper.setSubject(vo.getSubject());

            // 1. ���ڷθ� �����ϴ� ���
            // true�� html�� ����ϰڴٴ� ���Դϴ�.
            // helper.setText(vo.getContent(),true);

            // 2. �̹����� �����ؼ� ������ ���
            // cid(content id)
            String content = "<img src='cid:Home'>" + vo.getContent();
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(sendfile));
            // addInline�޼����� ù��° �Ű��������� cid(content id)�� �����մϴ�.
            helper.addInline("Home", file);

            // 3. ������ ÷���ؼ� ������ ���
            // ù��° ���� : ÷�ε� ������ �̸��Դϴ�.
            // �ι�° ���� : ÷������
            helper.addAttachment("����.jpg", file);
         }
      };// new MimeMessagePreparator() end

      mailSender.send(mp);// ���� �����մϴ�.
      logger.info("���� �����߽��ϴ�.");
   }// sendMail(MailVO vo)
}// class SendMail