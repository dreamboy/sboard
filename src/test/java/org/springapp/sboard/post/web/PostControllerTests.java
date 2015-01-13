package org.springapp.sboard.post.web;

import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springapp.sboard.SboardApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * @author dreamboy
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SboardApplication.class)
public class PostControllerTests {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testPostList() throws Exception {
		this.mockMvc.perform(get("/post")).andExpect(status().isOk())
			.andExpect(content().string(containsString("<title>Post : list</title>")));
	}
	
	@Test
	public void testCreatePost() throws Exception {
		this.mockMvc.perform(post("/post").param("title", "title 테스트")
				.param("contents", "contents 테스트")
				.param("writer", "writer 테스트"))
				.andExpect(status().isFound())
				.andExpect(header().string("location", RegexMatcher.matches("/[0-9]+")));
				
	}
	
	private static class RegexMatcher extends TypeSafeMatcher<String> {
		private final String regex;
		
		public RegexMatcher(String regex) {
			this.regex = regex;
		}
		
		public static org.hamcrest.Matcher<java.lang.String> matches(String regex) {
			return new RegexMatcher(regex);
		}

		@Override
		protected boolean matchesSafely(String item) {
			return Pattern.compile(this.regex).matcher(item).find();
		}
		
		@Override
		public void describeTo(Description description) {
			description.appendText("a string that matches regex: ")
				.appendText(this.regex);
			
		}		
		
	}

}
