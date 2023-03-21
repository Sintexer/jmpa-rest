package com.epam.ilyabuglakov.rest.impl.user;

import com.epam.ilyabuglakov.rest.dto.user.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryUserRepository implements UserRepository {

    private final AtomicLong idGenerator = new AtomicLong();
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public User findById(long id) {
        return users.get(id);
    }

    @Override
    public boolean existsById(long id) {
        return users.containsKey(id);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idGenerator.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(long id) {
        users.remove(id);
    }
}
