package com.leodev.springmongo.repository;

import com.leodev.springmongo.domain.Post;
import com.leodev.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
