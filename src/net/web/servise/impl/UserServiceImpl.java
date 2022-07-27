package net.web.servise.impl;

import net.web.dao.UserDao;
import net.web.domain.User;
import net.web.servise.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDao();
    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
