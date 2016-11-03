/**
 * ̹����Ϸ֮��̹��
 */
package com.TankGame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
public class MyTankGame extends JFrame implements ActionListener {
	MyPanel panel=null;
	MyStartPanel msp=null;
	JMenuBar jmb=null;
	JMenu jm01=null;
	JMenuItem jmi01=null;
	JMenuItem jmi02=null;
	JMenuItem jmi03=null;
	JMenuItem jmi04=null;
	public static void main(String[] args) {
		MyTankGame game=new MyTankGame();
	}
	
	public MyTankGame(){
		msp=new MyStartPanel();	
		Thread t=new Thread(msp);
		t.start();
		this.add(msp);
		//���ɲ˵�
		jmb=new JMenuBar();
		jm01=new JMenu("��Ϸ(G)");
		jm01.setMnemonic('G');
		jmi01=new JMenuItem("��ʼ��Ϸ(N)");
		jmi01.setMnemonic('N');
		jmi01.addActionListener(this);
		jmi01.setActionCommand("StartGame");
		
		jmi02=new JMenuItem("�˳���Ϸ(E)");
		jmi02.setMnemonic('E');
		jmi02.addActionListener(this);
		jmi02.setActionCommand("Exit");
		
		jmi03=new JMenuItem("�����˳���Ϸ��S��");
		jmi03.setMnemonic('S');
		jmi03.addActionListener(this);
		jmi03.setActionCommand("Save");
		
		jmi04=new JMenuItem("�����Ͼ���Ϸ��c��");
		jmi04.setMnemonic('C');
		jmi04.addActionListener(this);
		jmi04.setActionCommand("ConGame");
		
		jm01.add(jmi01);
		jm01.add(jmi02);
		jm01.add(jmi03);
		jm01.add(jmi04);
		
		jmb.add(jm01);
		this.setJMenuBar(jmb);
		
		this.setSize(700,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("StartGame")){
			panel=new MyPanel("newGame");
			//����߳�
			Thread t=new Thread(panel);
			t.start(); 	
			remove(msp);
			add(panel);
			addKeyListener(panel);
			setVisible(true);
		}else if(e.getActionCommand().equals("Exit")){
			Recorder.keepRecording();
			
			System.exit(0);
		}else if(e.getActionCommand().equals("Save")){
			//�����˳�
			Recorder.setEts(panel.ets);
			Recorder.keepRecording();
			Recorder.keepEnemyRecord();
			System.exit(0);
		}else if(e.getActionCommand().equals("ConGame")){
			//�����Ͼ���Ϸ
			panel=new MyPanel("con");
			//����߳�
			Thread t=new Thread(panel);
			t.start(); 	
			remove(msp);
			add(panel);
			addKeyListener(panel);
			setVisible(true);
		}
		
	}
}
//��ʾ��Ϣ�����
class MyStartPanel extends JPanel implements Runnable{
	//���忪��    ����������Ч��
	int times;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 500,400);
		//������˸
		if(times%2==0){		
			g.setColor(Color.white);
			g.setFont(new Font("����",Font.BOLD,30));
			g.drawString("Stage:01", 170, 200);
		}		
	}
	public void run(){
		while(true){
		try{
			Thread.sleep(700);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		times++;
		//�ǵ��ػ�
		this.repaint();
		}
	}
}
//�ҵ����     ����߳�
class MyPanel extends JPanel implements KeyListener,Runnable{
	
	//�ҵ�̹��
	Hero hero=null;
	//����̹�� &���Ƶ�������
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	int etsSize=5;
	//ը��Ч��ͼ,3��ͼƬ���һ��ը����ҲҪ�ü���
	Image image1=null;
	Image image2=null;
	Image image3=null;
	Vector<Bomb> bomb=new Vector<Bomb>();
	//���ڼ����Ͼ�
	Vector<Node> nodes=new Vector<Node>();
	
	public MyPanel(String flag){
		//�ܳɼ���ʾ
		Recorder.getRecording();
		//��ʼ���ҵ�̹��
		hero=new Hero(200,350);	
		//��ʼ������̹��
		if(flag.equals("newGame")){
			for(int i=0;i<etsSize;i++){
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setDirect(2);
				//�����߳�  ̹��
				Thread t=new Thread(et);
				t.start();
				//���������ӵ�
				Shot s=new Shot(et.x,et.y,2);
				et.ss.add(s);	
				Thread t2=new Thread(s);
				t2.start();
				//��ֹ�ص�̹��֮��
				et.setEts(ets);
				ets.add(et);
			}
		}
		//���ڼ����Ͼ���Ϸ
		else if(flag.equals("con")){
			nodes=Recorder.getNodesAndEnNum();
			for(int i=0;i<nodes.size();i++){
				Node node=nodes.get(i);
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setDirect(node.direct);
				//�����߳�  ̹��
				Thread t=new Thread(et);
				t.start();
				//���������ӵ�
				Shot s=new Shot(et.x,et.y,2);
				et.ss.add(s);	
				Thread t2=new Thread(s);
				t2.start();
				//��ֹ�ص�̹��֮��
				et.setEts(ets);
				ets.add(et);
			}
		}
		//��������
		AePlayWave ae=new AePlayWave("e://tank.wav");
		ae.start();
		//��ʼ��ը��
		try {
			image1=ImageIO.read(new File("E://java SE//Try//src//bomb_1.gif"));
			image2=ImageIO.read(new File("E://java SE//Try//src//bomb_2.gif"));
			image3=ImageIO.read(new File("E://java SE//Try//src//bomb_3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

	}
	//����ʾ��Ϣ
	public void showInfo(Graphics g){
		//������̹����Ϣ
		this.drawTank(100,420, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnNum()+"",130,440);
		//���Լ�̹����Ϣ
		this.drawTank(160,420, g, 0, 1);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"",190,440);
		//���Լ��ɼ���¼
		g.setColor(Color.black);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("�����ܳɼ���:",520,50);
		this.drawTank(530,80, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"",580,100);
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
		//�����ֺ�ɫ
		g.fillRect(0, 0, 500, 400);
		//��ʾ��Ϣ
		this.showInfo(g);
		//���ҵ�̹��
		if(hero.isAlive)
			this.drawTank(this.hero.getX(),this.hero.getY(),g, this.hero.getDirect(), 1);
		
		//������̹��
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			//�ж��Ƿ񱻻���
			if(et.isAlive){
			this.drawTank(et.getX(),et.getY(),g,et.getDirect(),0);
			//�����˵��ӵ�
			for(int j=0;j<et.ss.size();j++){
				Shot enemyShot=et.ss.get(j);
				if(enemyShot.isAlive)
					g.fill3DRect(enemyShot.x,enemyShot.y,2,2,false);
				else
					et.ss.remove(j);
			}
			}
		}
		//���ӵ�
		for(int i=0;i<this.hero.ss.size();i++){
			Shot myShot=this.hero.ss.get(i);
			if(myShot!=null&&myShot.isAlive==true){
				g.setColor(Color.RED);
				g.fill3DRect(myShot.x,myShot.y,2,2,false);
			}
			if(myShot.isAlive==false){
				this.hero.ss.remove(myShot);
			}
		}
		//��ը��
		for(int i=0;i<bomb.size();i++){
			Bomb b=bomb.get(i);
			//�ֲ�һ����ʱ������Ƭ����
			if(b.life>6)
				g.drawImage(image1, b.x, b.y,30,30,this);
			else if(b.life>3)
				g.drawImage(image2, b.x, b.y,30,30,this);
			else
				g.drawImage(image3, b.x,b.y,30,30,this);
			//��������ֵ
			b.lifeDown();
			//û��������Ҫ�Ƴ�
			if(b.life==0)
				bomb.remove(b);
		}
	}
	//����̹�˻�����
	public void hitMe(){
		for(int k=0;k<ets.size();k++){
			EnemyTank et=ets.get(k);
		for(int i=0;i<et.ss.size();i++){
			Shot myShot=et.ss.get(i);
			//��ֹ������ը
			if(hero.isAlive){			
				this.hitTank(myShot,hero);
				}
			 }
		  }
	}
	//�һ��е���
	public void hitEnemyTank(){
		for(int i=0;i<this.hero.ss.size();i++){
			Shot myShot=hero.ss.get(i);
			if(myShot.isAlive){
				//ȡ������̹��
				for(int j=0;j<ets.size();j++){
					//ϸ�ڵط�i j
					EnemyTank et=ets.get(j);
					if(et.isAlive){
						if(hitTank(myShot,et)){
							//��ʾ���� �������� ��ʾ��Ϣ
							Recorder.reduceEnNum();
							//�����һ��̹��
							Recorder.addEnNum();
						}
					}
				}
			}
		}
	}
	//�ӵ�����̹��
	public boolean hitTank(Shot s,Tank et){
		boolean hit=false;
		switch(et.getDirect()){
		//̹�����ϻ���
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30){
				//�ӵ�����������̹������
				s.isAlive=false;
				et.isAlive=false;
				//����һ��ը��
				Bomb b=new Bomb(et.x,et.y);
				bomb.add(b); 
				hit=true;
			}
			break;
		//̹���������
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20){
				//�ӵ�����������̹������
				s.isAlive=false;
				et.isAlive=false;
				//����һ��ը��
				Bomb b=new Bomb(et.x,et.y);
				bomb.add(b);
				hit=true;
			}
			break;
		}
		return hit;
	}
	
	
	//ר�û�̹��
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		//̹������
		switch(type){
		case 0:g.setColor(Color.yellow);
				break;
		case 1:g.setColor(Color.cyan);
				break;
		}
		//̹���˶�����
		switch(direct){
		//����
		case 0:
		g.fill3DRect(x, y, 5,30, false);
		g.fill3DRect(x+15, y, 5,30, false);
		g.fill3DRect(x+5,y+5,10,20,false);
		g.fillOval(x+5,y+10,10,10);
		g.drawLine(x+10,y+15, x+10, y);		
		break;
		//����
		case 1:
		g.fill3DRect(x,y,30,5,false);
		g.fill3DRect(x,y+15,30,5,false);
		g.fill3DRect(x+5, y+5,20,10,false);
		g.fillOval(x+10,y+5,10,10);
		g.drawLine(x+15,y+10,x+30,y+10);
		break;
		//����
		case 2:
		g.fill3DRect(x, y, 5,30, false);
		g.fill3DRect(x+15, y, 5,30, false);
		g.fill3DRect(x+5,y+5,10,20,false);
		g.fillOval(x+5,y+10,10,10);
		g.drawLine(x+10,y+15, x+10, y+30);
		break;
		//����
		case 3:
		g.fill3DRect(x,y,30,5,false);
		g.fill3DRect(x,y+15,30,5,false);
		g.fill3DRect(x+5, y+5,20,10,false);
		g.fillOval(x+10,y+5,10,10);
		g.drawLine(x+15,y+10,x,y+10);
		break;
		}
	}
	
	@Override	
	public void keyPressed(KeyEvent e) {
		// ���� �� W���ϣ�S���£�A����D���� 
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if(e.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		//����J����ʼ�����ӵ�����෢��5���ӵ�
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(this.hero.ss.size()<5){
				this.hero.ShotEnemy();
			}
		}
		//��ͣ�뿪ʼ	
		if(e.getKeyChar()==KeyEvent.VK_SPACE  ){	
			hero.speed=0;
		//	hero.direct=hero.getDirect();
			//�ҵ�̹�˵��ӵ���Ҫ��
			for(int i=0;i<hero.ss.size();i++){
				Shot shot=hero.ss.get(i);
				shot.speed=0;
			}
			//����̹�˵��ӵ�����
			for(int i=0;i<ets.size();i++){
				EnemyTank et=ets.get(i);
	
				et.direct=et.getDirect();
				et.speed=0;
				et.stopEnemy=true;
				for(int j=0;j<et.ss.size();j++){
					Shot shot=et.ss.get(j);			
					shot.speed=0;
					shot.direct=et.getDirect();
				}		   
			}
			
			System.out.println("stop");
		}

		//��Ϸ��ʼ
		if(e.getKeyChar()==KeyEvent.VK_ENTER){
			
			System.out.println("begin");
		    hero.setSpeed(1);	
			//�ҵ�̹�˵��ӵ�������
			for(int i=0;i<hero.ss.size();i++){
				Shot shot=hero.ss.get(i);
				shot.speed=6;
			}
			
			//����̹�˵��ӵ���
			for(int i=0;i<ets.size();i++){
				EnemyTank et=ets.get(i);
				et.stopEnemy=false;
				Thread t=new Thread(et);
				t.start();
			    
				et.direct=et.getDirect();
				et.speed=1;
				
				for(int j=0;j<et.ss.size();j++){
					Shot shot=et.ss.get(j);			
					shot.speed=6;
					shot.direct=et.getDirect();
				}		
			}
			
		}				
		//�ػ�
		this.repaint();	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	//�ӵ������˶�   ���߳�
	public void run() {
		while(true){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//ȡ�����ӵ� (�Ҵ����)
		this.hitEnemyTank();
		//ȡ�������ӵ������˴��ң�
		this.hitMe();
		
		this.repaint();
		}

	}
}

