package com.hw1.model.vo.Employee;

public class Employee {

	private int pNo; // 사원번호
	private String pName; // 사원명
	private String dept; // 사원 부서
	private String job; // 직급
	private int salary; // 급여
	
	public Employee() {}
	
	public Employee(int pNo, String pName, String dept,
					String job, int salary) {
		this.pNo = pNo;
		this.pName = pName;
		this.dept = dept;
		this.job = job;
		this.salary = salary;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
