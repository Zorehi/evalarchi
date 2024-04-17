package fr.polytech.business;

import fr.polytech.dao.UserDAO;

public class UserBusinessImpl implements UserBusiness{
    private final UserDAO userDAO;

    public UserBusinessImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean login(String login, String password) {
        return userDAO.login(login, password);
    }
}
