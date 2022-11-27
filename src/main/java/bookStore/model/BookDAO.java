package bookStore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookDAO {
	
	private DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BookDAO(DataSource dataSource) {
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
	
	public List<Books> getBookList(){
		List<Books> bookList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from Books;");
			
			while (rs.next()) {
				bookList.add(new Books(
						rs.getInt("id"),
						rs.getString("author"), 
						rs.getString("title"),
						rs.getString("genre"),
						rs.getDouble("price")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return bookList;
		
	}

	
	public Books getBook(int id){
		Books book = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from Books where id ='"+id+"';");
			
			while (rs.next()) {
				book = new Books(
						rs.getInt("id"),
						rs.getString("author"), 
						rs.getString("title"),
						rs.getString("genre"),
						rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return book;
		
	}
	
	
	public int createBook(Books book) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"INSERT INTO `Books` "
					+ "(`author`, `genre`, `title`, `price`)"
					+ " VALUES (?,?,?,?);"
					);
			
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getGenre());
			pstmt.setString(3, book.getTitle());
			pstmt.setDouble(4, book.getPrice());
			
			rowEffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
		
	}
	
	
	
	public int updateBook(Books book) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"UPDATE `Books` SET "
					+"`author` = ?,"
					+"`genre` = ?,"
					+"`title` = ?, "
					+"`price` = ? WHERE (`id` = ?);"
					
					);
			
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getGenre());
			pstmt.setString(3, book.getTitle());
			pstmt.setDouble(4, book.getPrice());
			pstmt.setInt(5,book.getId());
			
			rowEffected = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	
	
    public int deleteBook(int id) {
    	
    	int rowEffected = 0;
		
			try {
				connection = dataSource.getConnection();
				pstmt = connection.prepareStatement("delete from Books where id = ?;");
				pstmt.setInt(1,id);
				
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
