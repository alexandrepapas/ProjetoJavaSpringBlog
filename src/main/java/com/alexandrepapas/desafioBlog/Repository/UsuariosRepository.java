package com.alexandrepapas.desafioBlog.Repository;

import com.alexandrepapas.desafioBlog.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
}
