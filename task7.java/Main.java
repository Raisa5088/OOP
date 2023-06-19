package task7.java;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("/Users/b.shapovalov/Desktop/Учеба /2_четверть /Программист/ООП/HOMEWORK/Seminar_7/users.txt");
        // Repository repository = new RepositoryFile(fileOperation);
        Repository repository = new Decorator(new RepositoryFile(fileOperation), new LoggerTerminal());
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);

        view.run();
    }
}

