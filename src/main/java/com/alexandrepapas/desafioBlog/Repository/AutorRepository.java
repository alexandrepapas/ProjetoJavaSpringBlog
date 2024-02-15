package com.alexandrepapas.desafioBlog.Repository;

import com.alexandrepapas.desafioBlog.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
