package com.alexandrepapas.desafioBlog.Repository;

import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>   {
    List<Posts> findByAutorId(Long userId, Sort sort);
}
