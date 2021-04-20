package DAO;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/ordermanagement?serverTimezone=UTC";
    private static final String user= "root";
    private static final String password= "Stadioncfr2509";

    private static ConnectionFactory singleinstance=new ConnectionFactory();

    public ConnectionFactory()  {
        try {
            Class.forName(driver);
            //System.out.println("Connection successful" + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection()
    {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,user, password);
            //System.out.println("Connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static Connection getConnection()
    {
       return singleinstance.createConnection();
    }

    public static void close(Connection connection)
    {
        if (connection!=null)
        {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement statement)
    {
        if (statement!=null)
        {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultset)
    {
        if (resultset!=null)
    {
        try {
            resultset.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

}









