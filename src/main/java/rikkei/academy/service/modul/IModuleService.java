package rikkei.academy.service.modul;

import rikkei.academy.model.Module;
import rikkei.academy.service.IGenericUser;

import java.util.List;

public interface IModuleService extends IGenericUser {
    List<Module> findByLoTrinh(int id);

}
