package org.example.book.dalti_back.consumeResiApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok( postService.getPostByid(id) );
    }


    @GetMapping()
    ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok( postService.getAllPosts() );
    }

    @PostMapping()
    ResponseEntity<?> addPost(@RequestBody PostDto postDto) { //ROW+JSON
        return ResponseEntity.ok( postService.addPost(postDto) );
    }

}
