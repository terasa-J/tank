package com.Vediolearn;

import java.util.ArrayList;
import java.util.Scanner;
/**ArrayList���ʹ��
 * (Ҫ����Ա���Ĺ��������������,����Ա������߹��ʸ�ƽ������)
 **/
public class Demo6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpManage manage=new EmpManage();
		Scanner reader=new Scanner(System.in);
		while(true){
		System.out.println("��Ա���Ĺ�������1��������Ա��������2����ʾԱ����Ϣ������3���޸�Ա���Ĺ��ʣ�����4��ɾ��Ա��;����5���˳�"+"\n"+"��������Ӧ������:");
		int num=reader.nextInt();
		if(num==1){
			System.out.println("����Ա���ı��");
			String empNo=reader.next();
			
			System.out.println("����Ա��������");
			String empName=reader.next();
			
			System.out.println("����Ա���Ĺ���");
			String empSal=reader.next();
			Emp emp=new Emp(empNo,empName,empSal);
			manage.addEmp(emp);
			System.out.println("����ɹ�");
		}
		else if(num==2){
			System.out.println("����Ա�����");
			String empNo=reader.next();
			manage.showIo(empNo);
		}
		else if(num==3){
			System.out.println("����Ա������Լ�Ҫ�����Ĺ��ʣ�");
			String empNo=reader.next();
			String empSal=reader.next();
			manage.updateSal(empNo, empSal);
		}
		else if(num==4){
			System.out.println("����Ա�����");
			String empNo=reader.next();
			manage.deleteEmp(empNo);
		}
		else{
			System.out.println("�˳�����");
			System.exit(0);
		}
			
		}
	}
}
class EmpManage{
	ArrayList al=null;
	public EmpManage(){
		al=new ArrayList();
	}
	//������Ա��
	public void addEmp(Emp emp){
		al.add(emp);
	}
	//��ʾԱ����Ϣ
	public void showIo(String empNo){
		for(int i=0;i<al.size();i++){
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
				System.out.println("��Ա��������:"+emp.getEmpName()+"\n"+"��Ա�����ʣ�"+emp.getEmpSal());
			else if(!(emp.getEmpNo().equals(empNo)))
				System.out.println("��Ա��������.");
		}
	}
	//�޸�Ա���Ĺ���
	public void updateSal(String empNo,String empSal){
		for(int i=0;i<al.size();i++){
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
				emp.setEmpSal(empSal);
		}
	}
	//ɾ��Ա��
	public void deleteEmp(String empNo){
		for(int i=0;i<al.size();i++){
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
				al.remove(emp);
		}
	}
}
class Emp{
	private String empNo;
	private String empName;
	private String empSal;
	public Emp(String empNo,String empName,String empSal){
		this.empNo=empNo;
		this.empName=empName;
		this.empSal=empSal;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSal() {
		return empSal;
	}
	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}
}