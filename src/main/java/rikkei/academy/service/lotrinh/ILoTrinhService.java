package rikkei.academy.service.lotrinh;

import rikkei.academy.model.LoTrinh;
import rikkei.academy.service.IGenericUser;

import java.util.List;

public interface ILoTrinhService extends IGenericUser {
    LoTrinh findById(int id);

}

