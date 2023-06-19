package task7.java;

public class Decorator implements Repository{
    private Repository repo;
    private LoggerTerminal logger;
    
    public Decorator(Repository repo, LoggerTerminal logger) {
        this.repo = repo;
        this.logger = logger;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> res = repo.getAllUsers();
        return res;
    }

    @Override
    public String CreateUser(User user) {
        String res = repo.CreateUser(user);
        logger.logg("Date and time of create ");
        return res;
    }

    @Override
    public void UpdateUser(User user, Fields field, String param) {
        repo.UpdateUser(user, field, param);
    }

    @Override
    public void delUser(User user) {
        repo.delUser(user);
        logger.logg("Date & time of delete: ");
    }
    

    
}

    














}
