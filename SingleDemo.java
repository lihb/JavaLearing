class Single{
	/*饿汉式*/
	private Single(){} //将构造函数初始化，使其他人不能实例化
	private  static Single s = new Single(); //自己创建一个对象供人使用，但是也需将其私有化。
	public static Single getInstance(){ //public:提供公共方法，让人调用。由没有生成对象，不能调用该方法，只能采用“类名.函数”的格式调用，所以要加static关键字。
		return s;
	}

	/*懒汉式*/

	/*
	private Single(){}

	private static Single s = null;
	private static Single getInstance(){
		if(s == null)
			synchronized(Single.class){
				if(s == null)
					s = new Single();
			}
		return s;
	}
	*/
//两者区别在于谁先创建对象。先创建的对象的方式属于比较饥饿，俗称“饿汉”。	
	private int x;
	public void setX(int x){
		
		this.x = x;
	}
	public int getX(){
		
		return x;
	}

}

public class SingleDemo{

	public static void main(String[] args){
	
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		s1.setX(100);
		System.out.println("s1.x="+s1.getX());
		System.out.println("s2.x="+s2.getX());
	}

}
