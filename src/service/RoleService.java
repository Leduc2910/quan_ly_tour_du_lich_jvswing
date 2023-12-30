package service;

import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleService implements IService<Role> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public Role findByID(int id) {
        for (Role r : findAll()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Role findByName(String name) {
        for (Role r : findAll()) {
            if (r.getRole_name().equals(name)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public void edit(int id, Role role) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = new ArrayList<>();
        String sql = "Select * from role;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role(id, role_name);
                roleList.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roleList;
    }
}
