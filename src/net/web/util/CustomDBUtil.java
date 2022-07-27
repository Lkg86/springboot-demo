package net.web.util;

import java.sql.*;
import java.util.Properties;

public class CustomDBUtil {

    private static String url;

    private static String username;

    private static String password;

    private static String driver;

    static {

        try {
            Properties properties=new Properties();

            properties.load(CustomDBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws Exception
     */

    public static Connection getConnection() throws Exception{
        Connection connection= DriverManager.getConnection(url,username,password);

        return  connection;
    }

    /**
     * 关闭数据库
     * @param resultSet
     * @param ps
     * @param connection
     */

    public static void close(ResultSet resultSet, PreparedStatement ps, Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
