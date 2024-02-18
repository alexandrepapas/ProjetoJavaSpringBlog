package com.alexandrepapas.desafioBlog.Service;

import com.alexandrepapas.desafioBlog.Exepections.ResourceNotFoundException;
import com.alexandrepapas.desafioBlog.Repository.AutorRepository;
import com.alexandrepapas.desafioBlog.Repository.PostsRepository;
import com.alexandrepapas.desafioBlog.dtos.PostsDTO;
import com.alexandrepapas.desafioBlog.model.Autor;
import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Autor autor = autorRepository.findById(postsDTO.getAutorId()).orElseThrow(() -> new ResourceNotFoundException("Autor não Encontrado"));

        Posts posts = new Posts();
        posts.setTitulo(postsDTO.getTitulo());
        posts.setConteudo(postsDTO.getConteudo());
        posts.setAutor(autor);

        return postsRepository.save(posts);
    }

    public Posts editarPost(Long id, PostsDTO postsDTO) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado"));

        if (postsDTO.getTitulo() != null) {
            posts.setTitulo(postsDTO.getTitulo());
        }

        if (postsDTO.getConteudo() != null) {
            posts.setConteudo(postsDTO.getConteudo());
        }

        if (postsDTO.getAutorId() != null) {
            Autor autor = autorRepository.findById(postsDTO.getAutorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado"));
            posts.setAutor(autor);
        }

        return postsRepository.save(posts);
    }

    public List<Posts> buscarPostsIdOrdem(Long userId, boolean ordemReversa) {
        Sort sort = Sort.by(ordemReversa ? Sort.Direction.ASC : Sort.Direction.DESC, "dataCriacao");
        if (userId != null) {
            return postsRepository.findByAutorId(userId, sort);
        } else {
            return postsRepository.findAll(sort);
        }
    }

    public Posts buscarPostPorId(Long id) {
        return postsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado"));
    }

    public void deletarPost(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado"));
        postsRepository.delete(posts);
    }

}