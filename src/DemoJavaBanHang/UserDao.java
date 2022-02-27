package DemoJavaBanHang;

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
        return users;
    }
}
