package fr.polytech.business;

import jakarta.ejb.Local;

@Local
public interface UserBusiness {
    public boolean login(String login, String password);
}
