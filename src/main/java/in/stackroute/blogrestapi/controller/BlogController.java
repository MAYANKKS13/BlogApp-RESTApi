package in.stackroute.blogrestapi.controller;


import in.stackroute.blogrestapi.model.Blog;
import in.stackroute.blogrestapi.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;


    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog)
    {
        var blogs = blogService.create(blog);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(blogs);
    }




    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs()
    {
        var blogs = blogService.findAll();
        if(blogs.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(blogs);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int id)
    {
        if(!blogService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }
        blogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog)
    {
        if(!blogService.existsById(id))
        {
            return ResponseEntity.notFound().build();
        }

        blog.setBlogId(id);
        var updatedBlog = blogService.update(blog);
        return ResponseEntity.ok(updatedBlog);

    }



}
