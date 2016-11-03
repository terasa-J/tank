/**
 * 题目：定义一个一维数组，去掉最高分与最低分，计算平均成绩（学习思路）
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
		System.out.println("最后分数是："+judge.result());
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
			System.out.println("请输入第"+(i+1)+"个裁判的分数：");
			scores[i]=reader.nextFloat();
		}
					
	}
	//输出最高分与最低分
	public void getScore(int i){
		if(i==1)
			System.out.println("最高分是："+scores[getHighScore()]);
		else if(i==0)
			System.out.println("最低分是："+scores[getLowScore()]);
		
	}
	//得到最高分的下标
	public int getHighScore(){
		//使用选择法判断
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
	//得到最低分的下标
	public int getLowScore(){
		//使用选择法判断
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
	//最后分数
	public float result(){
		float all=0;
		for(int i=0;i<scores.length;i++){
			if(i!=getLowScore()&&i!=getHighScore())
				all+=scores[i];
		}
		return all/(scores.length-2);
	}
}
