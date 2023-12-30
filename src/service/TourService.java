package service;

import model.Tour;
import model.Tour_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourService implements IService<Tour> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public Tour findByID(int id) {
        for (Tour t :
                findAll()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void add(Tour tour) {
        String sql = "insert into tour(tour_name, tour_time, start_point, destination, price, schedule, description, image, cate_id) values (?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getTour_name());
            preparedStatement.setString(2, tour.getTour_time());
            preparedStatement.setString(3, tour.getStart_point());
            preparedStatement.setString(4, tour.getDescription());
            preparedStatement.setDouble(5, tour.getPrice());
            preparedStatement.setString(6, tour.getSchedule());
            preparedStatement.setString(7, tour.getDescription());
            preparedStatement.setString(8, tour.getImage());
            preparedStatement.setInt(9, tour.getTourCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Tour tour) {
        String sql = "update tour set tour_name = ?, tour_time = ?, start_point = ?, destination = ?, price = ?, schedule = ?, description = ?, image = ?, cate_id = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getTour_name());
            preparedStatement.setString(2, tour.getTour_time());
            preparedStatement.setString(3, tour.getStart_point());
            preparedStatement.setString(4, tour.getDescription());
            preparedStatement.setDouble(5, tour.getPrice());
            preparedStatement.setString(6, tour.getSchedule());
            preparedStatement.setString(7, tour.getDescription());
            preparedStatement.setString(8, tour.getImage());
            preparedStatement.setInt(9, tour.getTourCategory().getId());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from tour where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tour> findAll() {
        List<Tour> list = new ArrayList<>();
        String sql = "select t.*, c.category_name from tour t join tour_category c on t.cate_id = c.id order by id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tour_name = resultSet.getString("tour_name");
                String tour_time = resultSet.getString("tour_time");
                String start_point = resultSet.getString("start_point");
                String destination = resultSet.getString("destination");
                Double price = resultSet.getDouble("price");
                String schedule = resultSet.getString("schedule");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int cate_id = resultSet.getInt("cate_id");
                String cate_name = resultSet.getString("category_name");
                Tour_category tourCategory = new Tour_category(cate_id, cate_name);
                Tour tour = new Tour(id, tour_name, tour_time, start_point, destination, price, schedule, description, image, tourCategory);
                list.add(tour);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Tour> sortByTourCategory(String name) {
        List<Tour> list = new ArrayList<>();
        String sql = "select t.*, c.category_name from tour t join tour_category c on t.cate_id = c.id where c.category_name LIKE '" + name + "' order by id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tour_name = resultSet.getString("tour_name");
                String tour_time = resultSet.getString("tour_time");
                String start_point = resultSet.getString("start_point");
                String destination = resultSet.getString("destination");
                Double price = resultSet.getDouble("price");
                String schedule = resultSet.getString("schedule");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int cate_id = resultSet.getInt("cate_id");
                String cate_name = resultSet.getString("category_name");
                Tour_category tourCategory = new Tour_category(cate_id, cate_name);
                Tour tour = new Tour(id, tour_name, tour_time, start_point, destination, price, schedule, description, image, tourCategory);
                list.add(tour);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Tour> searchByKeyword(String name) {
        List<Tour> list = new ArrayList<>();
        String sql = "select t.*, c.category_name from tour t join tour_category c on t.cate_id = c.id where t.tour_name LIKE '%" + name + "%' OR t.schedule LIKE '%" + name + "%' order by id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tour_name = resultSet.getString("tour_name");
                String tour_time = resultSet.getString("tour_time");
                String start_point = resultSet.getString("start_point");
                String destination = resultSet.getString("destination");
                Double price = resultSet.getDouble("price");
                String schedule = resultSet.getString("schedule");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                int cate_id = resultSet.getInt("cate_id");
                String cate_name = resultSet.getString("category_name");
                Tour_category tourCategory = new Tour_category(cate_id, cate_name);
                Tour tour = new Tour(id, tour_name, tour_time, start_point, destination, price, schedule, description, image, tourCategory);
                list.add(tour);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
