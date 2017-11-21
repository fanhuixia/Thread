package cn.itlaobing.emailtest;

import cn.itlaobing.thread.EmailSendThread;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
public class TestEmailSend {


    @Test
    public void sendMail() throws EmailException, MalformedURLException, UnsupportedEncodingException {

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setAuthenticator(new DefaultAuthenticator("ycdl_mail@163.com", "1qaz2wsx"));
        email.setSSLOnConnect(true);

        email.addTo("16910735@qq.com", "");
        email.setFrom("ycdl_mail@163.com", "wq");
        email.setSubject("账号激活");

        email.setCharset("UTF-8");

        // embed the image and get the content id
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
        String cid = email.embed(url, "Apache logo");
        // set the html message
        String content="<html><meta charset=\"utf-8\" />" +
                "账号激活地址：<a href='http://localhost:8080/user/xxxxxxxxxxxx'>http://localhost:8080/user/xxxxxxxxxxxx</a>"+
                "</html>";
        email.setHtmlMsg(new String(content.getBytes(),"UTF-8"));
        // set the alternative message
        email.setTextMsg("此邮件不需要回复");
        // send the email
        email.send();

    }


    @Test
    public void sendMailThread() throws EmailException, MalformedURLException, UnsupportedEncodingException, InterruptedException {
        String to="16910735@qq.com";
        String title="账号激活";
        String content="<html><meta charset=\"utf-8\" />" +
                "账号激活地址：<a href='http://localhost:8080/user/xxxxxxxxxxxx'>http://localhost:8080/user/xxxxxxxxxxxx</a>"+
                "</html>";
        EmailSendThread emailSendWorker=new EmailSendThread(title,content,to);

      new Thread(emailSendWorker).start();


        Thread.sleep(15000);
        System.out.println("====================================");

    }
}
