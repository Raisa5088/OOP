package task6.java;

public class Product {
    private int product_id;
    private String name;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String name, int quantity, double price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProduct_id() {
        try (PreparedStatement ps =
                     Dbconnection.connection.prepareStatement("SELECT product_id FROM products WHERE name  = ? and price = ? ")) {
            ps.setString(1, this.name);
            ps.setDouble(2, this.price);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Продукт " + this.name + " не сохранен в базу данных");
        return -1;
    }


    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityFromDb() {

        try (PreparedStatement ps =
                     Dbconnection.connection.prepareStatement("SELECT quantity FROM products WHERE name  = ? and price = ? ")) {
            ps.setDouble(2, this.price);
            ps.setString(1, this.name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Продукт " + this.name + " не сохранен в базу данных");
        return -1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProductById(int id) {
        try (PreparedStatement ps = Dbconnection.connection.prepareStatement("SELECT name, quantity, price FROM products WHERE product_id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            return new Product(name, quantity, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Продукт не найден");
        return null;

    }

    public void addProductInDb() {
        if (this.getProduct_id() == -1) {
            try (PreparedStatement ps = Dbconnection.connection.prepareStatement("INSERT INTO products (name, quantity, price) VALUES(?, ?, ?)")) {
                ps.setString(1, this.name);
                ps.setInt(2, this.quantity);
                ps.setDouble(3, this.price);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (PreparedStatement ps = Dbconnection.connection.prepareStatement("UPDATE products SET quantity = ? WHERE product_id = ?")) {
                ps.setInt(1, this.getQuantityFromDb() + quantity);
                ps.setInt(2, this.getProduct_id());
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addProductInDb2() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(sc.nextLine());
        sc.close();
        new Product(name, quantity, price).addProductInDb();

    }

}

