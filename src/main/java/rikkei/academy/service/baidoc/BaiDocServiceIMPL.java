package rikkei.academy.service.baidoc;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.BaiDoc;
import rikkei.academy.model.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaiDocServiceIMPL implements IBaiDocService{
    private Connection connection = ConnectMySQL.getConnection();
    private static String LIST_BAIDOC = "SELECT * FROM baidoc WHERE id_module = ?;";
    private static String SEARCH_BAIDOC = "SELECT* FROM baidoc WHERE name_baidoc LIKE ?;";
    @Override
    public List<BaiDoc> findByBaiDoc(int idModule) {
        List<BaiDoc> baiDocList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(LIST_BAIDOC);
            statement.setInt(1, idModule);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_lotrinh = resultSet.getInt("id_lotrinh");
                int id_module = resultSet.getInt("id_module");
                String name_baidoc = resultSet.getString("name_baidoc");
                BaiDoc baiDoc = new BaiDoc(id, id_lotrinh, id_module, name_baidoc);
                baiDocList.add(baiDoc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return baiDocList;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List<BaiDoc> findByName(String name_search) {
        List<BaiDoc> baiDocList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BAIDOC);
            preparedStatement.setString(1, '%'+name_search+'%');

            //Thực hiện câu lệnh câu lệnh query
            ResultSet resultSet = preparedStatement.executeQuery();

            //duyệ từng dòng trong bảng
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_lotrinh = resultSet.getInt("id_lotrinh");
                int id_module = resultSet.getInt("id_module");
                String name_baidoc = resultSet.getString("name_baidoc");
                BaiDoc baiDoc = new BaiDoc(id, id_lotrinh, id_module, name_baidoc);
                baiDocList.add(baiDoc);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return baiDocList;
    }
}
