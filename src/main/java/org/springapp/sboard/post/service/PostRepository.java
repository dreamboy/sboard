package org.springapp.sboard.post.service;

import org.springapp.sboard.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
