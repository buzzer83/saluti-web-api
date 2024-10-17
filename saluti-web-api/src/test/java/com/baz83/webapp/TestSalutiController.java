package com.baz83.webapp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.baz83.webapp.saluti_web_api.SalutiWebApiApplication;

@SpringBootTest()
@ContextConfiguration(classes = SalutiWebApiApplication.class)
public class TestSalutiController {
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    private void setup()
    {
        mvc = MockMvcBuilders
        .webAppContextSetup(wac)
        .build();
    }

    @Test
    public void testGetSaluti() throws Exception 
	{
		mvc.perform(get("/api/saluti")
				.contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andExpect(jsonPath("$")
		 				.value("Ciao Mondo, sono il primo web servlet"))
		 		.andDo(print());
	}

    @Test
    public void testGetSalutiWithName() throws Exception {
        String nomeUtente = "Paolo";

        mvc.perform(get("/api/saluti/" + nomeUtente)
				.contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(status().isOk())
		 		.andExpect(jsonPath("$")
		 				.value(String.format("Ciao %s, sono il primo web servlet", 
                        nomeUtente)))
		 		.andDo(print());
    }
}
