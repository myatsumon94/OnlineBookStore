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

public class AdminDAO {

    private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AdminDAO(DataSource dataSource) {
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
	
	public Admin getAdminByEmail(String email) {
		Admin admin = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from admin where email = '" + email +"';");
			
			while (rs.next()) {
				admin = new Admin(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return admin;
	}
	
	
//	public boolean isValidAdmin(String email,String originalPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
//		Admin admin = getAdminByEmail(email);
//		boolean valid = false;
//		
//		if(admin != null) {
//			String storedPassword = admin.getPassword();
//			valid = PasswordValidator.validatePassword(originalPassword, storedPassword);
//			
//		}
//		return valid;
//	}
//	
public int createAdmin(Admin admin){
		
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pstmt = connection.prepareStatement(					
					"INSERT INTO `admin`"+
					"(`name`, `email`, `password`) "+
					"VALUES ( ? , ? , ? );"						
					);
			
			pstmt.setString(1,admin.getName());
			pstmt.setString(2,admin.getEmail());
//
//			String securedPassword = null;
//			try {
//				securedPassword = PasswordEncoder.encode(admin.getPassword());
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			} catch (InvalidKeySpecException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			pstmt.setString(3,admin.getPassword());
			
			
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
