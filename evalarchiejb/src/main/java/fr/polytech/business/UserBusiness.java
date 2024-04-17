package fr.polytech.business;

import fr.polytech.model.UserBean;
import jakarta.ejb.Local;

@Local
public interface UserBusiness {
     boolean login(String login, String password);

     UserBean findByLogin(String login);
}
