package rikkei.academy.service.lotrinh;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.LoTrinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoTrinhServiceIMPL implements ILoTrinhService{
    private Connection connection = ConnectMySQL.getConnection();

    private  static String LIST_LOTRINH = "SELECT * FROM lotrinh;";
    private static String LOTRINH_BY_NAME = "SELECT * FROM lotrinh WHERE name = ?";
    private static String LOTRINH_BY_ID = "SELECT * FROM lotrinh WHERE id = ?";
    @Override
    public List<LoTrinh> findAll() {
        List<LoTrinh> loTrinhList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(LIST_LOTRINH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LoTrinh loTrinh = new LoTrinh(id, name);
                loTrinhList.add(loTrinh);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loTrinhList;
    }

    @Override
    public List<LoTrinh> findByName(String name) {
        List<LoTrinh> loTrinhList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOTRINH_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                LoTrinh loTrinh = new LoTrinh(id,name);
                loTrinhList.add(loTrinh);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loTrinhList;
    }

    @Override
    public LoTrinh findById(int id) {
        LoTrinh loTrinh = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOTRINH_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                loTrinh = new LoTrinh(id, name);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loTrinh;
    }

}
