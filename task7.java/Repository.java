package task7.java;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
    void UpdateUser(User user,Fields field, String param);
    void delUser(User user);
}
    

