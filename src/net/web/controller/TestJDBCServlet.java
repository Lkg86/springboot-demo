package net.web.controller;

import net.web.util.CustomDBUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/jdbc")
public class TestJDBCServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  idStr = req.getParameter("id");

        int id= Integer.parseInt(idStr);



        try {
            Connection connection = CustomDBUtil.getConnection();
            PreparedStatement ps=connection.prepareStatement("select *from user where id=?");

            ps.setInt(1,id);
            ResultSet resultSet=ps.executeQuery();

            while (resultSet.next()){
                System.out.println("用户名 name="+resultSet.getString("username"));
                System.out.println("联系方式 wechat="+resultSet.getString("wechat"));
            }

            CustomDBUtil.close(resultSet,ps,connection);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
