/**
 * ��Ŀ������һ��һά���飬ȥ����߷�����ͷ֣�����ƽ���ɼ���ѧϰ˼·��
 */
package com.Vediolearn;

import java.util.Scanner;

public class Demo7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Judge judge=new Judge();
		System.out.println("�������ǣ�"+judge.result());
		judge.getScore(0);
		judge.getScore(1);
	}

}
class Judge{
	private float scores[]=null;
	private int size=3;
	Scanner reader=new Scanner(System.in);
	public Judge(){
		scores=new float[size];
		for(int i=0;i<scores.length;i++){
			System.out.println("�������"+(i+1)+"�����еķ�����");
			scores[i]=reader.nextFloat();
		}
					
	}
	//�����߷�����ͷ�
	public void getScore(int i){
		if(i==1)
			System.out.println("��߷��ǣ�"+scores[getHighScore()]);
		else if(i==0)
			System.out.println("��ͷ��ǣ�"+scores[getLowScore()]);
		
	}
	//�õ���߷ֵ��±�
	public int getHighScore(){
		//ʹ��ѡ���ж�
		float high=scores[0];
		int highIndex=0;
		for(int i=1;i<scores.length;i++){
			if(high<scores[i]){
				high=scores[i];
				highIndex=i;
			}
		}
		return highIndex;
	}
	//�õ���ͷֵ��±�
	public int getLowScore(){
		//ʹ��ѡ���ж�
		float low=scores[0];
		int lowIndex=0;
		for(int i=1;i<scores.length;i++){
			if(low>scores[i]){
				low=scores[i];
				lowIndex=i;
			}
		}
		return lowIndex;
	}
	//������
	public float result(){
		float all=0;
		for(int i=0;i<scores.length;i++){
			if(i!=getLowScore()&&i!=getHighScore())
				all+=scores[i];
		}
		return all/(scores.length-2);
	}
}
