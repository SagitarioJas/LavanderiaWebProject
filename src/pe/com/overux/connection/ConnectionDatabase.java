package pe.com.overux.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConnectionDatabase {
    public static Connection getConnection() {
        Connection connection=null;
        try {
            InitialContext context = new InitialContext();
            connection = ((DataSource) context.lookup("jdbc/MySQLDataSource"))
                    .getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
