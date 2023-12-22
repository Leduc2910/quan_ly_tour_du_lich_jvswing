package service;

import model.Account;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements IService<Account> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public Account findByID(int id) {
        for (Account a :
                findAll()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void add(Account account) {
        String sql = "insert into account(username, password, role_id) values (?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Account account) {
        String sql = "update account set username = ?, password = ?, role_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRole().getId());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete * from account where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        String sql = "select account.*, role.role_name from account join role on account.role_id = role.id order by account.id asc;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role(role_id, role_name);
                Account account = new Account(id, username, password, role);
                accountList.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountList;
    }
}
