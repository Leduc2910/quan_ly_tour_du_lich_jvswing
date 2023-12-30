package service;

import model.Tour;
import model.Tour_Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourVehicleService implements IService<Tour_Vehicle> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public Tour_Vehicle findByID(int id) {
        for (Tour_Vehicle t :
                findAll()) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void add(Tour_Vehicle tourVehicle) {
        String sql = "insert into tour_vehicle(vehicle_id, tour_id) values (?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourVehicle.getVehicle_id());
            preparedStatement.setInt(2, tourVehicle.getTour_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Tour_Vehicle tourVehicle) {
        String sql = "update tour_vehicle set vehicle_id = ?, tour_id = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourVehicle.getVehicle_id());
            preparedStatement.setInt(2, tourVehicle.getTour_id());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from tour_vehicle where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tour_Vehicle> findAll() {
        List<Tour_Vehicle> tourVehicles = new ArrayList<>();
        String sql = "select * from tour_vehicle";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int vehicle_id = resultSet.getInt("vehicle_id");
                int tour_id = resultSet.getInt("tour_id");
                Tour_Vehicle tourVehicle = new Tour_Vehicle(id, tour_id, vehicle_id);
                tourVehicles.add(tourVehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tourVehicles;
    }
}
