package task6.java;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dbconnection dbconnection = new Dbconnection();


        Client client = new Client("Alex", "+3805465");

        Product product = new Product("Orange", 12, 20);

        Order order = new Order(client, product, 12);


        Order.addOrderinDb2();

    }
}

