package com.bawei.fileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
		
		//根据文件，截取拓展名
		public static String getExtName(String fileName) {
			//处理空异常
			
			if(fileName==null||"".equals(fileName)) {
				throw new RuntimeException("文件名不能为空");
			}
			
			if(fileName.indexOf(".")<=-1) {
				throw new RuntimeException(fileName+":该文件名没有包含扩展名");
			}
			
			
			String extName=fileName.substring(fileName.lastIndexOf("."));
			
			return extName;
		}
		
		
		//获取系统当前用户目录
		public static String getSystemUserHome() {
			return System.getProperty("user.home");
		}
		
		//读取文件内容
		public static String readTextFileByLine(String pathname) throws IOException {
				BufferedReader br=null;
				StringBuffer sb = new StringBuffer();
				
				try {
					br=new BufferedReader(new FileReader(new File(pathname)));
					
					do {
						sb.append(br.readLine());
						
						sb.append("\r\n");
					}while(br.read()!=-1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					return null;
				}
				
				return sb.toString();
		}
		
		
		//按行读取文件内容到List集合
		@SuppressWarnings("resource")
		public static List<String> readTextFileOfList(String pathname) throws IOException{
			BufferedReader br=null;
			
			List<String> strList= new ArrayList<String>();
			
			try {
				br=new BufferedReader(new FileReader(new File(pathname)));
				
				do {
					strList.add(br.readLine());
				}while(br.read()!=-1);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return strList;
			
			
		}
		
		
		//递归删除文件
		
		public static void deleteFile(File file) {
			if(file.isDirectory()) {
				File[] listFiles = file.listFiles();
				
				for (File file2 : listFiles) {
					deleteFile(file2);
				}
				
				file.delete();
			}else {
				file.delete();
			}
		}
		
		
		//获取文件大小返回文件以指定单位大小
		
		public static String getFileSize(File file) {
			
			long length = file.length();
			
			double len=length/1024.0;
			
			return String.format("%.2f%",len)+"kb";
		}
		
		
		public static String getFileSize(String fileFullName) {
			return getFileSize(new File(fileFullName));
		}
		
		
		public static void mian(String[] args) {
			System.out.println(getSystemUserHome());
		}
}
