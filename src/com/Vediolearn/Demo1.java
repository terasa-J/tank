package com.Vediolearn;

import java.util.Scanner;

/**
猴子排队根据身高以及编号
 */
public class Demo1 {
	public static void main(String[] args){
		int size=5;
		Panda[] panda =new Panda[size];
		Scanner reader=new Scanner(System.in);
		for(int i=0;i<panda.length;i++){
			panda[i]=new Panda(reader.nextFloat(),(i+1)+"");
		}
		//老猴子排序
		Panda old=new Panda(1.5f,"250");
		//冒泡
		//old.sort(panda);
		//选择
		old.sortChoose(panda);
		//插入
		old.sortIns(panda);
		old.show(panda);
		
	}


}
class Panda{
	float height;
	String no;
	public Panda(float height,String no){
		this.height=height;
		this.no=no;
	}
	//选择排序
	public void sortChoose(Panda[] panda){
		float tempHeight;
		String tempNo;
		for(int i=0;i<panda.length-1;i++){
			//假设第一个数最小
			float minHeight=panda[i].height;
			int  minNo=i;
			for(int j=i+1;j<panda.length;j++){
				if(minHeight>panda[j].height){
					minHeight=panda[j].height;
					minNo=j;
				}
			}
			//交换
			if(minNo!=i){
				tempHeight=panda[minNo].height;
				panda[minNo].height=panda[i].height;
				panda[i].height=tempHeight;
				
				tempNo=panda[minNo].no;
				panda[minNo].no=panda[i].no;
				panda[i].no=tempNo;
			}
		}
	}
	//冒泡排号
	public void sort(Panda[] panda){
		float tempHeight;
		String tempNo;
		//循环层数
		for(int i=0;i<panda.length-1;i++){
			//每次的比较
			for(int j=0;j<panda.length-1-i;j++){
				if(panda[j].height>panda[j+1].height){
					tempHeight=panda[j].height;
					panda[j].height=panda[j+1].height;
					panda[j+1].height=tempHeight;
					
					tempNo=panda[j].no;
					panda[j].no=panda[j+1].no;
					panda[j+1].no=tempNo;
				}
			}
		}
	}
	//插入排序
	public void sortIns(Panda[] panda){
		for(int i=1;i<panda.length;i++){
			float height=panda[i].height;
			String no=panda[i].no;
			
			int index=i-1;
			while(index>=0&&panda[index].height>height){
				panda[index+1].height=panda[index].height;
				panda[index+1].no=panda[index].no;
				index--;
				
			}
			//插入
			panda[index+1].height=height;
			panda[index+1].no=no;
			
		}
	}
	//展示
	public void show(Panda[] panda){
		for(int i=0;i<panda.length;i++){
			System.out.println("熊猫的编号："+panda[i].no+"  熊猫的身高:"+panda[i].height);
		}
		
	}
}