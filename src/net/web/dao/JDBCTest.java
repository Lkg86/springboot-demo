package net.web.dao;

import java.sql.*;

public class JDBCTest {

        public static void main(String [] args) throws  Exception{
//            Class.forName("com.mysql.jdbc.Driver");
//
//            String username="root";
//            String password="123456";
//
//            String url="jdbc:mysql://192.168.2.132:3306/XD?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//
//            Connection connection= DriverManager.getConnection(url,username,password);
//
//            String name="jack";
//            String pwd="666";
//
//            PreparedStatement preparedStatement =connection.prepareStatement("select * from user where username=? and pwd=?");
//
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2,pwd);
//
//            ResultSet resultSet = preparedStatement.executeQuery();



//      ResultSet resultSet= statement.executeQuery("select * from user ");

//            while (resultSet.next()){
//
//                System.out.println("用户名 name="+resultSet.getString("username"));
//                System.out.println("联系方式 wechat="+resultSet.getString("wechat"));
//            }
//
//            preparedStatement.close();
//            connection.close();

            testAdd();

        }


    private static void  testTransaction() throws  Exception{
        Class.forName("com.mysql.jdbc.Driver");

        String username="root";
        String password="123456";

        String url="jdbc:mysql://192.168.2.132:3306/XD?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        Connection connection= DriverManager.getConnection(url,username,password);

        connection.setAutoCommit(false);

        try(PreparedStatement ps1=  connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values (?,?,?,?,?)");
            PreparedStatement ps2=  connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values (?,?,?,?,?)");
                ) {
            ps1.setString(1,"tranc ps1");
            ps1.setString(2,"123456");

            ps2.setString(1,"tranc ps2");
            ps2.setString(2,"123456");

            ps1.execute();
            ps2.execute();
        }catch (Exception e){
            e.printStackTrace();

            connection.rollback();

        }finally {

            connection.commit();
            connection.close();
        }
    }

    private static void  testAdd() throws  Exception{
        Class.forName("com.mysql.jdbc.Driver");

        String username="root";
        String password="123456";

        String url="jdbc:mysql://192.168.2.132:3306/XD?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        Connection connection= DriverManager.getConnection(url,username,password);

        PreparedStatement preparedStatement=  connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values (?,?,?,?,?)");

        preparedStatement.setString(1,"小D");
        preparedStatement.setString(2,"123456");
        preparedStatement.setInt(3,1);
        preparedStatement.setInt(4,2);
        preparedStatement.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

        preparedStatement.execute();

        preparedStatement.close();

        connection.close();
    }


}
