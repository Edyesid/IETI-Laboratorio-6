package eci.ieti.taskPlanner.services;
import eci.ieti.taskPlanner.Model.User;
import eci.ieti.taskPlanner.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserPersistence userPersistence;
    public List<User> getAll() {
        return userPersistence.getAll();
    }
    public User create(User user) {
        return userPersistence.create(user);
    }
    public User update(User user) {
        return userPersistence.update(user);
    }
    public void remove(String userId) {
        userPersistence.remove(userId);
    }
}
