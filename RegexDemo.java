import java.util.regex.*;


public class RegexDemo{
	
	public static void test_1(){
		
		String str = "我我...我我...我要..要要..要要...学学学....学学...编编编...编程..程.程程...程...程";
		/*
		 * 将str变成   “我要学编程”，即是删除重复汉字，删除符号 “.”。
		 * 分成两步骤：
		 * 1.将符号“.”删除，利用String类的split函数来进行切割，这里的知识点是，符号 “.”，需要双反斜杠进行转义，因为“.”在正则中是特殊字符。
		 * 2.去除重复的汉字，利用String类的replaceAll函数，叠字，需要用到分组，需要小括号括起来，然后用 \1 进行调用，替代部分应该填的参数为第一组的内容，用$1来调用。
		**/
		String regex1 = "\\.+";
		String[] arr = str.split(regex1);

		StringBuilder sb = new StringBuilder();
		for(String s:arr)
			sb.append(s);
		String str2 = sb.toString();

		System.out.println(str2);
		
		String result = str2.replaceAll("(.)\\1+","$1");
		System.out.println(result);

		//或者用两次替换操作更简单
		//str = str.replaceAll("\\.+",""); //替换符号“.”
		//str = str.replaceAll("(.)\\1+","$1");//去除叠字
		//System.out.println(str);
	}
	public static void test_2(){
		//需求：将下面url的ip地址，端口，和网站路径分别解析出来。
		String url = "http://192.168.0.100:8080/myweb/demo.html";
		
		String reg = "\\d{3}[\\d\\.]+";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(url);
		while(m.find())
			System.out.println(m.group()); 
				
		
	}
	
	public static void main(String[] args){
		
		test_1();
		test_2();
	}
}
