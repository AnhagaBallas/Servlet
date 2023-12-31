package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
    private AtomicLong id = new AtomicLong();
    private Map<Long, Post> postList = new ConcurrentHashMap<>();

    public List<Post> all() {
        return new ArrayList<>(postList.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(postList.get(id));
    }

    public Post save(Post post) {
        id.incrementAndGet();
        postList.put(id.get(), post);
        return post;
    }

    public void removeById(long id) {
        try {
            postList.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
