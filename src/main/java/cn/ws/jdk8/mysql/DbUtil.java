package cn.ws.jdk8.mysql;

import java.sql.*;

public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args){

//        String selectSql = "select * from user where  user_id =1116642000 and pk_id =60000010";
//        String selectSql2 = "select * from user where  user_id =1116642000 and pk_id =60000012";
        //创建sql语句
        String sql = "UPDATE user SET launch_time =  CONCAT(IF(launch_time IS NULL,'',CONCAT(launch_time,','))," +
                "\"158459652\")  where user_id =1116675000 and pk_id =13201";
        long t1 = System.currentTimeMillis();
        conn(sql);
        long t2 = System.currentTimeMillis();
        String selectSql2 = "select * from user where  user_id =1116675000 and pk_id =33339";
        String s = conn2(selectSql2);
        String newS = s + ",158459652";
        String sql2 = "UPDATE user SET launch_time = '"+newS+"' where user_id =1116675000 and pk_id =33339";
        conn(sql2);
        long t3 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);

    }



    public static void conn(String sql){
        Connection conn = null;
        try
        {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static String conn2(String sql){
        Connection conn = null;
        String launch_time = "";
        try
        {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                launch_time = resultSet.getString("launch_time");
            }

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return launch_time;
    }
}