package per.bai.greedysnake.serviceImp;

import per.bai.greedysnake.Gutil.Gameutil;
import per.bai.greedysnake.Gutil.GetAdmin;
import per.bai.greedysnake.Gutil.GetScore;
import per.bai.greedysnake.function.SnakeNode;
import per.bai.greedysnake.serviceInterface.AdminService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AdminServiceImp implements AdminService {
    static int totalPage;

    @Override
    public boolean login(GetAdmin getAdmin) {
        String username = getAdmin.getUsername();
        String password = getAdmin.getPassword();
        String sql = "select password from adminsave.admins where username = ?";
        String sql1 = "select id from adminsave.admins where username = ?";
        String sqlcount = "select count(*) from adminsave.score";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = Gameutil.getConnect();
        if (connection==null)return false;
        try {
            ps = connection.prepareStatement(sqlcount);
            rs = ps.executeQuery();
            rs.next();
            totalPage = (rs.getInt(1))/10 + 1;
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                String psw = rs.getString(1);
                if (psw.equals(password)){
                    ps = connection.prepareStatement(sql1);
                    ps.setString(1,username);
                    rs = ps.executeQuery();
                    rs.next();
                    int id = rs.getInt(1);
                    getAdmin.setId(id);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Gameutil.closeConnect(connection);
            Gameutil.closePs(ps);
            Gameutil.closeRs(rs);
        }
        return false;
    }


    //todo
    //处理用户名重复问题
    @Override
    public boolean register(GetAdmin getAdmin) {
        String username = getAdmin.getUsername();
        String password = getAdmin.getPassword();
        String sqlUnique = "select username from adminsave.admins";
        String sqlcount = "select count(*) from adminsave.admins";
        String sql = "insert into adminsave.admins values (?,?,?)";
        String sqlcount1 = "select count(*) from adminsave.score";
        String sql1 = "insert into adminsave.score values (?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = Gameutil.getConnect();
        if (connection==null)return false;
        try {
            ps = connection.prepareStatement(sqlUnique);
            rs = ps.executeQuery();
            while (rs.next()){
                if (getAdmin.getUsername().equals(rs.getString(1)))return false;
            }
            ps = connection.prepareStatement(sqlcount);
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setInt(3,count+1);
            ps.executeUpdate();
            ps = connection.prepareStatement(sqlcount1);
            rs = ps.executeQuery();
            rs.next();
            int count1 = rs.getInt(1);
            ps = connection.prepareStatement(sql1);
            ps.setString(1,username);
            ps.setInt(2,count1+1);
            ps.setInt(3,0);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Gameutil.closeConnect(connection);
            Gameutil.closePs(ps);
            Gameutil.closeRs(rs);
        }
        return false;
    }

    public void storage(GetAdmin getAdmin){
        int id = getAdmin.getId();
        String sql = "update adminsave.score set adminsave.score.userscore = ? where adminsave.score.id = ?;";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = Gameutil.getConnect();
        try {
            if (null == connection)return;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, SnakeNode.length);
            ps.setInt(2,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Gameutil.closeConnect(connection);
            Gameutil.closePs(ps);
            Gameutil.closeRs(rs);
        }
    }

    public Vector<Vector> showRank(GetScore getScore){
        getScore.setTotalPage(totalPage);
        StringBuffer sql = new StringBuffer();
        sql.append("select * from score order by userscore desc");
        //todo
        /*
        if (){
            gs.setPageNow(gs.getPageNow()+1);
        }*/
        Vector<Vector> data = new Vector<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        connection = Gameutil.getConnect();

        //优化
        getScore.setStart();
        int count = 0;
        try {
            ps = connection.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()){
                if (count < getScore.getStart() + getScore.getPageSize()&&count >= getScore.getStart()){
                    Vector<Object> userScore = new Vector<>();
                    String username = rs.getString("username");
                    int id = rs.getInt("id");
                    int userscore = rs.getInt("userscore");
                    userScore.add(username);
                    userScore.add(id);
                    userScore.add(userscore);
                    data.addElement(userScore);
                }
                count++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Gameutil.closeConnect(connection);
            Gameutil.closePs(ps);
            Gameutil.closeRs(rs);
        }
        return data;
    }
}
