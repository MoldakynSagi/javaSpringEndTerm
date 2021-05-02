package kz.spring.endterm.service;

import kz.spring.endterm.entity.Product;
import kz.spring.endterm.entity.User;
import kz.spring.endterm.event.UserAddNewFavorite;
import kz.spring.endterm.repository.UserRepository;
import kz.spring.endterm.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService, ApplicationEventPublisherAware {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUsername(Long id, String username) {
        User user = userRepository.getOne(id);
        user.setUsername(username);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User addMusicToFavorites(Long userId, Product product) {
        User user = userRepository.getOne(userId);
        user.getFavoriteProducts().add(product);
        eventPublisher.publishEvent(new UserAddNewFavorite(this, user, product));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User deleteMusicFromFavorites(Long userId, Product product) {
        User user = userRepository.getOne(userId);
        user.getFavoriteProducts().remove(product);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User createNew(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User by username=" + username + " not found!");
        }
        return user;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
