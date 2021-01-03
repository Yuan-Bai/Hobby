package org.example.Robbotil;

import java.sql.*;

public class RMysqltill {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/adminsave?user=root&password=Yasdfvghj299&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnect(Connection connection){
        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePs(PreparedStatement ps){
        if (null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRs(ResultSet rs){
        if (null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
