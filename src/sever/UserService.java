package sever;

import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        return userDao.getAllUsers();
    }
    
    public int addUser(User user) throws ClassNotFoundException, SQLException{
        return userDao.addUsers(user);
    }
}
