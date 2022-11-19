package springstart.models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PrimitiveInfo {

    static Long id;
    static String message;

    public PrimitiveInfo() {
    }

    static String username = "root";
    static String password = "1111";
    static String connectionUrl = "jdbc:mysql://localhost:3306/liquibase";

    public static final String ANSI_RED = "\u001B[31m";

    public static void addObject(Long id, String message) {
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)){
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("REPLACE INTO objects(id, messaje) VALUES " +
                    "(" +
                    id
                    +", "+ "'" +
                    message
                    + "'"+ " )"
            );
        } catch (Exception ex) {
            System.out.println(ANSI_RED + "Failed to add " + ex);
        }
    }

    public static void clearTable(){
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("DELETE FROM " + "objects" + "");
        } catch (Exception ex) {
            System.out.println(ANSI_RED + "Failed to remove " + ex);
        }
    }

    public static void findById(Long id){
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            String script = "SELECT * FROM " +"objects"+ " WHERE id = " + id +"";
            ResultSet rs = statement.executeQuery(script);

            while (rs.next()){
                PrimitiveInfo obj = new PrimitiveInfo();
                obj.setId(rs.getLong(1));
                obj.setMessage(rs.getString(2));
                System.out.println(obj);
            }
        } catch (NoClassDefFoundError | Exception ex) {
            System.out.println(ANSI_RED + "Failed to find " + ex);
        }
    }

    public static List<PrimitiveInfo> findAll(){
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            String script = "SELECT * FROM " +"objects";
            ResultSet rs = statement.executeQuery(script);

            while (rs.next()){
                PrimitiveInfo obj = new PrimitiveInfo();
                obj.setId(rs.getLong(1));
                obj.setMessage(rs.getString(2));
                System.out.println(obj);
            }
        } catch (NoClassDefFoundError | Exception ex) {
            System.out.println(ANSI_RED + "Failed to find all " + ex);
        }
        return null;
    }

    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY)

    static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PrimitiveInfo{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }


}
