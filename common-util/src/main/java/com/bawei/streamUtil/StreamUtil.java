package com.bawei.streamUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
		
	//关闭流的方法
	public static void closeAll(AutoCloseable...autoCloseables) {
		if(autoCloseables!=null) {
			for(AutoCloseable autoCloseable:autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//以流的方式，读取文本内容
	public static String readTextFile(File file) throws IOException {
		InputStream inputStream=null;
		try {
			inputStream=new FileInputStream(file);
			
			byte[] b=new byte[1024];
			
			String str=null;
			
			while(inputStream.read(b)!=-1) {
				str+=new String(b);
			}
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}finally {
			closeAll(inputStream);
		}
		
	}
	
	
	//根据文件全名读取内容
	@SuppressWarnings("resource")
	public static void writeTextFile(String content,File file,boolean append) throws IOException {
		BufferedWriter writer=null;
		
		//判断写文件的文件是否存在
		String parent = file.getParent();
		
		File parentFile = new File(parent);
		
		if(!parentFile.exists()) {
			parentFile.mkdirs();
			
		}
		
		//写文件
		writer=new BufferedWriter(new FileWriter(file,append));
		
		writer.write(content);
		
		writer.flush();
		
		
	}
	public static String readTextFile(String fileFullName) throws IOException {
		return readTextFile(new File(fileFullName));
	}
	
	public static void main(String[] args) {
		
	}
}
