package org.example.Rcontectsql;

import org.example.Robbotil.RMysqltill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ExpSource {
    public String dialog(String receive){
        String sql = "select answer from expsource.dialog where receive = ?";
        String countsql = "select count(*) from (select answer from expsource.dialog where receive = ?) goal";
        //todo
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = RMysqltill.getConnect();
        Random random = new Random();

    if (connection==null)return null;
        try {
            int count = 0;
            ps = connection.prepareStatement(countsql);
            ps.setString(1,receive);
            rs = ps.executeQuery();
            if (rs.next())count = rs.getInt(1);
            ps = connection.prepareStatement(sql);
            ps.setString(1,receive);
            rs = ps.executeQuery();
            if (rs.next())return rs.getString(random.nextInt(count) + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            RMysqltill.closeConnect(connection);
            RMysqltill.closePs(ps);
            RMysqltill.closeRs(rs);
        }
        return null;
    }

    public void insertDialog(String receive,String answer){
        String sql = "insert into expsource.dialog values (?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = RMysqltill.getConnect();

        if (connection==null)return;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,receive);
            ps.setString(2,answer);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            RMysqltill.closeConnect(connection);
            RMysqltill.closePs(ps);
            RMysqltill.closeRs(rs);
        }
    }
}
