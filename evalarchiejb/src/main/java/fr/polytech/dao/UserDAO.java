package fr.polytech.dao;

import fr.polytech.model.UserBean;

public interface UserDAO {
    boolean login(String login , String password);

    UserBean getUser(String login);
}
