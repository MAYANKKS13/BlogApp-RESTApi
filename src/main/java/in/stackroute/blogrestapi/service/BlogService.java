package in.stackroute.blogrestapi.service;

import in.stackroute.blogrestapi.model.Blog;

import java.util.List;

public interface BlogService {

    Blog create(Blog blog);
    List<Blog> findAll();
    Blog update(Blog blog);
    void deleteById(int id);
    boolean existsById(int id);





}
