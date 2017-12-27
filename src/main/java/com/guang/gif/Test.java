package com.guang.gif;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.guang.gif.tools.GAutoTool;
import com.guang.gif.tools.GTools;

public class Test {

	public static void main(String[] args) throws ParseException {
//		GTools.tozipPic("/Users/guang/Downloads/2.gif", "/Users/guang/Downloads/2.jpg");
//		GAutoTool.test("http://www.gaoxiaogif.com/zhenrengif/9466.html");
		String name = "/Users/guang/upliad/gif/2012";
		System.out.println(name = name.substring(name.indexOf("gif")+3,name.length()));
	}
	
}
