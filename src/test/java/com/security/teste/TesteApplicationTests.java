package com.security.teste;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TesteApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(username = "user", roles = "User")
	public void testAuthorizedAccessToDashboard() throws Exception {
		mockMvc.perform(get("/get"))
				.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "admin", roles = "Admin")
	public void testUnauthorizedAccessToDashboard() throws Exception {
		mockMvc.perform(get("/get"))
				.andExpect(status().isOk());
	}

}
