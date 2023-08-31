package com.example.fortlomtsp.backend.api;

import com.example.fortlomtsp.backend.domain.model.entity.ForumComment;
import com.example.fortlomtsp.backend.domain.service.ForumCommentService;
import com.example.fortlomtsp.backend.mapping.ForumCommentMapper;
import com.example.fortlomtsp.backend.resource.ForumComment.CreateForumCommentResource;
import com.example.fortlomtsp.backend.resource.ForumComment.ForumCommentResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/answerservice")
public class ForumCommentController {

    @Autowired
    private ForumCommentService forumCommentService;

    @Autowired
    private ForumCommentMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/forumcomments")
    public Page<ForumCommentResource> getAllForumComments(Pageable pageable) {
        return mapper.modelListToPage(forumCommentService.getAll(), pageable);
    }
    @GetMapping("forumcomments/{forumcommentId}")
    public ResponseEntity<ForumCommentResource> getForumCommentById(@PathVariable Long forumcommentId) {

        return ResponseEntity.ok(mapper.toResource(forumCommentService.getById(forumcommentId)));

    }
    @PostMapping("user/{usersId}/forums/{forumId}/forumcomments")
    public ResponseEntity<ForumCommentResource> createForum(@PathVariable Long usersId,@PathVariable Long forumId,@RequestBody CreateForumCommentResource request) {
        ForumComment forumComment = mapping.map(request, ForumComment.class);
        return ResponseEntity.ok(mapping.map(forumCommentService.create(usersId, forumId,forumComment), ForumCommentResource.class));
    }
    @GetMapping("forums/{forumId}/forumcomments")
    public ResponseEntity<Page<ForumCommentResource>> getForumCommentByForumId(@PathVariable Long forumId,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(forumCommentService.getForumCommentByForumId(forumId), pageable));
    }
    @DeleteMapping("/forumcomments/{forumcommentId}")
    public ResponseEntity<?> delete(@PathVariable Long forumcommentId) {
        return forumCommentService.delete(forumcommentId);
    }
}
