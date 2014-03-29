class StaticCode{

	static{
		System.out.println("a");
	}
}

public class StaticCodeDemo{

	static{
		System.out.println("b");
	}

	public static void main(String[] args){
		new StaticCode();
		new StaticCode();
		System.out.println("over");
	}
	static{
		System.out.println("c");
	}

}
