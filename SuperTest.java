/**
 * ClassName:     SuperTest
 * description:  娴嬭瘯super()鏂规硶
 * Author:        lhb
 * Date:         2014-04-26 23:06:21
 * Version:		 1.0
 *
 */
 
public class  SuperTest {
    public static void main(String[] args){
        FootBall fb = new FootBall();
    } 	
} 

class Ball{
    public Ball(int radius){}
}

class FootBall extends Ball{
    
    public FootBall(){
        super(20); //当父类有构造方法时，默认构造方法消失，子类必须显示调用父类的构造方法
        System.out.println("radius:"+ 20);  
    }

}
