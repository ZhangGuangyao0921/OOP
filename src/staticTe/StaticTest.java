package staticTe;

public class StaticTest {
	public static void main(String[] args) {
		Employee[] staff=new Employee[2];//构造一个staff数组
		staff[0]=new Employee("Jack",10000);//将对象Employee放入数组中
		staff[1]=new Employee("Rose",50000);
		for(Employee e:staff) {
			e.setId();
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
		}
		int n=Employee.getNextId();
		System.out.println("Next available id="+n);
	}

}

class Employee{
	/*
	 * 如果将域定义为static，每个类中只有一个这样的域。而每一个对象对于所有的实例域却都有一份自己的拷贝。
	 * 即现在所有的Employee对象都有一个自己的id域，但这个类的所有实例将共享一个nextId域。
	 * 如果有1000个Employee类对象，则有1000个实例域id，但只有1个静态域nextId。
	 * 即使没有一个Employee对象，静态域nextId也同样存在。
	 */
	private static int nextId;
	private String name;
	private double salary;
	private int id;
	
	public Employee(String n,double s) {//构造器
		name=n;
		salary=s;
		id=0;
	}
	
	public String getName() {//域访问器
		return name;
	}
	public double getSalary() {//域访问器
		return salary;
	}
	public int getId() {//域访问器
		return id;
	}
	public int setId() {//域访问器
		return nextId;
	}
	public static int getNextId() {//静态方法不能访问id实例域，但能访问自身类中的静态域
		nextId++;
		return nextId;
	}
	
	
}