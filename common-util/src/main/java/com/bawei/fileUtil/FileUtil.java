package com.bawei.fileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
		
		//�����ļ�����ȡ��չ��
		public static String getExtName(String fileName) {
			//������쳣
			
			if(fileName==null||"".equals(fileName)) {
				throw new RuntimeException("�ļ�������Ϊ��");
			}
			
			if(fileName.indexOf(".")<=-1) {
				throw new RuntimeException(fileName+":���ļ���û�а�����չ��");
			}
			
			
			String extName=fileName.substring(fileName.lastIndexOf("."));
			
			return extName;
		}
		
		
		//��ȡϵͳ��ǰ�û�Ŀ¼
		public static String getSystemUserHome() {
			return System.getProperty("user.home");
		}
		
		//��ȡ�ļ�����
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
		
		
		//���ж�ȡ�ļ����ݵ�List����
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
		
		
		//�ݹ�ɾ���ļ�
		
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
		
		
		//��ȡ�ļ���С�����ļ���ָ����λ��С
		
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
