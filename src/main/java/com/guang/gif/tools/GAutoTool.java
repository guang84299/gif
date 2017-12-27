package com.guang.gif.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.guang.gif.mapper.ArticleMapper;
import com.guang.gif.mapper.TagMapper;
import com.guang.gif.pojo.Article;
import com.guang.gif.pojo.Tag;
import com.guang.gif.pojo.TagExample;




public class GAutoTool {
	public static String realPath = null;
	public static void autoAdd(String url)
	{
		realPath = GTools.getUploadDir();
		autoGaoXiaoGif(url);
	}
	
	
	
	public static void test(String url)
	{
		realPath = GTools.getUploadDir();
		Document document = null;
		//获取指定网址的页面内容
		try {
			document = Jsoup.connect(url).
//					header("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36").
//					 header("Referer","http://www.oschina.net/blog").
//					 header("Host","www.oschina.net").
//					 header("Origin","http://www.oschina.net").
//					header("Accept-Encoding","gzip, deflate").
//					header("Accept-Charset","GBK").
//					 header("Accept-Language","zh-CN,zh;q=0.8").
//					 header("X-Requested-With","XMLHttpRequest").
//					 header("Content-Type","text/html;charset=GBK").
//					 header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8").
					 timeout(50000).get();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String nowTime = formatter.format(new Date().getTime()-0*24*60*60*1000);
			System.out.println(nowTime);
			
			Elements elements = document.select(".listgif-box img");
			String title = "";
			String picurl = "";
			if(elements != null && elements.size()>0)
			{
				title = elements.get(0).attr("alt");
				picurl = elements.get(0).attr("src");
				picurl = picurl.replace("https", "http");
			}
			System.out.println(title);
			System.out.println(picurl);
			
			//关键字
			elements = document.select("meta[name=keywords]");
			String keywords = "";
			if(elements != null && elements.size()>0)
			{
				keywords = elements.get(0).attr("content");
			}
			System.out.println(keywords);
			//next url
			elements = document.select(".ico_next a");
			String next = "";
			if(elements != null && elements.size()>0)
			{
				next = elements.get(0).attr("href");
				next = url.substring(0, url.indexOf(".com")+4) + next;
			}
			System.out.println(next);
			
			//标签
			elements = document.select(".tagsinfo a");
			String tag = "";
			if(elements != null && elements.size()>0)
			{
				if(elements.size()>1)
					tag = elements.get(1).text();
				else
					tag = elements.get(0).text();
			}
			System.out.println(tag);
			
			//时间
			elements = document.select(".gif-time");
			String time = "";
			if(elements != null && elements.size()>0)
			{
				time = elements.get(0).text();
				time = time.split(" ")[1];
			}
			System.out.println(time);
			
			String ext = FilenameUtils.getExtension(picurl);
			DateFormat formatDir = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formatFile = new SimpleDateFormat("HHmmssSS");
			File dir = new File(realPath + formatDir.format(new Date()));
			if(!dir.exists())
				dir.mkdirs();		
			//保存图片到 
			String name = dir.getAbsolutePath() + "/" +formatFile.format(new Date()) + "." + ext;
			System.out.println(name);
			
			if(downloadPic(picurl,name))
			{
				GTools.tozipPic(name, name.substring(0,name.lastIndexOf("."))+".jpg");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void autoGaoXiaoGif(String url)
	{
		Document document = null;
		
		try {
//			document = Jsoup.connect(url). timeout(50000).get();
			//获取指定网址的页面内容  解决乱码问题
			document = Jsoup.parse(new URL(url).openStream(), "GBK", url);
			Elements elements = document.select(".listgif-box img");
			String title = "";
			String picurl = "";
			if (elements != null && elements.size() > 0) {
				title = elements.get(0).attr("alt");
				picurl = elements.get(0).attr("src");
				picurl = picurl.replace("https", "http");
			}

			// 关键字
			elements = document.select("meta[name=keywords]");
			String keywords = "";
			if (elements != null && elements.size() > 0) {
				keywords = elements.get(0).attr("content");
			}

			// next url
			elements = document.select(".ico_next a");
			String next = "";
			if (elements != null && elements.size() > 0) {
				next = elements.get(0).attr("href");
				if(!next.contains("www.gaoxiaogif.com"))
					next = url.substring(0, url.indexOf(".com") + 4) + next;
			}

			// 标签
			elements = document.select(".tagsinfo a");
			String tag = "";
			if (elements != null && elements.size() > 0) {
				if (elements.size() > 1)
					tag = elements.get(1).text();
				else
					tag = elements.get(0).text();
			}

			// 时间
			elements = document.select(".gif-time");
			String time = "";
			if (elements != null && elements.size() > 0) {
				time = elements.get(0).text();
				time = time.substring(time.indexOf("-")-4, time.length());
			}
			
			long now = System.currentTimeMillis()+3*24*60*60*1000;

			String ext = FilenameUtils.getExtension(picurl);
			DateFormat formatDir = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formatFile = new SimpleDateFormat("HHmmssSS");
			File dir = new File(realPath  + formatDir.format(new Date(now)));
			if (!dir.exists())
				dir.mkdirs();
			// 保存图片到
			String name = dir.getAbsolutePath() + "/" + formatFile.format(new Date(now)) + "." + ext;
			if (downloadPic(picurl, name)) {
				GTools.tozipPic(name, name.substring(0, name.lastIndexOf(".")) + ".jpg");
			}
			else
			{
				System.out.println("下载失败："+name);
				System.out.println(next);
				autoGaoXiaoGif(next);
			}
			
			name = name.substring(name.indexOf("gif")+3,name.length());
			
			TagMapper tagMapper = BeanTools.getBean("tagMapper");
			
			TagExample tagExample = new TagExample();
			tagExample.createCriteria().andNameEqualTo(tag);
			List<Tag> tags = tagMapper.selectByExample(tagExample);
			Tag t = null;
			if(tags.size()<=0)
			{
				t = new Tag();
				t.setName(tag);
				t.setNamePy(PinYinTools.getPinYin(tag));
				t.setShowNum(0l);
				tagMapper.insert(t);
			}
			else
			{
				t = tags.get(0);
			}
			
			Article obj = new Article();
			obj.setTitle(title);
			obj.setKeywords(keywords);
			obj.setPicPath(name);
			obj.setHeadPath(name.replace("." + ext, ".jpg"));
			obj.setTagId(t.getId());
			obj.setCommentNum(0l);
			obj.setGrelease(true);
			obj.setLoveNum(0l);
			obj.setShowNum(0l);
			obj.setcDate(new Date(now));
			
			ArticleMapper articleMapper = BeanTools.getBean("articleMapper");
			articleMapper.insert(obj);
			
			Date d = formatDir.parse(time);
			System.out.println(url +"   "+tag + "    "+time);
			if(next != null && !"".equals(next) && new Date().getTime()-d.getTime()<5*365*24*60*60*1000l)
			{
				System.out.println(next);
				autoGaoXiaoGif(next);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	   * 下载文件到本地
	   *
	   * @param urlString
	   *          被下载的文件地址
	   * @param filename
	   *          本地文件名
	   */
	public static boolean downloadPic(String urlString, String filename) {
		InputStream is = null;
		OutputStream os = null;
		boolean result = false;
		try {
			File file = new File(filename);
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			
			HostnameVerifier hv = new HostnameVerifier() {  
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}  
		    };  
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);  
			
			// 构造URL
			URL url = new URL(urlString);
			 // 打开连接
		    URLConnection con = url.openConnection();
		    con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		    if(urlString.contains("gaoxiao.jokeji.cn"))
		    	con.setRequestProperty("Referer","http://gaoxiao.jokeji.cn/"); 
		    else if(urlString.contains("mmonly"))
		    	con.setRequestProperty("Referer","http://www.mmonly.cc");
		    // 输入流
		    is = con.getInputStream();
		    // 1K的数据缓冲
		    byte[] bs = new byte[1024];
		    // 读取到的数据长度
		    int len;
		    // 输出的文件流
		    os = new FileOutputStream(file);
		    // 开始读取
		    while ((len = is.read(bs)) != -1) {
		      os.write(bs, 0, len);
		    }
		    result = true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(os != null)
			   {
				   try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			   if(is != null)
			   {
				   try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
		}
	    return result;
	}   
	
	private static void trustAllHttpsCertificates() {  
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];  
        javax.net.ssl.TrustManager tm = new miTM();  
        trustAllCerts[0] = tm;  
        javax.net.ssl.SSLContext sc;
		try {
			sc = javax.net.ssl.SSLContext  
			        .getInstance("SSL");
			sc.init(null, trustAllCerts, null);
			javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc  
	                .getSocketFactory());  
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
    }  
	
	static class miTM implements javax.net.ssl.TrustManager,javax.net.ssl.X509TrustManager {  
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
	
	static class TouTiaoElement
	{
		private String con;
		private boolean pic;
		public TouTiaoElement(boolean pic,String con)
		{
			this.pic = pic;
			this.con = con;
		}
		public String getCon() {
			return con;
		}
		public void setCon(String con) {
			this.con = con;
		}
		public boolean isPic() {
			return pic;
		}
		public void setPic(boolean pic) {
			this.pic = pic;
		}
		
	}
}
