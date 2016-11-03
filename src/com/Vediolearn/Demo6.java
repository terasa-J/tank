package com.Vediolearn;

import java.util.ArrayList;
import java.util.Scanner;
/**ArrayList类的使用
 * (要补充员工的工资排序这个条件,计算员工的最高工资跟平均工资)
 **/
public class Demo6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpManage manage=new EmpManage();
		Scanner reader=new Scanner(System.in);
		while(true){
		System.out.println("对员工的管理：输入1：加入新员工；输入2：显示员工信息；输入3：修改员工的工资；输入4：删除员工;输入5：退出"+"\n"+"请输入相应的数字:");
		int num=reader.nextInt();
		if(num==1){
			System.out.println("输入员工的编号");
			String empNo=reader.next();
			
			System.out.println("输入员工的姓名");
			String empName=reader.next();
			
			System.out.println("输入员工的工资");
			String empSal=reader.next();
			Emp emp=new Emp(empNo,empName,empSal);
			manage.addEmp(emp);
			System.out.println("加入成功");
		}
		else if(num==2){
			System.out.println("输入员工编号");
			String empNo=reader.next();
			manage.showIo(empNo);
		}
		else if(num==3){
			System.out.println("输入员工编号以及要改正的工资：");
			String empNo=reader.next();
			String empSal=reader.next();
			manage.updateSal(empNo, empSal);
		}
		else if(num==4){
			System.out.println("输入员工编号");
			String empNo=reader.next();
			manage.deleteEmp(empNo);
		}
		else{
			System.out.println("退出管理");
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
	//加入新员工
	public void addEmp(Emp emp){
		al.add(emp);
	}
	//显示员工信息
	public void showIo(String empNo){
		for(int i=0;i<al.size();i++){
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
				System.out.println("该员工的姓名:"+emp.getEmpName()+"\n"+"该员工工资："+emp.getEmpSal());
			else if(!(emp.getEmpNo().equals(empNo)))
				System.out.println("该员工不存在.");
		}
	}
	//修改员工的工资
	public void updateSal(String empNo,String empSal){
		for(int i=0;i<al.size();i++){
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
				emp.setEmpSal(empSal);
		}
	}
	//删除员工
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