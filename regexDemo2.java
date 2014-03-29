import java.util.regex.*;
import java.io.*;
import java.util.*;

public class regexDemo2{
	
	public static void main(String[] args){
		/*需求就是利用正则表达式将下面字符串，进行按网段大小排序。
		 *方法：4步
		 *1.先将所有网段补足成至少三位数字；（00192.00158.0003.00134 00123.0045.0067 002.002.002.002 0010.0034.0023.0005）
		 *2.然后去除多于3位数字的前面0，意即将00192还原成192
		 *3.利用treeset集合进行比较
		 *4.还原成原始数据，进行结果输出
		 */
		String str ="192.158.03.134 123.45.67 2.2.2.2 10.34.23.05";

		str = str.replaceAll("(\\d+)","00$1");
		System.out.println(str);

		str = str.replaceAll("0+(\\d{3})","$1");
		System.out.println(str);

		TreeSet<String> ts = new TreeSet<String>();
		String[] arr = str.split(" ");

		for(int i = 0;i < arr.length;i++){
			ts.add(arr[i]);
		}

		Iterator it = ts.iterator();
		while(it.hasNext()){
			String s = (String)it.next();
			s = s.replaceAll("0+(\\d+)","$1");
			System.out.println(s);

		}

	}
}
