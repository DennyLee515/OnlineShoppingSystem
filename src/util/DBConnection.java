package util;

import java.sql.*;

public class DBConnection {

    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/coffeeshop";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";
//    private static final String DB_CONNECTION = "jdbc:postgresql://ec2-174-129-43-40.compute-1.amazonaws.com:5432/de8vhepp4ntjh9";
//    private static final String DB_USER = "pwjesluumgiswf";
//    private static final String DB_PASSWORD = "d0d4359a22d526b08b2810d7037c76dbf885faa2c357db503802524ce6a677cf";

    static Connection dbConnection = null;

    public static PreparedStatement prepare(String stm) throws SQLException {

        PreparedStatement preparedStatement = null;
        try {
            Connection dbConnection = getDBConnection();

            preparedStatement = dbConnection.prepareStatement(stm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return preparedStatement;
    }

    public static void close(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
        dbConnection.close();
    }

    private static Connection getDBConnection() {
        try {

            DriverManager.registerDriver(new org.postgresql.Driver());

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection problem");
        return null;
    }


}
