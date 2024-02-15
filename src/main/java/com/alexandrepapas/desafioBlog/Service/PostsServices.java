package com.alexandrepapas.desafioBlog.Service;

import com.alexandrepapas.desafioBlog.Exepections.ResourceNotFoundException;
import com.alexandrepapas.desafioBlog.Repository.AutorRepository;
import com.alexandrepapas.desafioBlog.Repository.PostsRepository;
import com.alexandrepapas.desafioBlog.dtos.PostsDTO;
import com.alexandrepapas.desafioBlog.model.Autor;
import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServices {

    private final PostsRepository postsRepository;
    private final AutorRepository autorRepository;

    @Autowired
    public PostsServices(PostsRepository postsRepository, AutorRepository autorRepository) {
        this.postsRepository = postsRepository;
        this.autorRepository = autorRepository;
    }

    public Posts criarPosts(PostsDTO postsDTO) {
        if (postsDTO.getAutorId() == null) {
            throw new IllegalArgumentException("O id do autor é obrigatório");
        }
        Autor autor = autorRepository.findById(postsDTO.getAutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor não Encontrado"));

        Posts posts = new Posts();
        posts.setTitulo(postsDTO.getTitulo());
        posts.setConteudo(postsDTO.getConteudo());
        posts.setAutor(autor);

        return postsRepository.save(posts);
    }

}