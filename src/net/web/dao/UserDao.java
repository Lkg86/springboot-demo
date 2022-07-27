package net.web.dao;

import net.web.domain.User;
import net.web.util.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    private QueryRunner queryRunner =new QueryRunner(DataSourceUtil.getDataSource());

    public User findById(int id){

        String sql="select *from user where id=?";

        User user=null;
        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class),id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
