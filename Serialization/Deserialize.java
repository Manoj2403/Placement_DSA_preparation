package Serialization;

import java.io.*;

public class Deserialize {
    public static void main(String[] args) {
        A copy=null;
        String filename = "Sample";
		try{
		    FileInputStream fis = new FileInputStream(filename);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    copy = (A)ois.readObject();
		}
		catch(Exception e){
		    System.out.println(e.getMessage());
		}
		System.out.println(copy);
    }
}

/*
    --Compile like below on inside the Serialization folder--
 * javac A.java Serialize.java Deserialize.java
 * --Run the Folder like below inside the Test Folder--
 * java Serialization.Serialize
 * java Serialization.Deserialize
 */