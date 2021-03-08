package application;


import db.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Db.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("Id")+", " + resultSet.getString("Name") );
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        finally {
            Db.closeResultDet(resultSet);
            Db.closeStatement(statement);
            Db.closeConnection();
        }
    }
}
