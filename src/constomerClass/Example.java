package constomerClass;

import java.time.LocalDate;

/*
 * 在这个例子中包含两个类，Employee类和带有public访问修饰符的Example类。
 * Example类包含了main方法。
 * 源文件名是Example.java，这是因为源文件名必须和public类的名字相匹配。
 * 在一个源文件中只能有一个公有类，但可以有任意数目的非公有类。
 * 
 */

public class Example {
	public static void main(String[] args) {
		Employee[] staff=new Employee[2];//构造Employee数组，并填入两个雇员对象
		staff[0]=new Employee("Jack",2000,1999,9,20);
		staff[1]=new Employee("Rose",4000,1997,9,21);
		for(Employee e:staff) {//利用Employee类的raiseSalary方法将每个雇员的薪水提高5%
			e.raiseSalary(5);
		}
		for(Employee e:staff) {//调用域访问器的方法，将每个雇员的信息打印出来
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		}		
	}

}

class Employee{
	//实例域
	private String name;
	private double salary;
	private LocalDate hireDay;
	//关键字private确保只有Employee类自身的方法能够访问这些实例域，而其他类的方法不能够读写这些域
	
	public Employee(String n,double s,int year,int month,int day) {//构造器
		name=n;
		salary=s;
		hireDay=LocalDate.of(year,month,day);
		/*
		 * 构造器和类同名
		 * 在构造Employee类的对象时，构造器会运行，以便将实例域初始化为所需要的状态
		 * 每个类可以有一个以上构造器
		 * 构造器可以有1个、0个或多个参数
		 * 构造器没有返回值
		 * 构造器总伴随着new操作一起调用
		 */
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public LocalDate getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary=salary+raise;
	}
}
