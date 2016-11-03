/**
 * 坦克游戏之画坦克
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
		//做成菜单
		jmb=new JMenuBar();
		jm01=new JMenu("游戏(G)");
		jm01.setMnemonic('G');
		jmi01=new JMenuItem("开始游戏(N)");
		jmi01.setMnemonic('N');
		jmi01.addActionListener(this);
		jmi01.setActionCommand("StartGame");
		
		jmi02=new JMenuItem("退出游戏(E)");
		jmi02.setMnemonic('E');
		jmi02.addActionListener(this);
		jmi02.setActionCommand("Exit");
		
		jmi03=new JMenuItem("存盘退出游戏（S）");
		jmi03.setMnemonic('S');
		jmi03.addActionListener(this);
		jmi03.setActionCommand("Save");
		
		jmi04=new JMenuItem("继续上局游戏（c）");
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
			//添加线程
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
			//存盘退出
			Recorder.setEts(panel.ets);
			Recorder.keepRecording();
			Recorder.keepEnemyRecord();
			System.exit(0);
		}else if(e.getActionCommand().equals("ConGame")){
			//继续上局游戏
			panel=new MyPanel("con");
			//添加线程
			Thread t=new Thread(panel);
			t.start(); 	
			remove(msp);
			add(panel);
			addKeyListener(panel);
			setVisible(true);
		}
		
	}
}
//提示信息的面板
class MyStartPanel extends JPanel implements Runnable{
	//定义开关    制作闪动的效果
	int times;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 500,400);
		//字体闪烁
		if(times%2==0){		
			g.setColor(Color.white);
			g.setFont(new Font("宋体",Font.BOLD,30));
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
		//记得重画
		this.repaint();
		}
	}
}
//我的面板     添加线程
class MyPanel extends JPanel implements KeyListener,Runnable{
	
	//我的坦克
	Hero hero=null;
	//敌人坦克 &控制敌人数量
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	int etsSize=5;
	//炸弹效果图,3张图片组成一个炸弹，也要用集合
	Image image1=null;
	Image image2=null;
	Image image3=null;
	Vector<Bomb> bomb=new Vector<Bomb>();
	//用于继续上局
	Vector<Node> nodes=new Vector<Node>();
	
	public MyPanel(String flag){
		//总成绩提示
		Recorder.getRecording();
		//初始化我的坦克
		hero=new Hero(200,350);	
		//初始化敌人坦克
		if(flag.equals("newGame")){
			for(int i=0;i<etsSize;i++){
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setDirect(2);
				//启动线程  坦克
				Thread t=new Thread(et);
				t.start();
				//创建敌人子弹
				Shot s=new Shot(et.x,et.y,2);
				et.ss.add(s);	
				Thread t2=new Thread(s);
				t2.start();
				//防止重叠坦克之间
				et.setEts(ets);
				ets.add(et);
			}
		}
		//用于继续上局游戏
		else if(flag.equals("con")){
			nodes=Recorder.getNodesAndEnNum();
			for(int i=0;i<nodes.size();i++){
				Node node=nodes.get(i);
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setDirect(node.direct);
				//启动线程  坦克
				Thread t=new Thread(et);
				t.start();
				//创建敌人子弹
				Shot s=new Shot(et.x,et.y,2);
				et.ss.add(s);	
				Thread t2=new Thread(s);
				t2.start();
				//防止重叠坦克之间
				et.setEts(ets);
				ets.add(et);
			}
		}
		//播放音乐
		AePlayWave ae=new AePlayWave("e://tank.wav");
		ae.start();
		//初始化炸弹
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
	//画提示信息
	public void showInfo(Graphics g){
		//画敌人坦克信息
		this.drawTank(100,420, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getEnNum()+"",130,440);
		//画自己坦克信息
		this.drawTank(160,420, g, 0, 1);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getMyLife()+"",190,440);
		//画自己成绩记录
		g.setColor(Color.black);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString("您的总成绩是:",520,50);
		this.drawTank(530,80, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"",580,100);
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
		//面板呈现黑色
		g.fillRect(0, 0, 500, 400);
		//提示信息
		this.showInfo(g);
		//画我的坦克
		if(hero.isAlive)
			this.drawTank(this.hero.getX(),this.hero.getY(),g, this.hero.getDirect(), 1);
		
		//画敌人坦克
		for(int i=0;i<ets.size();i++){
			EnemyTank et=ets.get(i);
			//判断是否被击中
			if(et.isAlive){
			this.drawTank(et.getX(),et.getY(),g,et.getDirect(),0);
			//画敌人的子弹
			for(int j=0;j<et.ss.size();j++){
				Shot enemyShot=et.ss.get(j);
				if(enemyShot.isAlive)
					g.fill3DRect(enemyShot.x,enemyShot.y,2,2,false);
				else
					et.ss.remove(j);
			}
			}
		}
		//画子弹
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
		//画炸弹
		for(int i=0;i<bomb.size();i++){
			Bomb b=bomb.get(i);
			//分不一样的时段让照片出来
			if(b.life>6)
				g.drawImage(image1, b.x, b.y,30,30,this);
			else if(b.life>3)
				g.drawImage(image2, b.x, b.y,30,30,this);
			else
				g.drawImage(image3, b.x,b.y,30,30,this);
			//减少生命值
			b.lifeDown();
			//没有生命就要移出
			if(b.life==0)
				bomb.remove(b);
		}
	}
	//敌人坦克击中我
	public void hitMe(){
		for(int k=0;k<ets.size();k++){
			EnemyTank et=ets.get(k);
		for(int i=0;i<et.ss.size();i++){
			Shot myShot=et.ss.get(i);
			//防止反复被炸
			if(hero.isAlive){			
				this.hitTank(myShot,hero);
				}
			 }
		  }
	}
	//我击中敌人
	public void hitEnemyTank(){
		for(int i=0;i<this.hero.ss.size();i++){
			Shot myShot=hero.ss.get(i);
			if(myShot.isAlive){
				//取出敌人坦克
				for(int j=0;j<ets.size();j++){
					//细节地方i j
					EnemyTank et=ets.get(j);
					if(et.isAlive){
						if(hitTank(myShot,et)){
							//显示减少 敌人数量 提示信息
							Recorder.reduceEnNum();
							//消灭多一个坦克
							Recorder.addEnNum();
						}
					}
				}
			}
		}
	}
	//子弹击中坦克
	public boolean hitTank(Shot s,Tank et){
		boolean hit=false;
		switch(et.getDirect()){
		//坦克向上或下
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30){
				//子弹死亡，敌人坦克死亡
				s.isAlive=false;
				et.isAlive=false;
				//创建一个炸弹
				Bomb b=new Bomb(et.x,et.y);
				bomb.add(b); 
				hit=true;
			}
			break;
		//坦克向左或右
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20){
				//子弹死亡，敌人坦克死亡
				s.isAlive=false;
				et.isAlive=false;
				//创建一个炸弹
				Bomb b=new Bomb(et.x,et.y);
				bomb.add(b);
				hit=true;
			}
			break;
		}
		return hit;
	}
	
	
	//专用画坦克
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		//坦克类型
		switch(type){
		case 0:g.setColor(Color.yellow);
				break;
		case 1:g.setColor(Color.cyan);
				break;
		}
		//坦克运动方向
		switch(direct){
		//向上
		case 0:
		g.fill3DRect(x, y, 5,30, false);
		g.fill3DRect(x+15, y, 5,30, false);
		g.fill3DRect(x+5,y+5,10,20,false);
		g.fillOval(x+5,y+10,10,10);
		g.drawLine(x+10,y+15, x+10, y);		
		break;
		//向右
		case 1:
		g.fill3DRect(x,y,30,5,false);
		g.fill3DRect(x,y+15,30,5,false);
		g.fill3DRect(x+5, y+5,20,10,false);
		g.fillOval(x+10,y+5,10,10);
		g.drawLine(x+15,y+10,x+30,y+10);
		break;
		//向下
		case 2:
		g.fill3DRect(x, y, 5,30, false);
		g.fill3DRect(x+15, y, 5,30, false);
		g.fill3DRect(x+5,y+5,10,20,false);
		g.fillOval(x+5,y+10,10,10);
		g.drawLine(x+10,y+15, x+10, y+30);
		break;
		//向左
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
		// 方向 ； W：上，S：下，A：左，D：右 
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
		//按下J键开始创建子弹，最多发射5颗子弹
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(this.hero.ss.size()<5){
				this.hero.ShotEnemy();
			}
		}
		//暂停与开始	
		if(e.getKeyChar()==KeyEvent.VK_SPACE  ){	
			hero.speed=0;
		//	hero.direct=hero.getDirect();
			//我的坦克的子弹不要冻
			for(int i=0;i<hero.ss.size();i++){
				Shot shot=hero.ss.get(i);
				shot.speed=0;
			}
			//敌人坦克的子弹不动
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

		//游戏开始
		if(e.getKeyChar()==KeyEvent.VK_ENTER){
			
			System.out.println("begin");
		    hero.setSpeed(1);	
			//我的坦克的子弹动起来
			for(int i=0;i<hero.ss.size();i++){
				Shot shot=hero.ss.get(i);
				shot.speed=6;
			}
			
			//敌人坦克的子弹动
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
		//重绘
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

	//子弹发射运动   用线程
	public void run() {
		while(true){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//取出我子弹 (我打敌人)
		this.hitEnemyTank();
		//取出敌人子弹（敌人打我）
		this.hitMe();
		
		this.repaint();
		}

	}
}

