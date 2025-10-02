package com.freefit.freefitapp.writePost.controller;

import com.freefit.freefitapp.util.JwtUtil;
import com.freefit.freefitapp.vo.*;
import com.freefit.freefitapp.writePost.service.writePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class writePostController {

    @Autowired
    private writePostService service;

    @Autowired
    private JwtUtil jwtUtil;

    // 게시글 작성
    @PostMapping("/posts")
    @ResponseBody
    public boolean insertPost(
            @RequestPart("userId") String userId,
            @RequestPart("category") String category,
            @RequestPart("title") String title,
            @RequestPart("content") String content,
            @RequestPart(value = "isPrivate", required = false) String isPrivate,
            @RequestPart(value = "postPassword", required = false) String postPassword,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) {
        return service.insertPost(userId, category, title, content, isPrivate, postPassword, images);
    }

    @GetMapping("/postsList")
    @ResponseBody
    public List<PostVO> selectPostsList(@RequestParam(value = "category", required = false) String category) throws Exception {
        if (category == null || category.isEmpty() || category.equals("전체")) {
            return service.getAllPosts();
        } else {
            return service.getPostCategory(category);
        }
    }

    // 산책모임 등록
    @PostMapping("/walkgroups/create")
    @ResponseBody
    public boolean insertWalkGroup(
            @RequestPart("walkGroup") WalkGroupVO vo,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        return service.insertWalkGroup(vo, image);
    }

    // 모임 리스트
    @GetMapping("/walkgroups/list")
    @ResponseBody
    public List<WalkGroupVO> selectWalkGroups() throws Exception {
        return service.selectWalkGroups();
    }

    // 모임 상세
    @GetMapping("/walkgroups/{groupId}")
    @ResponseBody
    public WalkGroupVO selectWalkGroupDetail(@PathVariable("groupId") Long groupId,
                                            @RequestHeader("Authorization") String token) throws Exception {
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        WalkGroupVO vo = service.selectWalkGroupDetail(groupId);
        String role = service.getUserRoleInGroup(groupId, userId);
        vo.setRole(role);

        return vo;
    }

    // 공지사항 등록
    @PostMapping("/walkgroups/{groupId}/notice")
    @ResponseBody
    public boolean addNotice(@PathVariable("groupId") Long groupId,
                            @RequestBody WalkGroupVO vo,
                            @RequestHeader("Authorization") String token) {
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        return service.addNotice(groupId, vo.getNotice(), userId);
    }

    // 갤러리 업로드
    @PostMapping("/walkgroups/{groupId}/gallery")
    @ResponseBody
    public boolean uploadGallery(@PathVariable("groupId") Long groupId,
                                @RequestPart("images") List<MultipartFile> images,
                                @RequestHeader("Authorization") String token) {
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        return service.uploadGallery(groupId, images, userId);
    }

    // 공지사항 조회
    @GetMapping("/walkgroups/{groupId}/selectnotice")
    @ResponseBody
    public List<WalkGroupNoticeVO> selectNotices(@PathVariable("groupId") Long groupId) throws Exception{
        return service.selectNotices(groupId);
    }

    // 갤러리 조회
    @GetMapping("/walkgroups/{groupId}/selectgallery")
    @ResponseBody
    public List<WalkGroupGalleryVO> selectGallery(@PathVariable("groupId") Long groupId) throws Exception{
        return service.selectGallery(groupId);
    }

    // 게시글 상세
    @GetMapping("/posts/{postId}")
    @ResponseBody
    public PostVO selectPostDetail(@PathVariable("postId") int postId,
                                    @RequestHeader("Authorization") String token) throws Exception {
        // JWT에서 ID추출
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        PostVO post = service.getPostDetail(postId);
        // 어드민이면 비밀번호 무시
        if("ADMIN".equalsIgnoreCase(post.getRole())) {
            post.setPostPassword(null);
        }
        return post;
    }

    // 댓글 목록
    @GetMapping("/posts/{postId}/selectcomments")
    @ResponseBody
    public List<CommentVO> selectComments(@PathVariable("postId") int postId) throws Exception{
        return service.selectComments(postId);
    }

    // 댓글 등록
    @PostMapping("/posts/{postId}/insertcomment")
    @ResponseBody
    public boolean insertComment(@PathVariable("postId") int postId,
                                 @RequestBody CommentVO vo,
                                 @RequestHeader("Authorization") String token) throws Exception{
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        vo.setUserId(userId);
        vo.setPostId(postId);
        return service.insertComment(vo);
    }

    // 대댓글 등록
    @PostMapping("/posts/{postId}/insertreply")
    @ResponseBody
    public boolean insertReply(@PathVariable("postId") int postId,
                               @RequestBody CommentVO vo,
                               @RequestHeader("Authorization") String token) throws Exception{
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        vo.setPostId(postId);
        vo.setUserId(userId);
        return service.insertReply(vo);
    }

    // 좋아요 토글
    @PostMapping("/posts/{postId}/like")
    @ResponseBody
    public boolean toggleLike(@PathVariable("postId") int postId,
                              @RequestHeader("Authorization") String token) throws Exception {
        String userId = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        return service.toggleLike(postId, userId);
    }

    // 좋아요 개수
    @GetMapping("/posts/{postId}/likecount")
    @ResponseBody
    public int getLikeCount(@PathVariable("postId") int postId) throws Exception {
        return service.getLikeCount(postId);
    }

}
