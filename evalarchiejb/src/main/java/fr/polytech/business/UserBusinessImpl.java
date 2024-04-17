package fr.polytech.business;

import fr.polytech.dao.UserDAO;
import fr.polytech.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserBusinessImpl implements UserBusiness{
    @Inject
    private UserDAO userDAO;

    @Override
    public boolean login(String login, String password) {
        return userDAO.login(login, password);
    }

    @Override
    public UserBean findByLogin(String login) {
        return userDAO.getUser(login);
    }


}
