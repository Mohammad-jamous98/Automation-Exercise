package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DatabaseUtils {

    public static List<Map<String, String>> getSignupUsers() throws Exception {
    	
    	String url = "jdbc:mysql://localhost:3306/DataBaseName";
    	String username = "###";
    	String password = "###";

    	Connection conn = DriverManager.getConnection(url, username, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE customerNumber = 121");

        List<Map<String, String>> users = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> user = new HashMap<>();
            user.put("firstName", rs.getString("contactFirstName").trim());
            user.put("lastName", rs.getString("contactLastName").trim());
            user.put("date_of_birth", rs.getString("date_of_birth").trim());
            user.put("addressLine", rs.getString("addressLine1").trim());
            user.put("country", rs.getString("country").trim());
            user.put("company", rs.getString("customerName").trim());
            user.put("postalCode", rs.getString("postalCode").trim());
            user.put("city", rs.getString("city").trim());
            user.put("state", rs.getString("state").trim());
            user.put("phone", rs.getString("phone").trim());

            users.add(user);
        }

        rs.close();
        stmt.close();
        conn.close();

        return users;
    }
}
