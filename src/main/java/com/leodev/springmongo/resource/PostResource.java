package com.leodev.springmongo.resource;

import com.leodev.springmongo.domain.Post;
import com.leodev.springmongo.resource.util.URL;
import com.leodev.springmongo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
public class PostResource {
    private final PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(postService.findByTitle(text));
    }
}
