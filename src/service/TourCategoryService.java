package service;

import model.Tour;
import model.Tour_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourCategoryService implements IService<Tour_category> {

    private Connection connection = ConnectToMySQL.getConnection();
    public Tour_category findByName(String value) {
        for (Tour_category c :
                findAll()) {
            if (c.getCategory_name().equals(value)) {
                return c;
            }
        }
        return null;
    }
    @Override
    public Tour_category findByID(int id) {
        for (Tour_category c :
                findAll()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void add(Tour_category tourCategory) {
        String sql = "insert into tour_category(category_name) values (?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tourCategory.getCategory_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Tour_category tourCategory) {
        String sql = "update tour_category set category_name = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tourCategory.getCategory_name());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from tour_category where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tour_category> findAll() {
        List<Tour_category> list = new ArrayList<>();
        String sql = "select * from  tour_category c order by id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cate_name = resultSet.getString("category_name");
                Tour_category tourCategory = new Tour_category(id, cate_name);
                list.add(tourCategory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
