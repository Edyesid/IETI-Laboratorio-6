package eci.ieti.taskPlanner.persistence.impl;
import eci.ieti.taskPlanner.Model.User;
import eci.ieti.taskPlanner.persistence.UserPersistence;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserPersistence {
    private final List<User> users= new ArrayList<>();
    private User user1;
    private User user2;
    public UserServiceImpl() {
        String userId1 = "123";
        String userId2 = "234";
        String name1 = "Edwin";
        String name2 = "yesid";
        String email1 = "edwin@gmail.com";
        String email2 = "yesid@gmail.com";
        String password1 = "password1";
        String password2 = "password2";
        user1 = new User(userId1,name1,email1,password1);
        user2 = new User(userId2,name2,email2,password2);
        users.add(user1);
        users.add(user2);
    }
    @Override
    public List<User> getAll() {
        return users;
    }
    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }
    @Override
    public User update(User user) {
        for (User i: users) {
            if(i.getUserID() == user.getUserID()) {
                i.setName(user.getName());
                i.setEmail(user.getEmail());
                i.setPassword(user.getPassword());
                return i;
            }
        }
        return user1;
    }
    @Override
    public void remove(String userId) {
        for (User i: users) {
            if(i.getUserID().equals(userId)) {
                users.remove(i);
            }
        }
    }
}
