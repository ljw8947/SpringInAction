package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;
import sun.security.provider.ConfigFile;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jwlv on 2017/11/7.
 */
public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception{
        SpitterController controller=new SpitterController();
        MockMvc mockMvc=standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception{
        SpitterRepository mockRepository=mock(SpitterRepository.class);

        Spitter unsaved=
                new Spitter("jbauer","24hours","Jack","Bauer");

        Spitter saved=
                new Spitter(24L,"jbauer","24hours","Jack","Bauer");

        when(mockRepository.save(unsaved)).thenReturn(saved);

        when(mockRepository.findByUsername("jbauer")).thenReturn(saved);

        SpitterController controller=
                new SpitterController(mockRepository);

        MockMvc mockMvc=standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName","Jack")
                .param("lastName","Bauer")
                .param("username","jbauer")
                .param("password","24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        //verify会调用类的equal方法进行比较，所以需要重写equals方法
        verify(mockRepository,atLeastOnce()).save(unsaved);

        mockMvc.perform(get("/spitter/jbauer"))
                .andExpect(view().name("profile"));

        verify(mockRepository,atLeastOnce()).findByUsername("jbauer");
    }
}
