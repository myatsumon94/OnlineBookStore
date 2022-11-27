package bookStore.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import bookStore.crypto.PasswordEncoder;
import bookStore.crypto.PasswordValidator;

public class UserDAO {

	private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	

	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where email = '" + email+"';");
			
			while (rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("phoneNo"),
						rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return user;
	}
	
	public boolean isValidUser(String email,String originalPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		User user = getUserByEmail(email);
		boolean valid = false;
		
		if(user != null) {
			String storedPassword = user.getPassword();
			valid = PasswordValidator.validatePassword(originalPassword, storedPassword);
			
		}
		return valid;
	}
	
	public int createUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException{
		
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pstmt = connection.prepareStatement(
					"INSERT INTO `user`"
					+"(`name`, `email`, `address`, `phoneNo`,`password`) "
					+	"VALUES (? , ? , ? , ? , ?);"				
					);
			
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getAddress());
			pstmt.setString(4,user.getPhoneNo());
			
		//	String securedPassword = PasswordEncoder.encode(user.getPassword());
			
			pstmt.setString(5,user.getPassword());
			
			
			rowEffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
		
	} 
}
