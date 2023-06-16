package task6.java;

public class Client {
    private int client_id;
    private String name;
    private String phone;

    public Client() {
    }

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getClient_id() {
        try (PreparedStatement ps =
                     Dbconnection.connection.prepareStatement("SELECT client_id FROM clients WHERE name  = ? and phone = ? ")) {
            ps.setString(1, this.name);
            ps.setString(2, this.phone);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Клент " + this.name + " не сохранен в базу данных");
        return -1;

    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client getClientById(int id) {
        try (PreparedStatement ps = Dbconnection.connection.prepareStatement("SELECT name, phone FROM clients WHERE client_id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("name");
            String phone = rs.getString("phone");

            return new Client(name, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Клиент не найден");
        return null;
    }

    public void addClientInDb() {
        if (this.getClient_id() == -1) {
            try (PreparedStatement ps = Dbconnection.connection.prepareStatement("INSERT INTO Clients (name, phone) VALUES(?, ?)")) {
                ps.setString(1, this.name);
                ps.setString(2, this.phone);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addClientInDb2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client name: ");
        String name = sc.nextLine();
        System.out.print("Enter Client phone: ");
        String phone = sc.nextLine();
        sc.close();
        new Client(name, phone).addClientInDb();

    }

}


}
