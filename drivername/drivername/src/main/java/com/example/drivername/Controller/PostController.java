package com.example.drivername.Controller;

import com.example.drivername.repository.PostRepo;
import com.example.drivername.model.Driver;
import com.example.drivername.repository.searchrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    searchrepo s;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Driver>getAllDriverName()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Driver>search(@PathVariable String text)
    {
        return s.searchtext(text);
    }

    @PostMapping("/post")
    public Driver adddriver(@RequestBody Driver driver){
        return repo.save(driver);
    }
}
