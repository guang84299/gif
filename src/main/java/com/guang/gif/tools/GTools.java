package com.guang.gif.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FilenameUtils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import com.guang.gif.tools.GifDecoder.GifImage;
import com.sun.mail.util.MailSSLSocketFactory;

public class GTools {
	private static String uploadDir = null;
	public static String getUploadDir()
	{
		if(uploadDir == null)
		{
			InputStream inStream = GTools.class.getClassLoader().getResourceAsStream("config.properties");  
			Properties pro = new Properties();
			try {
				pro.load(inStream);
				inStream.close();
				uploadDir = (String) pro.get("uploadDir");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return uploadDir;
	}
	//获取范围随机数
	public static int getRand(int start, int end) {
		int num = (int) (Math.random() * end);
		if (num < start)
			num = start;
		else if (num >= start && num <= end)
			return num;
		else {
			num = num + start;
			if (num > end)
				num = end;
		}
		return num;
	}
	
	//生成一个唯一名字
	 public static String getRandomUUID() {
	        String uuidRaw = UUID.randomUUID().toString();
	        return uuidRaw.replaceAll("-", "");
	   }
	 
	 //生成图条tid
	 public static String getRandomTid()
	 {
		 return System.currentTimeMillis()+"";
	 }
	 
	 //生成一个验证码
	 public static String getRandCode()
	 {
		 String code = "";
		 for(int i=0;i<4;i++)
		{
			int r = (int) (Math.random()*100) %10;
			code += r;
		}
		 return code;
	 }
	 
	 //long日期转String
	 public static String time2String(long time)
	 {
		 long s = 1000;
		 long min = 60 * s;
		 long hours = 60 * min;
		 long day = 24 * hours;
		 long mo = 30 * day;
		 
		 String t = time+"毫秒";
		 if(time > mo)
		 {
			 t = time/mo +"月";
		 }
		 else if(time > day)
		 {
			 t = time/day +"天";
		 }
		 else if(time > hours)
		 {
			 t = time/hours +"小时";
		 }
		 else if(time > min)
		 {
			 t = time/min +"分钟";
		 }
		 else if(time > s)
		 {
			 t = time/s +"秒";
		 }
		 return t;
	 }
	 
	public static void sendMail(String sendAdress, String value) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
		props.setProperty("mail.smtp.port", "465");
		
		//使用SSL，企业邮箱必需！
		//开启安全协议
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		 
		Session session = Session.getInstance(props, new MyAuthenricator("mail@tutiaoba.com", "Ycg1992"));
//		session.setDebug(true);
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress("mail@tutiaoba.com","图条吧"));
			mimeMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(sendAdress));
			mimeMessage.setSubject("亲,欢迎注册图条吧,赶快激活您的账号吧！");
			mimeMessage.setSentDate(new Date());
			mimeMessage.setText("您好，感谢您注册图条吧，请点击下面的链接激活您的账号：\n http://www.tutiaoba.com/user_active?mail="+sendAdress);
			mimeMessage.saveChanges();
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean sendMail2(String sendAdress) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
		props.setProperty("mail.smtp.port", "465");
		
		//使用SSL，企业邮箱必需！
		//开启安全协议
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		 
		Session session = Session.getDefaultInstance(props, new MyAuthenricator("mail@tutiaoba.com", "Ycg1992"));
//		session.setDebug(true);
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress("mail@tutiaoba.com","图条吧"));
			mimeMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(sendAdress));
			mimeMessage.setSubject("亲，最新最好看的美女故事，图片故事，搞笑故事，尽在图条吧，快来吧！");
			mimeMessage.setSentDate(new Date());
			mimeMessage.setText("您好，想看最新最好看的故事吗？点击下面链接查看：\n http://www.tutiaoba.com");
			mimeMessage.saveChanges();
			Transport.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	static class MyAuthenricator extends Authenticator {
		String u = null;
		String p = null;

		public MyAuthenricator(String u, String p) {
			this.u = u;
			this.p = p;
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(u, p);
		}
	}
	
	//压缩图片
	public static void tozipPic(String picPath,String toPicPath)
	{
		File fromPic = new File(picPath); 
		File toPic=new File(toPicPath); 
		try {
			if(FilenameUtils.getExtension(picPath).toLowerCase().equals("gif"))
			{
				FileInputStream data = new FileInputStream(fromPic);
				GifImage gif = GifDecoder.read(data);
				Thumbnails.of(gif.getFrame(0)).size(300,300).sourceRegion(Positions.CENTER,300,300).toFile(toPic);
			}
			else
			{
				Thumbnails.of(fromPic).size(300,300).sourceRegion(Positions.CENTER,300,300).toFile(toPic);
			}
//			Thumbnails.of(fromPic).size(300,300).outputQuality(0.6f).toFile(toPic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	//效验    
    public static boolean sqlValidate(String str) {    
        str = str.toLowerCase();//统一转为小写    
      //过滤掉的sql关键字，可以手动添加  
        String[] badStrs = new String[]{
        		"'","select","update","and","or","delete","insert","truncate","char","into",
        		"substr","declare","exec","master","drop","execute","union",";","--","+",",",
        		"like","//","/","%","#","*","$","@","\"","http","cr","lf","<",">","(",")"
        }; 
        
        for (int i = 0; i < badStrs.length; i++) {   
            if (str.indexOf(badStrs[i]) >= 0) {    
                return true;    
            }    
        }    
        return false;    
    }  
    
    //搜索关键字
    public static List<String> searchKeywords(String val)
    {
    	List<String> vals = new ArrayList<String>();
		int len = val.length();
		if(len > 30)
			val = val.substring(0,30);
		len = val.length();
		if(len == 1)
			vals.add(val);
		//2
		for(int i=0;i<len-1;i++)
		{
			vals.add(val.substring(i,i+2));
		}
//		//3
//		for(int i=0;i<len-2;i++)
//		{
//			vals.add(val.substring(i,i+3));
//		}
//		//4
//		for(int i=0;i<len-3;i++)
//		{
//			vals.add(val.substring(i,i+4));
//		}
//		//5
//		for(int i=0;i<len-4;i++)
//		{
//			vals.add(val.substring(i,i+5));
//		}
		if(len > 2)
			vals.add(val);
		return vals;
    }
    
    
    public static String encode(String url)  
	 {  
	     try {  
	          Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(url);  
	          while (matcher.find()) {  
	            String tmp=matcher.group();  
	            url=url.replaceAll(tmp,java.net.URLEncoder.encode(tmp,"utf-8"));  
	          }  
	     } catch (UnsupportedEncodingException e) {  
	         e.printStackTrace();  
	     }  
	     return url;  
	 }  
}
