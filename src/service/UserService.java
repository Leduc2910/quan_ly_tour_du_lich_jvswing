package service;

import model.Account;
import model.Role;
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
        for (User u :
                findAll()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        String sql = "insert into user(fullname, birthday, gender, phone, email, account_id) values (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getBirthday());
            preparedStatement.setInt(3, user.getGender());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAccount().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void edit(int id, User user) {
        String sql = "update user set fullname = ?, birthday = ?, gender = ?, phone = ?, email = ?, account_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getBirthday());
            preparedStatement.setInt(3, user.getGender());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAccount().getId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete * from user where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select user.*, account.username, account.password, account.role_id, role.role_name\n" +
                "from user\n" +
                "         join account on account.id = user.account_id\n" +
                "         join role on account.role_id = role.id\n" +
                "order by id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullname");
                String birthday = resultSet.getString("birthday");
                int gender = resultSet.getInt("gender");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int account_id = resultSet.getInt("account_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role(role_id, role_name);
                Account account = new Account(account_id, username, password, role);
                User user = new User(id, fullName, birthday, gender, phone, email, account);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
