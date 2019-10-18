package constomerClass;

import java.time.LocalDate;

/*
 * ����������а��������࣬Employee��ʹ���public�������η���Example�ࡣ
 * Example�������main������
 * Դ�ļ�����Example.java��������ΪԴ�ļ��������public���������ƥ�䡣
 * ��һ��Դ�ļ���ֻ����һ�������࣬��������������Ŀ�ķǹ����ࡣ
 * 
 */

public class Example {
	public static void main(String[] args) {
		Employee[] staff=new Employee[2];//����Employee���飬������������Ա����
		staff[0]=new Employee("Jack",2000,1999,9,20);
		staff[1]=new Employee("Rose",4000,1997,9,21);
		for(Employee e:staff) {//����Employee���raiseSalary������ÿ����Ա��нˮ���5%
			e.raiseSalary(5);
		}
		for(Employee e:staff) {//������������ķ�������ÿ����Ա����Ϣ��ӡ����
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		}		
	}

}

class Employee{
	//ʵ����
	private String name;
	private double salary;
	private LocalDate hireDay;
	//�ؼ���privateȷ��ֻ��Employee������ķ����ܹ�������Щʵ���򣬶�������ķ������ܹ���д��Щ��
	
	public Employee(String n,double s,int year,int month,int day) {//������
		name=n;
		salary=s;
		hireDay=LocalDate.of(year,month,day);
		/*
		 * ����������ͬ��
		 * �ڹ���Employee��Ķ���ʱ�������������У��Ա㽫ʵ�����ʼ��Ϊ����Ҫ��״̬
		 * ÿ���������һ�����Ϲ�����
		 * ������������1����0����������
		 * ������û�з���ֵ
		 * �������ܰ�����new����һ�����
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
