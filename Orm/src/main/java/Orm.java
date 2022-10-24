import java.sql.*;

public class Orm {
    static String username = "root";
    static String password = "1111";
    static String connectionUrl = "jdbc:mysql://localhost:3306/artworks";

    public static final String ANSI_RED = "\u001B[31m";

    public static void addArtist(Artist artist) {
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)){
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("REPLACE INTO artists(id, name, age, type) VALUES " +
                    "(" +
                    Artist.getId()
                    +", "+ "'" +
                    Artist.getName()
                    + "'" + ", "+
                    Artist.getAge()
                    +", "+ "'"+
                    Artist.getType()
                    + "'"+ " )"
            );
        } catch (Exception ex) {
            System.out.println(ANSI_RED + "Failed to add " + ex);
        }
    }

    public static void clearTable(String table){
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
           Statement statement = conn.createStatement();
           int rows = statement.executeUpdate("DELETE FROM " + table + "");
        } catch (Exception ex) {
            System.out.println(ANSI_RED + "Failed to remove " + ex);
        }
    }

    public static void findById(String table, Long id){
        try(Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
            Statement statement = conn.createStatement();
            String script = "SELECT * FROM " +table+ " WHERE id = " + id +"";
            ResultSet rs = statement.executeQuery(script);

            while (rs.next()){
                Artist artist = new Artist(Artist.getId(), Artist.getName(), Artist.getAge(), Artist.getType());
                artist.setId(rs.getLong(1));
                artist.setName(rs.getString(2));
                artist.setAge(rs.getInt(3));
                artist.setType(rs.getString(4));
                System.out.println(artist);
            }
        } catch (NoClassDefFoundError | Exception ex) {
            System.out.println(ANSI_RED + "Failed to find " + ex);
        }
    }
}
