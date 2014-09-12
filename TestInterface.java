interface CanFly{
    public void fly();
}

class Plane implements CanFly{
    
    public void fly(){
        System.out.println("Plane can fly");  
    }
} 
class Bird implements CanFly{
    
    public void fly(){
        System.out.println("Birds can fly");  
    }
} 

public class TestInterface{
    public static void main(String[] args){
    
        Bird bird = new Bird();

        Plane plane = new Plane();

        bird.fly();
        plane.fly();
    }
}
