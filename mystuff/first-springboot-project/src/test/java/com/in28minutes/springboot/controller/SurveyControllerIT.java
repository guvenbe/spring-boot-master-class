package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.Application;
import com.in28minutes.springboot.model.Question;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.Arrays;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    private String createHttpAuthenticationHeaderValue(String userId, String password) {

        String auth =userId + ":" + password;
        byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
        String headerValue = "Basic " + new String(encodedAuth);

        return headerValue;
    }

    @Before
    public void setup(){
        headers.add("Authorization",createHttpAuthenticationHeaderValue("user1", "secret1"));
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @WithMockUser(username = "user1", password = "secret1")
    @Test
    public void retrieveAllSurveyQuestions() throws Exception {





        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<List<Question>> response = restTemplate.exchange(createUrlWithPort("/surveys/Survey1/questions"),
                HttpMethod.GET, new HttpEntity<String>("DUMMY_DOESNT_MATTER",
                        headers),
                new ParameterizedTypeReference<List<Question>>() {
                });

        Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        assertTrue(response.getBody().contains(sampleQuestion));
    }

    @WithMockUser(username = "user1", password = "secret1")
    @Test
    public void addQuestion() {


        //HttpEntity - Headers
        HttpEntity entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createUrlWithPort("/surveys/Survey1/questions/Question1")
                , HttpMethod.GET, entity, String.class);


        System.out.println("Port=" + port);
        //System.out.println("output=" + output);
        System.out.println("Response: " + response.getBody());
        assertTrue(response.getBody().contains("\"id\":\"Question1\""));
        assertTrue(response.getBody().contains("\"description\":\"Largest Country in the World\""));
        String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options:[India,Russia,United States,China]}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createUrlWithPort(String retreiveSpecificQuestion) {
        return "http://localhost:" + port + retreiveSpecificQuestion;
    }


    @WithMockUser(username = "user1", password = "secret1")
    @Test
    public void testRetrieveSurveyQuestion() {
        String url = createUrlWithPort("/surveys/Survey1/questions");


        //Accept: application/json
        //String output = restTemplate.getForObject(url, String.class);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Question question1 = new Question("DOESNOTMATTER", "Question1",
                "Russia", Arrays.asList("India", "Russia", "United States", "China"));

        //HttpEntity - Headers
        HttpEntity entity = new HttpEntity(question1, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        System.out.println("Response: " + actual);

        assertTrue(actual.contains("/surveys/Survey1/questions"));
    }

}