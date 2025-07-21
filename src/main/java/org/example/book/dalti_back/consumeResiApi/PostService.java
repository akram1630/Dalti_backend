package org.example.book.dalti_back.consumeResiApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    String BASE_POST_URL = "https://jsonplaceholder.typicode.com/posts";

    public PostDto getPostByid(Long id){
        RestTemplate restTemplate = new RestTemplate();
        //getForEntity == response entity , the object Repsonse Type i put the PostDto
        ResponseEntity<PostDto> result = restTemplate.getForEntity(BASE_POST_URL+"/"+id,PostDto.class);
        return result.getBody();
    }
    public List<PostDto> getAllPosts(){
        // i addede it
        LocalDateTime start = LocalDateTime.now() ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> result = restTemplate.getForEntity(BASE_POST_URL,List.class);

        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("\n\n--------------------- Execution time in millis = " + duration.toMillis());

        return result.getBody();
    }


    public PostDto addPost(PostDto dto){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept","application/json");
        headers.add("accept-language","ar");
        HttpEntity<PostDto> request = new HttpEntity<>(dto,headers);
        ResponseEntity<PostDto> result = restTemplate.postForEntity(BASE_POST_URL,request,PostDto.class);
        return result.getBody();
    }

    public void updatePost(PostDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PostDto> request = new HttpEntity<>(dto);
        restTemplate.put(BASE_POST_URL,request);
    }

    public void deletePostById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_POST_URL+"/"+id);
    }

}
