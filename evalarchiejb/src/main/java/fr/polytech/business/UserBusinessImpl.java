package fr.polytech.business;

import fr.polytech.dao.UserDAO;
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
}
