/**
 * 用于测试类的构造代码块和构造函数的区别。
 *
 * /
class Person{
	
	private String name;
	
	Person(){
		System.out.println("A:wucanshu");
	}
	Person(String name){
		this.name = name;
		System.out.println("B:youcanshu");
	}
	/*构造代码块，优先于构造函数的执行。用于对所有的类的对象进行初始化，而构造函数是对类的相应的对象进行初始化。*/
	{
		System.out.println("Person class runnig.");
	}
}

public class PersonDemo{
	
	public static void main(String[] args){
		
		Person p1 = new Person();
		Person p2 = new Person("lisi");

	}
}
