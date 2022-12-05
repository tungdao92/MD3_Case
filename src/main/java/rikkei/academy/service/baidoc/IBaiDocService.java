package rikkei.academy.service.baidoc;

import rikkei.academy.model.BaiDoc;
import rikkei.academy.model.Module;
import rikkei.academy.service.IGenericService;
import rikkei.academy.service.IGenericUser;

import java.util.List;

public interface IBaiDocService extends IGenericUser {
    List<BaiDoc> findByBaiDoc(int id);

}
