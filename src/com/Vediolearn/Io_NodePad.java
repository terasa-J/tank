package com.Vediolearn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.io.*;

public class Io_NodePad extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Io_NodePad frame = new Io_NodePad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	JTextArea jta;
	public Io_NodePad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jta=new JTextArea();
		this.add(jta);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu Jm_File = new JMenu("\u6587\u4EF6");
		menuBar.add(Jm_File);
		
		JMenuItem jmiOpen = new JMenuItem("\u6253\u5F00");
		jmiOpen.setIcon(null);
		Jm_File.add(jmiOpen);
		jmiOpen.setActionCommand("Open");
		jmiOpen.addActionListener(this);
		
		JMenuItem jmiSave = new JMenuItem("\u4FDD\u5B58");
		Jm_File.add(jmiSave);
		jmiSave.setActionCommand("Save");
		jmiSave.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Open")){

			FileDialog fd=new FileDialog(this,"打开文件",FileDialog.LOAD);
			fd.setVisible(true);
			String file=fd.getDirectory()+fd.getFile();
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(new File(file));
				br=new BufferedReader(fr);
				String word="";
				String all="";
				while((word=br.readLine())!=null){
					all+=word+"\r\n";
				}
				jta.setText(all);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getActionCommand().equals("Save")){
			FileDialog fd=new FileDialog(this,"保存文件",FileDialog.SAVE);
			
			fd.setVisible(true);
			//输出流
			String file=fd.getDirectory()+fd.getFile();
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				bw.write(this.jta.getText());
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally{
				try {
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

}
