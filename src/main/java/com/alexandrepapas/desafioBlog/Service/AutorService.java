package com.alexandrepapas.desafioBlog.Service;

import com.alexandrepapas.desafioBlog.Exepections.ResourceNotFoundException;
import com.alexandrepapas.desafioBlog.Repository.AutorRepository;
import com.alexandrepapas.desafioBlog.Repository.PostsRepository;
import com.alexandrepapas.desafioBlog.dtos.AutorDTO;
import com.alexandrepapas.desafioBlog.dtos.PostsDTO;
import com.alexandrepapas.desafioBlog.model.Autor;
import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor criarAutor (AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNomeAutor(autorDTO.getName());
        return autorRepository.save(autor);
    }


}