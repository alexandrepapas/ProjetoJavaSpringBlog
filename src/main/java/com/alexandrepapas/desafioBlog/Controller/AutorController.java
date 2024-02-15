package com.alexandrepapas.desafioBlog.Controller;

import com.alexandrepapas.desafioBlog.Repository.AutorRepository;
import com.alexandrepapas.desafioBlog.Service.AutorService;
import com.alexandrepapas.desafioBlog.dtos.AutorDTO;
import com.alexandrepapas.desafioBlog.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    AutorService autorService;

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody AutorDTO autorDTO) {
        Autor autor = autorService.criarAutor(autorDTO);
        return ResponseEntity.ok().body(autor);
    }


}
