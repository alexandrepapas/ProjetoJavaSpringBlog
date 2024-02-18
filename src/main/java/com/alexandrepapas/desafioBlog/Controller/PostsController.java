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
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarPost(@PathVariable Long id, @RequestBody PostsDTO postsDTO) {
        Posts posts = postsServices.editarPost(id, postsDTO);
        return ResponseEntity.ok().body(posts);
    }


    @GetMapping("/ordenados")
    public ResponseEntity<List<Posts>> buscarPosts(@RequestParam(required = false) Long userId, @RequestParam(defaultValue = "false") boolean reverseOrder) {
        List<Posts> posts = postsServices.buscarPostsIdOrdem(userId, reverseOrder);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Posts> buscarPostId(@PathVariable Long id) {
        Posts posts = postsServices.buscarPostPorId(id);
        return ResponseEntity.ok().body(posts);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPost(@PathVariable Long id) {
        postsServices.deletarPost(id);
        return ResponseEntity.ok().build();
    }

}
