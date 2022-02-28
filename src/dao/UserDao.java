package dao;

import model.User;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException{
        List<User> users = new ArrayList<User>();
        
        Connection con = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM USER";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        while(rs.next()) {
            User user = new User();
            
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setFavorite(rs.getString("favorite"));
            user.setAbout(rs.getString("about"));
            
            users.add(user);
        }
        
        con.close();
        
        return users;
    }
    
    public User getUserById(int id) throws SQLException {
        Connection con = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM USER WHERE id = ?";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setInt(1, id);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        User user = new User();
        
        while(rs.next()) {
            user.setName(rs.getString("name"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setFavorite(rs.getString("favorite"));
            user.setAbout(rs.getString("about")); 
        }
        
        con.close();
        
        return user;
    }
    
    public int addUser(User user) throws ClassNotFoundException, SQLException{        
        Connection con = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO USER(name, phoneNumber, userName, password, role, favorite, about)"
                    + "values(?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPhoneNumber());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setString(6, user.getFavorite());
        preparedStatement.setString(7, user.getAbout());
        
        int rs = preparedStatement.executeUpdate();
        
        con.close();
        
        return rs;
    }
    
    public int deleteUser(int id) throws SQLException {
        Connection con = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM USER WHERE id = ?";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setInt(1, id);
        
        int rs = preparedStatement.executeUpdate();
        
        con.close();
        
        return rs;
    }
    
    public int updateUser(User user) throws SQLException {
        Connection con = JDBCConnection.getJDBCConnection();
        
        String sql = "UPDATE user "
                + "SET name=?, phoneNumber=?, userName=?, password=?, role=?, favorite=?, about=? "
                + "WHERE id=?";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPhoneNumber());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setString(6, user.getFavorite());
        preparedStatement.setString(7, user.getAbout());
        preparedStatement.setInt(8, user.getId());
        
        int rs = preparedStatement.executeUpdate();
        
        con.close();
        
        return rs;
    }
}
