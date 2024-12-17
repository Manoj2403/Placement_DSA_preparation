package Serialization;
import java.io.*;

public class A implements Serializable {
    public int a;
    public String b;
    public A(int a,String b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        return a+" "+b;
    }
}

/*
    --Compile like below on inside the Serialization folder--
 * javac A.java Serialize.java Deserialize.java
 * --Run the Folder like below inside the Test Folder--
 * java Serialization.Serialize
 * java Serialization.Deserialize
 */