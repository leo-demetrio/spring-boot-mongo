package com.leodev.springmongo.services;

import com.leodev.springmongo.domain.Post;
import com.leodev.springmongo.exception.ObjectNotFoundException;
import com.leodev.springmongo.repository.PostRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }
    public List<Post> findByTitle(String text){
//        return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }
}
