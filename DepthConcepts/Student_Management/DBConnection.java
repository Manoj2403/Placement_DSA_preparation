import java.io.*;
import java.sql.*;
import java.util.Properties;
public class DBConnection {

    public static Connection getConnection(){
        try{
            Properties properties = new Properties();
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPwd = properties.getProperty("db.password");
            String dbDriver = properties.getProperty("db.driver");
            Class.forName(dbDriver);
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            System.out.println("-----------------"+dbDriver+"-----------------------");
            return connection;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
