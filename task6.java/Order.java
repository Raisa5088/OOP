package task6.java;

public class Order {
    private int order_id;
    private Client client;
    private Product product;
    private int quantity;

    public Order() {
    }

    public Order(Client client, Product product, int quantity) {

        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        if (order_id == 0) {
            System.out.println("Этот заказ не сохранен в базу данных");
            return -1;
        } else return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void updateProductsDB(int product_id, int quantity) {
        try (PreparedStatement ps = Dbconnection.connection.prepareStatement("UPDATE products SET quantity = ? WHERE product_id = ? ")) {
            ps.setInt(1, this.product.getQuantityFromDb() - quantity);
            ps.setInt(2, product_id);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkQuantity(Product product) {
        int dbQuantity = product.getQuantityFromDb();
        if (dbQuantity < this.quantity) {
            System.out.println("Недостаточно товара " + "(Остаток: " + dbQuantity + "шт.)");
            return false;
        } else return true;
    }

    public void addOrderInDb() {
        if (checkQuantity(this.product) == true) {
            try (PreparedStatement ps = Dbconnection.connection.prepareStatement("INSERT INTO orders (client_id, product_id, quantity) VALUES(?, ?, ?)")) {
                ps.setInt(1, this.client.getClient_id());
                ps.setInt(2, this.product.getProduct_id());
                ps.setInt(3, this.quantity);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
                updateProductsDB(this.product.getProduct_id(), this.quantity);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("Заказ не оформлен");
    }

    public static void addOrderinDb2() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter client id: ");
        int c_id = Integer.parseInt(scan.nextLine());

        System.out.print("Enter product id: ");
        int p_id = Integer.parseInt(scan.nextLine());

        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(scan.nextLine());
        scan.close();

        Client client = new Client().getClientById(c_id);
        Product product = new Product().getProductById(p_id);

        new Order(client, product, quantity).addOrderInDb();
    }
}

