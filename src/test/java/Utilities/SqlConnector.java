package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;


public class SqlConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String user = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String password = ReadConfigFiles.getPropertyValues("DbPassword");

    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);

    /**
     * connect to the postgreSQL database
     * @return a Connection Object
     */

    public static  Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
        }catch (Exception e) {
            LOGGER.error("SQL connection Exception" + e.getMessage());
        }
        return conn;
    }

    /**
     * Reading Data From the Database
     * @param SQL is the method Parameter to connect  the SQL Query
     * @return  ResultSet Object
     * @throws SQLException
     */
    public static ResultSet readData(String SQL) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
           conn = connect();
            LOGGER.debug("Connection Object Value" + conn);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

        }catch (SQLException e) {
            LOGGER.error("SQL Connection Exception" + e.getMessage());
        }finally {
            conn.close();
        }
        return rs;
    }
}


