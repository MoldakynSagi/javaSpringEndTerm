package kz.spring.endterm.event;

import kz.spring.endterm.entity.Product;
import kz.spring.endterm.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserAddNewFavorite extends ApplicationEvent {
    private User user;
    private Product product;

    public UserAddNewFavorite(Object source, User user, Product product) {
        super(source);
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Product getMusic() {
        return product;
    }
}
