package task6.java;

public class Dbconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ordersdb";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    static Connection connection;

    public Dbconnection (){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

