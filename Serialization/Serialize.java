package Serialization;
import java.util.*;
import java.io.*;

public class Serialize{
    public static void main(String[] args) {
        A a = new A(10,"Manoj Kumar V");
		System.out.println(a);
		String filename = "Sample";
		try{
		    FileOutputStream fos = new FileOutputStream(filename);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(a);
		    System.out.println("Object has been serialized to file: " + filename);
		}
		catch(Exception e){
		    e.printStackTrace();
		}
    }
}

/*
    --Compile like below on inside the Serialization folder--
 * javac A.java Serialize.java Deserialize.java
 * --Run the Folder like below inside the Test Folder--
 * java Serialization.Serialize
 * java Serialization.Deserialize
 */