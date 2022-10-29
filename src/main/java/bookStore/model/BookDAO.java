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
	private ResultSet books;

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
		List<Books> book_list = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			books = stmt.executeQuery("select * from Books;");
			
			while (books.next()) {
				book_list.add(new Books(
						books.getInt("id"),
						books.getString("author"), 
						books.getString("title"),
						books.getString("genre"),
						books.getDouble("price")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return book_list;
		
	}
	
/*	
	public Books getBook(int id){
		Books bookList = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			books = stmt.executeQuery("select * from Books where id ='"+id+"';");
			
			while (books.next()) {
				bookList = new Books(
						books.getInt("id"),
						books.getString("author"), 
						books.getString("title"),
						books.getString("genre"),
						books.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return bookList;
		
	}
	
	*/
	public int createBook(Books bookList) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"INSERT INTO `Books` "
					+ "(`author`, `genre`, `title`, `price`)"
					+ " VALUES (?,?,?,?);"
					);
			
			pstmt.setString(1, bookList.getAuthor());
			pstmt.setString(2, bookList.getGenre());
			pstmt.setString(3, bookList.getTitle());
			pstmt.setDouble(4, bookList.getPrice());
			
			rowEffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
		
	}
	
	public int updateBook(Books bookList) {
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
			
			pstmt.setString(1, bookList.getAuthor());
			pstmt.setString(2, bookList.getGenre());
			pstmt.setString(3, bookList.getTitle());
			pstmt.setDouble(4, bookList.getPrice());
			pstmt.setInt(5,bookList.getId());
			
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
