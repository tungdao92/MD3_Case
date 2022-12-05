package rikkei.academy.service;

import rikkei.academy.model.LoTrinh;

import java.util.List;

public interface IGenericUser<T> {
    List<T> findAll();
    List<T> findByName(String name);

}
