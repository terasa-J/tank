package com.Vediolearn;

import java.util.LinkedList;

/**
LinkedList���ʹ��(���ڶ���ջ��Ӧ�ñȽϺ� )
 */
public class Demo6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList li=new LinkedList();
		Emp em0=new Emp("002","����2","200");
		Emp em1=new Emp("001","����","100");
		li.addFirst(em0);
		li.add(em1);
		
		for(int i=0;i<li.size();i++){
			System.out.println(((Emp)li.get(i)).getEmpName());
		}
		
	}

}
