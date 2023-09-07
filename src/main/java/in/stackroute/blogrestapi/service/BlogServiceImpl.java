package in.stackroute.blogrestapi.service;

import in.stackroute.blogrestapi.model.Blog;
import in.stackroute.blogrestapi.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private  final BlogRepository repository;

    @Override
    public Blog create(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }


    @Override
    public Blog update(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public void deleteById(int id) {
             repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
