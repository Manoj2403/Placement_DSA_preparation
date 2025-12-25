import java.util.*;
class Engine{
    int power;
    Engine(int power){
        this.power = power;
    }
}
class Car implements Cloneable{
    String name;
    Engine engine;
    
    Car(String name,Engine e){
        this.name = name;
        this.engine = e;
    }


    // Shallow Cloning - By default Clone() is shallow copy
    // public Object clone() throws CloneNotSupportedException{
    //     return super.clone(); //shallow clone -> new object is created but nested object references are shared.  Faster
    // }



    //Deep Cloning
    public Object clone() throws CloneNotSupportedException{
        Car copiedCar = (Car)super.clone();   
        copiedCar.engine = new Engine(this.engine.power);  //deep clone->New Object is created but nest object references are not shared.  Lazier
        return copiedCar;
    }    
    public String toString(){
        return "["+name+"  "+engine.power+"]";
    }
}
public class Main
{
	public static void main(String[] args) throws Exception {
// 		System.out.println("Hello World");
// 		Car c1 = new Car("Fortuner",35);
// 		Car c2 = c1;
// 		System.out.println(c1==c2);
// 		System.out.println("Aliasing");cls

		
		Engine e = new Engine(1000);
		Car c = new Car("Baleno",e);
		System.out.println(c);
        System.out.println(c.hashCode()+" is the HashCode for Car");
		System.out.println(c.engine.hashCode()+" is the HashCode for Car Engine");
		Car c1 = (Car)c.clone();
        System.out.println(c1.hashCode()+" is the HashCode for Car1");
		System.out.println(c1.engine.hashCode()+" is the HashCode for Car1 Engine");
		// System.out.println(c1==c);
	}
}