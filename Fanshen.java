/*
 *Author:   lhb
 *File:     Fanshen.java
 *Date:     14-04-02 10:53:46
 * java反射步骤
 * 1.首先获取类
 * demo = Class.forName()   ps：有异常抛出
 * 2.获取类名
 * demo.getName()
 * 3.获取类的对象
 * demo.newInstance() ps:要注意一定要在类中构造自己的无参构造方法。不然会报错
 * 4.获取类的构造方法
 * Constructor<?> cons[] = demo.getConstructors()
 * (Person)cons[0].newInstance()
 * 5.获取类实现的接口
 * Class<?> interface[] = demo.getInterface()
 * 6.获取父类
 * Class<?> father = demo.getSuperclass()
 * 7.获取其他类中的全部构造函数
 * Constructor<?> cons[] = demo.getConstructors()
 * 8.获取构造函数中的修饰符（void, string等）
class hello {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("Reflect.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + filed1[j].getName() + ";");
        }
    }
}
 *9 其实还可以通过反射调用其他类中的方法
 Method method = demo.getMethod(方法名，参数类型的字节码：如String.class, int.class)
 method.invoke(对象，参数)

class hello {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("Reflect.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            //调用Person类中的sayChina方法
            Method method=demo.getMethod("sayChina");
            method.invoke(demo.newInstance());
            //调用Person的sayHello方法
            method=demo.getMethod("sayHello", String.class,int.class);
            method.invoke(demo.newInstance(),"Rollen",20);
             
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
 *
 * /

import java.util.*;

class ReflectDemo{

}

public class Fanshen{
	public static void main(String[] args){
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try{
			demo1 = Class.forName("ReflectDemo");
		}catch(Exception e){
			e.printStackTrace();
		} 
	//	demo2 = new ReflectDemo.getClass();
		demo3 = ReflectDemo.class;
		
		System.out.println(demo1.getName());
	//	System.out.println(demo2.getName());
		System.out.println(demo3.getName());
	} 
}





/*java反射
 *
 *
 *
 *
 *
 */
