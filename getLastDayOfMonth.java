import java.util.*;
/**
 *
 *需求：给定一个日期，获取这个日期的当前月的最后一天。
 *思路：将这个日期加1，如果月份改变，则这个日期是最后一天，否则，取下个月的第一天，将第一天减1。
 */

public class getLastDayOfMonth{
	
	public static void main(String[] args){
	
		Calendar c = Calendar.getInstance();
		c.set(2013,6,28);
		getLastDay(c);
	}

	public static void getLastDay(Calendar c){
		
		Calendar c2 = (Calendar)c.clone();
		c.add(Calendar.DAY_OF_MONTH,1);
		Calendar c3 = Calendar.getInstance();
		c3.set(Calendar.YEAR,c.get(Calendar.YEAR));
		c3.set(Calendar.MONTH,c.get(Calendar.MONTH)+1);
		c3.set(Calendar.DAY_OF_MONTH,1);
		System.out.println(c3.getTime());
			
		if(c.MONTH!=c2.MONTH){
			
			System.out.println("当前月的最后一天是："+c.getTime());
		}else{
			c3.add(Calendar.DATE,-1);
			System.out.println("当前月的最后一天是："+c3.getTime());
		}
	}
}


