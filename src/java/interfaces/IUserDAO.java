package interfaces;

import dto.User;

public interface IUserDAO {
    public User getUserByEmail(String email);
    public User getUserForLogin(String email, String password);
    public int addNewUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
}
