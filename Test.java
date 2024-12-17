interface Engine{
    public void start();
}
class PetrolEngine implements Engine{
    public void start(){
        System.out.println("Petrol Engine Started...");
    }
}
class DieselEngine implements Engine{
    public void start(){
        System.out.println("Diesel Engine Started...");
    }
}
class Car{
    Engine e;
    Car(Engine e){
        this.e = e;
    }
    void move(){
        e.start();
        System.out.println("Car is Moving");
    }
}
class EngineFactory{
    public static Engine getEngine(String type){
        if(type.equals("diesel")){
            return new DieselEngine();
        }
        if(type.equals("petrol")){
            return new PetrolEngine();
        }
        return null;
    }
}
public class Test{
    public static void main(String[] args){
        Engine e = EngineFactory.getEngine("petrol");
        new Car(e).move();
    }
}