package com.Vediolearn;

import java.io.*;

//IO练习  File类运用
public class IoPratice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.获取某一个文件的信息
/*		File file=new File("e:\\TankRecord.txt");
		if(file.exists()){
		System.out.println("文件路径："+file.getAbsolutePath());
		System.out.println("文件字节"+file.length());
		}else{
			System.out.println("no");
	}*/	
		
		//2.创建文件以及文件夹
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
		
		//3.读取某一个文件的信息
/*		File file3=new File("e:\\EnemyTank.txt");
		FileInputStream fin=null;
		try {
			fin=new FileInputStream(file3);
			//使用字节数组进行缓存
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
		//4.字节输出流
/*		File file4=new File("e://a.txt");
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file4);
			String word="人们\r\n";
			String words="江嘉鸿Tersa";
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
		//图片的copy
		//思路1.先读入内存    2.再写入文件中
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
		//字符文件的复制
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
		//缓冲字符流的使用,直接操作String
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			FileReader fr=new FileReader("e://a.txt");
			FileWriter fe=new FileWriter("e://江Teresa.txt");
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
