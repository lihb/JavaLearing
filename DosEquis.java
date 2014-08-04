/**
 *测试条件表达式
 *
 */

public class DosEquis{
	
	public static void main(String[] args){
		char x = 'x';
		int i = 0;
		System.out.print(true ? x : i); 
		System.out.println(false ? i : x); 


		System.out.println("2 + 2 = " + 2+2); 
		System.out.println("2 + 2 = " + (2+2)); 

		int[] arr = {3, 4, 55,33};

		System.out.println("hello" + arr);

		char[] numbers = {'1', '2', '3'};
		System.out.println(numbers.toString());  

		int y = 'H' + 'a';
		System.out.println(y);  

	}
	
}
