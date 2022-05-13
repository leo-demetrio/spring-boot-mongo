package com.leodev.springmongo.config;

import com.leodev.springmongo.domain.Post;
import com.leodev.springmongo.domain.User;
import com.leodev.springmongo.repository.PostRepository;
import com.leodev.springmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@RequiredArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Partiu viagem abraços",maria);
        Post post2 = new Post(null, sdf.parse("21/04/2018"), "Partiu Noronha", "Partiu Noronha abraços",alex);
        Post post3 = new Post(null, sdf.parse("21/05/2018"), "Partiu Búzios", "Partiu Búzios abraços", bob);


        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(post1,post2,post3));
    }
}
