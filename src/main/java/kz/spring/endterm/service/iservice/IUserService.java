package kz.spring.endterm.service.iservice;

import kz.spring.endterm.entity.Product;
import kz.spring.endterm.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User createNew(User user);
    User updateUsername(Long id, String username);
    User addMusicToFavorites(Long userId, Product product);
    User deleteMusicFromFavorites(Long userId, Product product);
}
