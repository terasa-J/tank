package com.Vediolearn;

import java.io.*;

//IO��ϰ  File������
public class IoPratice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.��ȡĳһ���ļ�����Ϣ
/*		File file=new File("e:\\TankRecord.txt");
		if(file.exists()){
		System.out.println("�ļ�·����"+file.getAbsolutePath());
		System.out.println("�ļ��ֽ�"+file.length());
		}else{
			System.out.println("no");
	}*/	
		
		//2.�����ļ��Լ��ļ���
/*		File file3=new File("e:\\ff");
		if(!file3.isDirectory()){
			file3.mkdir();
			System.out.println("66");
		}
		File file2=new File("e:\\ff\\a.txt");
		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File[] files=file3.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(files[i].getName());
		}*/
		
		//3.��ȡĳһ���ļ�����Ϣ
/*		File file3=new File("e:\\EnemyTank.txt");
		FileInputStream fin=null;
		try {
			fin=new FileInputStream(file3);
			//ʹ���ֽ�������л���
			byte a[]=new byte[512];
			int n=0;
			while((n=fin.read(a))!=-1){
				String s=new String(a,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		//4.�ֽ������
/*		File file4=new File("e://a.txt");
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file4);
			String word="����\r\n";
			String words="���κ�Tersa";
			fos.write(word.getBytes());
			fos.write(words.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		//ͼƬ��copy
		//˼·1.�ȶ����ڴ�    2.��д���ļ���
/*		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("e://2.jpg");
			fos=new FileOutputStream("d://2.jpg");
			byte b[]=new byte[1024];
			int n=0;
			while((n=fis.read(b))!=-1){
				fos.write(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
*/
		//�ַ��ļ��ĸ���
/*		FileReader fr=null;
		FileWriter fw=null;
		int n=0;
		char[] c=new char[1024];
		try {
			fr=new FileReader("e:\\a.txt");
			fw=new FileWriter("e:\\bb.txt");
			while((n=fr.read(c))!=-1){
				fw.write(c,0,n);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
*/
		//�����ַ�����ʹ��,ֱ�Ӳ���String
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			FileReader fr=new FileReader("e://a.txt");
			FileWriter fe=new FileWriter("e://��Teresa.txt");
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fe);
			String word=null;
			while((word=br.readLine())!=null){
				bw.write(word+"\r\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

		
	}
}
