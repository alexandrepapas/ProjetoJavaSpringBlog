package com.alexandrepapas.desafioBlog.Controller;

import com.alexandrepapas.desafioBlog.Exepections.ResourceNotFoundException;
import com.alexandrepapas.desafioBlog.Repository.AutorRepository;
import com.alexandrepapas.desafioBlog.Repository.PostsRepository;
import com.alexandrepapas.desafioBlog.Service.AutorService;
import com.alexandrepapas.desafioBlog.Service.PostsServices;
import com.alexandrepapas.desafioBlog.dtos.PostsDTO;
import com.alexandrepapas.desafioBlog.model.Autor;
import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private final AutorService autorService;
    private final PostsServices postsServices;

    @Autowired
    public PostsController(AutorService autorService, PostsServices postsServices) {
        this.autorService = autorService;
        this.postsServices = postsServices;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarPost(@RequestBody PostsDTO postsDTO) {
        Posts posts = postsServices.criarPosts(postsDTO);
        return ResponseEntity.ok().body(posts);

    }
}
