package com.thoughtworks.springrest.controller;

import com.thoughtworks.springrest.model.JobPost;
import com.thoughtworks.springrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllPosts() {
        return service.getAllJobPosts();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId) {
        return service.getPost(postId);
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

    @PostMapping("jobPost")
    public JobPost addJobPost(@RequestBody JobPost jobPost) {
        return service.addJobPost(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost) {
        return service.updateJobPost(jobPost);
    }

    @DeleteMapping("jobPost/{postId}")
    public JobPost deleteJobPost(@PathVariable("postId") int postId) {
        return service.deleteJobPost(postId);
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "loaded";
    }
}
