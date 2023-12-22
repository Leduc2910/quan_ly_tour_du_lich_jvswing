package service;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(int id, User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select user.*, account.username, account.password, account.role_id, role.role_name\n" +
                "from user\n" +
                "         join account on account.id = user.account_id\n" +
                "         join role on account.role_id = role.id\n" +
                "order by account_id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
