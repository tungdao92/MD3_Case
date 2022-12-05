package rikkei.academy.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<T> {
    void save(T t);
    List<T> getList() throws SQLException;
}
