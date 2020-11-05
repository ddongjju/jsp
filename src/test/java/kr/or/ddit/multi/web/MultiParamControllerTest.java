package kr.or.ddit.multi.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;


public class MultiParamControllerTest extends WebTestConfig{
	

	@Test
	public void ViewTest() throws Exception {
//		mockMvc.perform(get("/multi/view")).andExpect(status().isOk()).andExpect(view().name("multi/view"));
		MvcResult result = mockMvc.perform(get("/multi/view")).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		assertEquals("multi/view", mav.getViewName());
	}
	
	@Test
	public void MultiParamSubmitTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/multi/submit").param("userid", "brown","sally","cony")).andDo(print()).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		assertEquals("multi/submit", mav.getViewName());
		
	}

}
