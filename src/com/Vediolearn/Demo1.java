package com.Vediolearn;

import java.util.Scanner;

/**
�����ŶӸ�������Լ����
 */
public class Demo1 {
	public static void main(String[] args){
		int size=5;
		Panda[] panda =new Panda[size];
		Scanner reader=new Scanner(System.in);
		for(int i=0;i<panda.length;i++){
			panda[i]=new Panda(reader.nextFloat(),(i+1)+"");
		}
		//�Ϻ�������
		Panda old=new Panda(1.5f,"250");
		//ð��
		//old.sort(panda);
		//ѡ��
		old.sortChoose(panda);
		//����
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
	//ѡ������
	public void sortChoose(Panda[] panda){
		float tempHeight;
		String tempNo;
		for(int i=0;i<panda.length-1;i++){
			//�����һ������С
			float minHeight=panda[i].height;
			int  minNo=i;
			for(int j=i+1;j<panda.length;j++){
				if(minHeight>panda[j].height){
					minHeight=panda[j].height;
					minNo=j;
				}
			}
			//����
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
	//ð���ź�
	public void sort(Panda[] panda){
		float tempHeight;
		String tempNo;
		//ѭ������
		for(int i=0;i<panda.length-1;i++){
			//ÿ�εıȽ�
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
	//��������
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
			//����
			panda[index+1].height=height;
			panda[index+1].no=no;
			
		}
	}
	//չʾ
	public void show(Panda[] panda){
		for(int i=0;i<panda.length;i++){
			System.out.println("��è�ı�ţ�"+panda[i].no+"  ��è�����:"+panda[i].height);
		}
		
	}
}