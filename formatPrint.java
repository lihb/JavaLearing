/*用来格式化字符串输出。
 * 常见的格式化标志
 * ************************************
 * 标志       目的
 *  +       打印正数和负数的符号
 *  空格    在正数之前添加空格
 *  0       数字前面补0
 *  -       左对齐
 *  (       将负数括在括号内
 *  ,       添加分组分隔符
 *  $	    给定被格式化的参数索引。例如，%1$d,%1$x,将以十进制和十六进制格式打印第一个参数
 ****************************************
 *Author:   lhb
 *File:     formatPrint.java
 *Date:     14-03-08 21:31:59
 */

import java.util.Date;

public class formatPrint{
	public static void main(String[] args){
		double x = 10000.0 /3;	
		int y = 555;
		// 0  标志
		System.out.printf("x = %08.2f\n",x); //输出03333.33
		System.out.printf("y = %08d\n",y);   //输出00000555
		// + 标志
		System.out.printf("x = %+8.2f\n",x); //输出 +3333.33
		System.out.printf("y = %+8d\n",y);   //输出     +555
		// , 标志
		System.out.printf("x = %,8.2f\n",x); //输出 +3,333.33
		System.out.printf("y = %,8d\n",y);   //输出     +555
		
		//打印日期
		System.out.printf("%tT\n",new Date());
		System.out.printf("%1$s %2$tB %2$te ,%2$tY \n","Due date:",new Date());  




	} 
}

