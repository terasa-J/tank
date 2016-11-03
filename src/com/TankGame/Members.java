package com.TankGame;

import java.util.Vector;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import java.io.*;

//����̹�˽����
class Node{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
				
	}
}

//̹����
class Tank{
	//̹�˵ĳ�ʼ������
	 int x;
	//̹�˵ĳ�ʼ������
	int y;
	//����
	int direct=0;
	//�ٶ�
	int speed=1;
	//��ɫ
	int color;
	boolean isAlive=true;
	public Tank(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
//�ӵ���   �߳̿���ÿ���ӵ��ķ���
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=6;
	//�Ƿ���
	boolean isAlive=true;
	public Shot(int x,int y,int direct){
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch(direct){
			case 0:y-=speed;
			 break;
			case 1:x+=speed;
			 break;
			case 2:y+=speed;
			 break;
			case 3:x-=speed;
			 break;
			}
			if(x<0||x>500||y<0||y>400){
				isAlive=false;
				break;
			}
			//System.out.println("x="+x+"   y="+y);
		}
		
	}
}
//����̹�� �����̣߳���Ϊx��yҪ�����ı�
class EnemyTank extends Tank implements Runnable{
	//�ӵ�����
	Vector<Shot> ss=new Vector();
	//��ȡ����ϵ�̹��
	Vector<EnemyTank> ee=new Vector<EnemyTank>();
	//��̹�˴���ʱ�Լ�̹����ʧʱ��Ҫ����
	int times=0;
	//�����߳̿�ʼ
	boolean stopEnemy=false;
	
	public EnemyTank(int x, int y) {
		super(x, y);
		
	}
	//��ȡ����̹��
	public void setEts(Vector<EnemyTank> vv){
		this.ee=vv;
	}
	//�ж��Ƿ���ײ������̹��
	public boolean isTouched(){
		boolean b=false;
		//�ҵ�̹�˵ķ���
		switch(this.direct){
		//����
		case 0:
			for(int i=0;i<ee.size();i++){
				EnemyTank et=ee.get(i);
				if(et!=this){
					//���˷���  ���ϻ���
					if(et.direct==0||et.direct==2){
						//�ҵ����
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							return true;
						//�ҵ��ҵ�
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							return true;
					}
					//���˷���  �������
					if(et.direct==1||et.direct==3){
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
							return true;
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
							return true;
					}
				}			
			}
			break;
		//����
		case 1:
			for(int i=0;i<ee.size();i++){
			EnemyTank et=ee.get(i);
			if(et!=this){
				//���˷���  ���ϻ���
				if(et.direct==0||et.direct==2){
					//�ҵ��ϵ�
					if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						return true;
					//�ҵ��µ�
					if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						return true;
				}
				//���˷���  �������
				if(et.direct==1||et.direct==3){
					if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						return true;
					if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						return true;
				}
			}			
		}
			break;		
		//����
		case 2:
			for(int i=0;i<ee.size();i++){
				EnemyTank et=ee.get(i);
				if(et!=this){
					//���˷���  ���ϻ���
					if(et.direct==0||et.direct==2){
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							return true;
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
							return true;
					}
					//���˷���  �������
					if(et.direct==1||et.direct==3){
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
							return true;
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
							return true;
					}
				}
			}
			break;
		//����
		case 3:
			for(int i=0;i<ee.size();i++){
				EnemyTank et=ee.get(i);
				if(et!=this){
					//���˷���  ���ϻ���
					if(et.direct==0||et.direct==2){
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
							return true;
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
							return true;
					}
					//���˷���  �������
					if(et.direct==1||et.direct==3){
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
							return true;
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
							return true;
					}
				}		
			break;
		 }	
	   }
		return b;
	}
	//��̹�������ƶ� �� ���ڹ��ԣ������ƶ������ٽ��иı䷽�򣻲�Ҫ������Χ
	public void run() {
		while(!stopEnemy){
		switch(this.direct){
		case 0:for(int i=0;i<30;i++){
				if(y>0&& !isTouched()){
					y-=speed;
					try{
						Thread.sleep(50);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
		        }
				break;
		case 1:for(int i=0;i<30;i++){
			if(x<500&& !isTouched()){
			x+=speed;
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
        }
		 		break;
		case 2:for(int i=0;i<30;i++){
			if(y<400&& !isTouched()){
			y+=speed;
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
        }
		 		break;
		case 3:for(int i=0;i<30;i++){
			if(x>0&& !isTouched()){
			x-=speed;
			try{
				Thread.sleep(50);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
        }
		 		break;
		}
		//�����������
		this.direct=(int)(Math.random()*4);
		//�����߳�
		if(this.isAlive==false){
			break;
		}
		
		this.times++;
		//�ж��Ƿ�Ҫ��̹�˼��ӵ�
		if(times%2==0){		
			if(isAlive){
				//����5���ӵ�
				if(ss.size()<5){
				Shot s=null;
			    switch(direct){
			    case 0: //����һ���ӵ�
						s=new Shot(x+10,y,0); 
						//���һ���ӵ�
						ss.add(s);
						break;
				case 1:	s=new Shot(x+30,y+10,1);
						ss.add(s);
						break;
				case 2:	s=new Shot(x+10,y+30,2);
						ss.add(s);		
						break;
				case 3:s=new Shot(x,y+10,3);			
						ss.add(s);
						break;	
					}
				Thread t3=new Thread(s);
				t3.start();
				}
				}		
			}
		}
	}
	
	
}
//�ҵ�̹��
class Hero extends Tank{
	//�ӵ�����  ʹ�ü�����
	Vector<Shot> ss=new Vector();
	Shot s=null;
	//�ж��Ƿ���
	
	
	public Hero(int x, int y) {
		super(x, y);	
	}
	public void ShotEnemy(){
		switch(this.direct){
		case 0: //����һ���ӵ�
				s=new Shot(x+10,y,0); 
				//���һ���ӵ�
				ss.add(s);
				break;
		case 1:	s=new Shot(x+30,y+10,1);
				ss.add(s);
				break;
		case 2:	s=new Shot(x+10,y+30,2);
				ss.add(s);		
				break;
		case 3:s=new Shot(x,y+10,3);			
				ss.add(s);
				break;	
		}
		Thread t=new Thread(s);
		t.start();
		
	}
	public void moveUp(){
		if(y>0)
		  y-=speed;
	}
	public void moveDown(){
		if(y<400)
			y+=speed;
	}
	public void moveRight(){
		if(x<500)
			x+=speed;
	}
	public void moveLeft(){
		if(x>0)
		 x-=speed;
	}
	
}
//ը����
class Bomb{
	int x;
	int y;
	//һ����������
	int life=9;
	boolean isLife=true;
	public Bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	//����ֵҪ����
	public void lifeDown(){
		if(life>0){
			life--;
		}
		else{
			isLife=false;
		}
	}
}

//���ڼ�¼�Լ�����̹����Ϣ
class Recorder{
	//��¼�ж��ٸ�̹��
	private static int enNum=20;
	//��¼�Լ�����������
	private static int myLife=3;
	//��¼�Լ������˶��ٸ�̹��
	private static int allEnNum=0;
	//������
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	public static Vector<EnemyTank> ets=new Vector<EnemyTank>();
	//��¼���˻ָ��Ͼ���Ϸ
	public static Vector<Node> nodes=new Vector<Node>();
	public static Vector<Node> getNodesAndEnNum(){
		//��ȡ�����뷽��
		try {
			fr=new FileReader("E:\\EnemyTank.txt");
			br=new BufferedReader(fr);
			String line=br.readLine();
			allEnNum=Integer.parseInt(line);
			while((line=br.readLine())!=null){
				String[] xyz=line.split(" ");
				Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				nodes.add(node);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nodes;
	}
	
	
	//���̼�¼��Ϣ
	public static void keepRecording(){
		try {
			fw=new FileWriter("E:\\TankRecord.txt");
			bw=new BufferedWriter(fw);
			bw.write(allEnNum+"\r\n");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//�����˳�
	public static void keepEnemyRecord(){
		//1.��¼���˵�����
		try{
			fw=new FileWriter("E:\\EnemyTank.txt");
			bw=new BufferedWriter(fw);
			bw.write(allEnNum+"\r\n");
		//2.��¼���˵������Լ�����
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			//�������ĵ���̹��
			if(et.isAlive){
			String record=et.getX()+" "+et.getY()+" "+et.getDirect()+" ";
			bw.write(record+"\r\n");
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
			}
		finally{
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		
	}
	//��ȡ��Ϣ
	public static void getRecording(){
		try {
			fr=new FileReader("E:\\TankRecord.txt");
			br=new BufferedReader(fr);
			String line=br.readLine();
			allEnNum=Integer.parseInt(line);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static Vector<EnemyTank> getEts() {
		return ets;
	}
	public static void setEts(Vector<EnemyTank> ets) {
		Recorder.ets = ets;
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	
	public static void reduceEnNum(){
		enNum--;
	}
	public static void reduceMyLife(){
		myLife--;
	}
	public static void addEnNum(){
		allEnNum++;
	}
}
//����������
class AePlayWave extends Thread{
	private String filename;
	public AePlayWave(String wavfile){
		filename=wavfile;
	}
	public void run(){
		File soundFile=new File(filename);
		AudioInputStream audioInputStream=null;
		try{
			audioInputStream=AudioSystem.getAudioInputStream(soundFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		AudioFormat format=audioInputStream.getFormat();
		SourceDataLine auline=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		try {
			auline=(SourceDataLine)AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auline.start();
		int nBytesRead=0;
		byte[] abData=new byte[1024];
		try {
			while(nBytesRead!=-1){
			nBytesRead=audioInputStream.read(abData, 0, abData.length);
			if(nBytesRead>=0)
				auline.write(abData, 0,nBytesRead);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				auline.drain();
				auline.close();
			}
			
		
	}
}