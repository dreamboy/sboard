package org.springapp.sboard.post.web;

import org.springapp.sboard.post.domain.Post;
import org.springapp.sboard.post.service.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {
	
	private final PostRepository postRepository;
	
	@Autowired
	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@RequestMapping
	public ModelAndView list() {
		Iterable<Post> posts = this.postRepository.findAll();
		return new ModelAndView("post/list", "posts", posts);
	
	}

}
