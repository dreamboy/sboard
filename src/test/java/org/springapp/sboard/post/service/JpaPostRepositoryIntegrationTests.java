package org.springapp.sboard.post.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springapp.sboard.SboardApplication;
import org.springapp.sboard.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SboardApplication.class)
public class JpaPostRepositoryIntegrationTests {
	
	@Autowired
	PostRepository repository;
	
	@Test
	public void writePost() {
		
		Post post = new Post();
		Post getPost = new Post();
		
		post.setTitle("제목 신규");
		post.setContents("내용 신규");
		post.setWriter("글쓴이 신규");
		
		this.repository.save(post);
		
		getPost = this.repository.findOne(post.getId());
		
		assertEquals(post.getTitle(), getPost.getTitle());
		
	}

}
