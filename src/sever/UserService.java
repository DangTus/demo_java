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
    
    public User getUserById(int id) throws SQLException {
        return userDao.getUserById(id);
    }
    
    public int addUser(User user) throws ClassNotFoundException, SQLException{
        return userDao.addUser(user);
    }
    
    public int deleteUser(int id) throws SQLException {
        return userDao.deleteUser(id);
    }
    
    public int updateUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }
}
