package com.alexandrepapas.desafioBlog.Repository;

import com.alexandrepapas.desafioBlog.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>   {
}
