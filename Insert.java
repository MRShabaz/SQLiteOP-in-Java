
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertApp {

  
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

  
    public void insert(String name, String actor, String actress, String director, Real year) {
        String sql = "INSERT INTO warehouses(name,actor, actress, director, year) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setreal(5, year);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        app.insert("The Dark Knight ","Christian Bale","Anne Hathaway ","Christopher Nolan", 2008);
        app.insert("Inception","Leonardo DiCaprio","Elliot Page","Christopher Nolan", 2010);
        
    }

}