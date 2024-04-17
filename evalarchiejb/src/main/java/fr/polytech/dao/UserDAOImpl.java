package fr.polytech.dao;

import fr.polytech.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "Evalarchi")
    private EntityManager em;

    @Override
    public boolean login(String login, String password) {
        boolean response = false;
        // Requête pour récupérer l'utilisateur avec le login spécifié
        TypedQuery<UserBean> query = em.createQuery(
            "SELECT u FROM UserBean u WHERE u.login = :login", UserBean.class);
        query.setParameter("login", login);
        List<UserBean> userList = query.getResultList();
        for(UserBean user : userList){
            if (user.getPassword().equals(password)) {
                response = true;
                break;
            }
        }
        return response;
    }

    @Override
    public UserBean getUser(String login) {
        TypedQuery<UserBean> query = em.createQuery(
                "SELECT u FROM UserBean u WHERE u.login = :login", UserBean.class);
        query.setParameter("login", login);
        List<UserBean> userList = query.getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }
}

