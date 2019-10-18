package constructor;

import java.util.Random;
/*
 * ����ڹ�������û����ʽ�ĸ������ֵ����ô��ͻᱻ�Զ��ظ�ΪĬ��ֵ����ֵΪ0������ֵΪfalse����������Ϊnull
 * ͨ��������Ĺ������ķ��������Բ��ö�����ʽ�������ʵ����ĳ�ʼ״̬��ȷ�������������ù�������ÿ��ʵ���򶼿��Ա�����Ϊһ��������ĳ�ֵ
 * ���ڳ�ʼ���������ж���;���������г�������̵�����·�������൱���ң������ǵ��ù������ľ��岽��
 * ��1�����������������ʼ��ΪĬ��ֵ��
 * ��2����������������еĳ��ִ�������ִ�����г�ʼ���������顣
 * ��3�������������һ�е����˵ڶ�������������ִ�еڶ�����������
 * ��4��ִ����������������塣
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
	
	
	static {//��̬��ʼ����
		//��nextId����һ��С��100���������
		Random generator=new Random();
		nextId=generator.nextInt(100);
	}
	
	{//��ʼ����
		/*
		 * ���۹����������ĸ�����id�򶼽��ڶ����ʼ�����б���ʼ����
		 * �������г�ʼ���飬֮������й����������岿��
		 * ͨ���Ὣ��ʼ������ڹ�������
		 */
		id=nextId;
		nextId++;
	}
	
	public Employee(String name,double salary) {
		/*
		 * ��������ͬ�������ֽ�ʵ������������
		 * �������������Ϊsalary��salary�������������������ʵ���򣬵����Բ���this.salary����ʽ����ʵ����
		 * thisָʾ��ʽ������Ҳ����������Ķ���
		 */
		this.name=name;
		this.salary=salary;
	}
	
	public Employee(double s) {
		/*
		 * ����������ĵ�һ���������this(...)�����������������ͬһ�������һ��������
		 * �����ù�����Employee(10000),Employee(double)������������Employee(String,double)������
		 * �������ַ�ʽʹ��this�ؼ��ַǳ����ã���Ҳ�Թ����Ĺ��������벿��ֻ����һ�μ���
		 */
		this("Employee#"+nextId,s);
	}
	
	public Employee() {//�޲ι�����
		/*
		 * ����ڱ�дһ����ʱû�б�д����������ôϵͳ�ͻ��ṩһ���޲ι�������
		 * ��������������е�ʵ��������ΪĬ��ֵ��
		 * ���һ�����������ṩ��һ������������û���ṩ�޲��������������ڹ������ʱ���û���ṩ�����ͻᱻ��Ϊ���Ϸ�
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
