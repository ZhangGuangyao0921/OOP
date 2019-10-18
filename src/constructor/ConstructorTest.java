package constructor;

import java.util.Random;
/*
 * 如果在构造器中没有显式的给域赋予初值，那么域就会被自动地赋为默认值：数值为0，布尔值为false，对象引用为null
 * 通过重载类的构造器的方法，可以采用多种形式设置类的实例域的初始状态。确保不管怎样调用构造器，每个实例域都可以被设置为一个有意义的初值
 * 由于初始化数据域有多种途径，所以列出构造过程的所有路径可能相当混乱，下面是调用构造器的具体步骤
 * （1）所有数据域均被初始化为默认值。
 * （2）按照在类的声明中的出现次序，依次执行所有初始化语句和语句块。
 * （3）如果构造器第一行调用了第二个构造器，则执行第二个构造器。
 * （4）执行这个构造器的主体。
 */

public class ConstructorTest {
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Jack",400000);
		staff[1]=new Employee(300000);
		staff[2]=new Employee();
		for(Employee e:staff) {
			System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
		}
		
	}
}

class Employee{
	private static int nextId;
	private int id;
	private String name="";
	private double salary;
	
	
	static {//静态初始化块
		//将nextId赋予一个小于100的随机整数
		Random generator=new Random();
		nextId=generator.nextInt(100);
	}
	
	{//初始化块
		/*
		 * 无论构造器构造哪个对象，id域都将在对象初始化块中被初始化。
		 * 首先运行初始化块，之后才运行构造器的主体部分
		 * 通常会将初始化块放在构造器中
		 */
		id=nextId;
		nextId++;
	}
	
	public Employee(String name,double salary) {
		/*
		 * 参数变量同样的名字将实例域隐藏起来
		 * 如果将参数命名为salary，salary将引用这个参数而不是实例域，但可以采用this.salary的形式访问实例域
		 * this指示隐式参数，也就是所构造的对象
		 */
		this.name=name;
		this.salary=salary;
	}
	
	public Employee(double s) {
		/*
		 * 如果构造器的第一个语句形如this(...)，这个构造器将调用同一个类的另一个构造器
		 * 当调用构造器Employee(10000),Employee(double)构造器将调用Employee(String,double)构造器
		 * 采用这种方式使用this关键字非常有用，这也对公共的构造器代码部分只编译一次即可
		 */
		this("Employee#"+nextId,s);
	}
	
	public Employee() {//无参构造器
		/*
		 * 如果在编写一个类时没有编写构造器，那么系统就会提供一个无参构造器。
		 * 这个构造器将所有的实例域设置为默认值。
		 * 如果一个类中至少提供了一个构造器，但没有提供无参数构造器，则在构造对象时如果没有提供参数就会被视为不合法
		 */
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public int getId() {
		return id;
	}

}
