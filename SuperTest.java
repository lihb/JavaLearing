/**
 * ClassName:     SuperTest
 * description:  测试super()方法
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
        super(20); //�������й��췽��ʱ��Ĭ�Ϲ��췽����ʧ�����������ʾ���ø���Ĺ��췽��
        System.out.println("radius:"+ 20);  
    }

}
