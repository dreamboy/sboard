package org.springapp.sboard.post.web;

import javax.validation.Valid;

import org.springapp.sboard.post.domain.Post;
import org.springapp.sboard.post.service.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Post post) {
		return "post/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Post post, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("post/form", "formErrors", result.getAllErrors());
		}
		
		post = this.postRepository.save(post);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new post");
		
		return new ModelAndView("redirect:/{post.id}", "post.id", post.getId());
	}
	
	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") Post post) {
		return new ModelAndView("post/view", "post", post);
	}

}
