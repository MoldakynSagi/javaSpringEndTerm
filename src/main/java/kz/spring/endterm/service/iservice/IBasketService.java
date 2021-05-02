package kz.spring.endterm.service.iservice;

import kz.spring.endterm.entity.MyBasket;
import kz.spring.endterm.model.StatusE;

import java.util.List;

public interface IBasketService {
    List<MyBasket> getAll();
    List<MyBasket> getBasketsById(Long userId);
    MyBasket createNew(MyBasket myBasket);
    MyBasket changeBasketStatus(Long basketId, StatusE status);
}
