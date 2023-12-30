package service;

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

    public boolean checkAccAlreadyByUsername(String username) {
        for (User u : findAll()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAccAlreadyByEmail(String email) {
        for (User u : findAll()) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByAccount(String username, String password) {
        for (User u : findAll()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

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
        String sql = "insert into user(username, password, fullname, birthday, gender, phone, email, role_id) values (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getBirthday());
            preparedStatement.setInt(5, user.getGender());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void edit(int id, User user) {
        String sql = "update user set username = ?, password = ?, fullname = ?, birthday = ?, gender = ?, phone = ?, email = ?, role_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getBirthday());
            preparedStatement.setInt(5, user.getGender());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getRole().getId());
            preparedStatement.setInt(9, id);
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
        String sql = "select user.*, role.role_name from user join role on user.role_id = role.id order by id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullname");
                String birthday = resultSet.getString("birthday");
                int gender = resultSet.getInt("gender");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int role_id = resultSet.getInt("role_id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role(role_id, role_name);
                User user = new User(id, username, password, fullName, birthday, gender, phone, email, role);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public List<User> findByName(String name) {
        List<User> userList = new ArrayList<>();
        String sql = "select user.*, role.role_name from user join role on user.role_id = role.id where user.fullname LIKE '%" + name + "%' order by id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullname");
                String birthday = resultSet.getString("birthday");
                int gender = resultSet.getInt("gender");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int role_id = resultSet.getInt("role_id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role(role_id, role_name);
                User user = new User(id, username, password, fullName, birthday, gender, phone, email, role);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
