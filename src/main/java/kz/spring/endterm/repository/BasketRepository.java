package kz.spring.endterm.repository;

import kz.spring.endterm.entity.MyBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<MyBasket, Long> {
    List<MyBasket> getMyBasketsByUserId(Long userId);
}
