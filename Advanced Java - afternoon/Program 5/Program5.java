import java.sql.*;

public class Program5 {
    static final String url = "jdbc:mysql://localhost/Hospital_Management_System?autoReconnect=true&useSSL=false";

    static final String userName = "root";
    static final String password = "Susan@6298";
    public static void main(String []args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to Database");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connected successfully");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM Patient ORDER BY Patient_ID LIMIT 10";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                int id = rs.getInt("Patient_ID");
                String name = rs.getString("Patient_Name");

                System.out.println("Patient ID: " + id + " Patient Name: " + name);
            }

            rs.close();
            conn.close();
            stmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }
}
