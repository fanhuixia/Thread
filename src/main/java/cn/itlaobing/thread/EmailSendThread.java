package cn.itlaobing.thread;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import java.net.URL;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
public class EmailSendThread implements Runnable{

    private static final String HOST_NAME="smtp.163.com";
    private static final String EMAIL_ACCOUNT="ycdl_mail@163.com";
    private static final String EMAIL_PASSWORD="1qaz2wsx";


    private String title;
    private String content;
    private String to;

    public EmailSendThread(String title, String content, String to) {
        this.title = title;
        this.content = content;
        this.to = to;
    }

    @Override
    public void run() {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(HOST_NAME);
        email.setAuthenticator(new DefaultAuthenticator(EMAIL_ACCOUNT, EMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        try {
            email.addTo(to, "");
            email.setFrom(EMAIL_ACCOUNT, "wq");
            email.setSubject(title);
            email.setCharset("UTF-8");
            email.setHtmlMsg(content);
            email.send();
            System.out.println("邮件发送成功:"+EMAIL_ACCOUNT+"  to  "+to);
        }catch(Exception ex){
                ex.printStackTrace();
        }

    }
}
