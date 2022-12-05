package rikkei.academy.service.lotrinh;

import rikkei.academy.model.LoTrinh;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoTrinhService {
    private static final String URL = "jdbc:mysql://localhost:3306/form_login_jv06";
    private static final String USER = "root";
    private static final String PASS = "@Roba1996";


    private static final String INSERT_ADMIN_SQL = "INSERT INTO lotrinh" + "  (name) VALUES " + " (?);";

    private static final String SELECT_ADMIN_BY_ID = "select id,name from lotrinh where id =?";
    private static final String SELECT_ALL_ADMIN = "select * from lotrinh";
    private static final String DELETE_ADMIN_SQL = "delete from lotrinh where id = ?;";
    private static final String UPDATE_ADMIN_SQL = "update lotrinh set name = ? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertAdmin(rikkei.academy.model.LoTrinh loTrinh) throws SQLException {
        System.out.println(INSERT_ADMIN_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
            preparedStatement.setString(1, loTrinh.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public LoTrinh selectAdmin(int id) {
        LoTrinh loTrinh = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                loTrinh = new LoTrinh(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loTrinh;
    }


    public List<LoTrinh> selectAllAdmin() {
        List<LoTrinh> loTrinhList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMIN)
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                loTrinhList.add(new LoTrinh(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loTrinhList;
    }


    public boolean deleteAdmin(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateAdmin(LoTrinh loTrinh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
            statement.setString(1, loTrinh.getName());
            statement.setInt(2, loTrinh.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
