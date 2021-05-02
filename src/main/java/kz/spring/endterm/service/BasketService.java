package kz.spring.endterm.service;

import kz.spring.endterm.entity.MyBasket;
import kz.spring.endterm.event.ChangeBasketStatus;
import kz.spring.endterm.model.StatusE;
import kz.spring.endterm.repository.BasketRepository;
import kz.spring.endterm.service.iservice.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BasketService implements IBasketService, ApplicationEventPublisherAware {
    @Autowired
    private BasketRepository basketRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<MyBasket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public List<MyBasket> getBasketsById(Long userId) {
        return basketRepository.getMyBasketsByUserId(userId);
    }

    @Override
    public MyBasket createNew(MyBasket order) {
        order.setDay(new Date());
        MyBasket saveOrder = basketRepository.saveAndFlush(order);

        for (int i = 0; i < saveOrder.getProductStatuses().size(); i++) {
                saveOrder.getProductStatuses().get(i).setBasket_Id(saveOrder.getId());
        }

        return basketRepository.saveAndFlush(saveOrder);
    }

    @Override
    public MyBasket changeBasketStatus(Long orderId, StatusE status) {
        MyBasket order = basketRepository.getOne(orderId);
        StatusE oldStatus = order.getStatus();
        order.setStatus(status);
        eventPublisher.publishEvent(new ChangeBasketStatus(this, oldStatus, order));
        return basketRepository.saveAndFlush(order);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
