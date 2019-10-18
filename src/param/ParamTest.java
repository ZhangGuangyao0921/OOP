package param;
/*
 * Java设计语言总是按值调用的。
 * 也就是说方法得到的是所有参数的一个拷贝，方法不能修改任何传递给他的任何参数变量的内容。
 * 也就是说方法得到的是所有参数的一个拷贝，方法不能
 */

public class ParamTest {
	public static void main(String[] args) {
		System.out.println("\n tripletValue");
		double percent=10;
		System.out.println("Before percent="+percent);
		tripleValue(percent);
		System.out.println("After percent="+percent);
		
		System.out.println("\n tripleSalary");
		Employee harry=new Employee("Jack",5000);
		System.out.println("Before salary="+harry.getSalary());
		tripSalary(harry);
		System.out.println("After salary="+harry.getSalary());
		
		System.out.println("\n Swap");
		Employee a=new Employee("a",5000);
		Employee b=new Employee("b",10000);
		System.out.println("Before a="+a.getName());
		System.out.println("Before b="+b.getName());
		swap(a,b);
		System.out.println("After a="+a.getName());
		System.out.println("After b="+b.getName());
		
	}
	public static void tripleValue(double x) {
		x=x*3;
		System.out.println("x="+x);
	}
	public static void tripSalary(Employee x) {
		x.raiseSalary(200);
		System.out.println("salary="+x.getSalary());
	}
	public static void swap(Employee x,Employee y) {
		Employee temp=x;
		x=y;
		y=temp;
		System.out.println("x="+x.getName());
		System.out.println("y="+y.getName());
	}

}

class Employee{
	private String name;
	private double salary;
	
	public Employee(String n,double s) {
		name=n;
		salary=s;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary=salary+raise;
	}
}
