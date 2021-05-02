package kz.spring.endterm.event;

import kz.spring.endterm.entity.MyBasket;
import kz.spring.endterm.model.StatusE;
import org.springframework.context.ApplicationEvent;

public class ChangeBasketStatus extends ApplicationEvent {
    private StatusE statusE;
    private MyBasket myBasket;

    public ChangeBasketStatus(Object source, StatusE statusE, MyBasket myBasket) {
        super(source);
        this.statusE = statusE;
        this.myBasket = myBasket;
    }

    public StatusE getOldStatus() {
        return statusE;
    }

    public MyBasket getMyOrder() {
        return myBasket;
    }
}
