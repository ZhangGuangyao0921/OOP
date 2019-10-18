package staticTe;

public class StaticTest {
	public static void main(String[] args) {
		Employee[] staff=new Employee[2];//����һ��staff����
		staff[0]=new Employee("Jack",10000);//������Employee����������
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
	 * ���������Ϊstatic��ÿ������ֻ��һ���������򡣶�ÿһ������������е�ʵ����ȴ����һ���Լ��Ŀ�����
	 * ���������е�Employee������һ���Լ���id�򣬵�����������ʵ��������һ��nextId��
	 * �����1000��Employee���������1000��ʵ����id����ֻ��1����̬��nextId��
	 * ��ʹû��һ��Employee���󣬾�̬��nextIdҲͬ�����ڡ�
	 */
	private static int nextId;
	private String name;
	private double salary;
	private int id;
	
	public Employee(String n,double s) {//������
		name=n;
		salary=s;
		id=0;
	}
	
	public String getName() {//�������
		return name;
	}
	public double getSalary() {//�������
		return salary;
	}
	public int getId() {//�������
		return id;
	}
	public int setId() {//�������
		return nextId;
	}
	public static int getNextId() {//��̬�������ܷ���idʵ���򣬵��ܷ����������еľ�̬��
		nextId++;
		return nextId;
	}
	
	
}