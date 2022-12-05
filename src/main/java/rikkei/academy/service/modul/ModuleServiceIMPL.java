package rikkei.academy.service.modul;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleServiceIMPL implements IModuleService {
    private Connection connection = ConnectMySQL.getConnection();
    private static String LIST_MODULE = "SELECT * FROM module WHERE id_lotrinh = ?;";

    private static String MODULE_BY_NAME = "SELECT * FROM module WHERE name_module LIKE ?;";

    @Override
    public List findAll() {
        List<Module> moduleList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(LIST_MODULE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_lotrinh = resultSet.getInt("id_lotrinh");
                String name = resultSet.getString("name_module");
                Module module = new Module(id, id_lotrinh, name);
                moduleList.add(module);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moduleList;
    }

    @Override
    public List<Module> findByName(String name) {
        List<Module> moduleList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(MODULE_BY_NAME);
            preparedStatement.setString(1, '%'+name+'%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_lotrinh = resultSet.getInt("id_lotrinh");
                Module module = new Module(id, id_lotrinh, name);
                moduleList.add(module);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moduleList;
    }

    @Override
    public List<Module> findByLoTrinh(int idLoTrinh) {
        List<Module> moduleList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(LIST_MODULE);
            statement.setInt(1,idLoTrinh);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_lotrinh = resultSet.getInt("id_lotrinh");
                String name_module = resultSet.getString("name_module");
                Module module = new Module(id, id_lotrinh, name_module);
                moduleList.add(module);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moduleList;
    }


}
