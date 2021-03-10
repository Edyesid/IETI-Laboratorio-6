package eci.ieti.taskPlanner.persistence;
import java.util.List;
import eci.ieti.taskPlanner.Model.User;

public interface UserPersistence {
    List<User> getAll();
    User create(User user);
    User update(User user);
    void remove(String userId);
}
