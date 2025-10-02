package com.freefit.freefitapp.writePost.service;

import com.freefit.freefitapp.vo.*;
import com.freefit.freefitapp.writePost.dao.writePostDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class writePostService {

    @Autowired
    writePostDao dao;

    //게시글
    public boolean insertPost(String userId, String category, String title, String content,
                              String isPrivate, String postPassword, List<MultipartFile> images) {
        try {
            PostVO post = new PostVO();
            post.setUserId(userId);
            post.setCategory(category);
            post.setTitle(title);
            post.setContent(content);
            post.setIsPrivate(isPrivate);
            post.setPostPassword(postPassword);

            dao.insertPost(post);
            int newPostId = post.getPostId();

            if (images != null && !images.isEmpty()) {
                for (MultipartFile file : images) {
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    Path savePath = Paths.get("C:/Dog/images/" + fileName);
                    Files.createDirectories(savePath.getParent());
                    Files.write(savePath, file.getBytes());

                    PostImageVO img = new PostImageVO();
                    img.setPostId(newPostId);
                    img.setImageUrl(fileName);

                    dao.insertPostImage(img);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PostVO> getAllPosts() throws Exception {
        return dao.getAllPosts();
    }

    public List<PostVO> getPostCategory(String category) throws Exception {
        return dao.getPostCategory(category);
    }

    //산책모임
    public boolean insertWalkGroup(WalkGroupVO vo, MultipartFile image) {
        try {
            if (image != null && !image.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path savePath = Paths.get("C:/Dog/images/" + fileName);
                Files.createDirectories(savePath.getParent());
                Files.write(savePath, image.getBytes());
                vo.setImageUrl(fileName);
            }

            dao.insertWalkGroup(vo);
            Long newGroupId = dao.selectLastGroupId();
            vo.setGroupId(newGroupId);

            if (vo.getTags() != null) {
                for (WalkGroupTagVO tag : vo.getTags()) {
                    tag.setGroupId(newGroupId);
                    tag.setIconName(mapIcon(tag.getTagName()));
                    dao.insertGroupTag(tag);
                }
            }

            if (image != null && !image.isEmpty()) {
                WalkGroupImageVO img = new WalkGroupImageVO();
                img.setGroupId(newGroupId);
                img.setImageUrl(vo.getImageUrl());
                dao.insertGroupImage(img);
            }

            WalkGroupMemberVO member = new WalkGroupMemberVO();
            member.setGroupId(newGroupId);
            member.setUserId(vo.getCreatorId());
            member.setRole("LEADER");
            dao.insertGroupMember(member);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String mapIcon(String tagName) {
        if (tagName == null) return "ellipse-outline";

        switch (tagName) {
            case "소형견만 가능": return "paw-outline";
            case "대형견만 가능": return "paw-outline";
            case "소심이": return "alert-circle-outline";
            case "활발": return "flash-outline";
            case "초보 보호자": return "happy-outline";
            case "베테랑 보호자": return "school-outline";
            case "아침 산책": return "sunny-outline";
            case "저녁 산책": return "moon-outline";
            case "주말 모임": return "calendar-outline";
            case "실내 가능": return "home-outline";
            case "첫만남 환영": return "hand-left-outline";
            case "정기 모임": return "repeat-outline";
            case "무료": return "pricetag-outline";
            case "유료": return "cash-outline";
            case "근처 동네": return "map-outline";
            default: return "ellipse-outline";
        }
    }

    public List<WalkGroupVO> selectWalkGroups() throws Exception {
        return dao.selectWalkGroups();
    }

    public WalkGroupVO selectWalkGroupDetail(Long groupId) throws Exception {
        return dao.selectWalkGroupDetail(groupId);
    }

    public String getUserRoleInGroup(Long groupId, String userId) {
        return dao.getUserRoleInGroup(groupId, userId);
    }

    public boolean addNotice(Long groupId, String notice, String createdBy) {
        dao.insertNotice(groupId, notice, createdBy);
        return true;
    }

    public boolean uploadGallery(Long groupId, List<MultipartFile> images, String uploadedBy) {
        try {
            for (MultipartFile img : images) {
                String fileName = System.currentTimeMillis() + "_" + img.getOriginalFilename();
                Path savePath = Paths.get("C:/Dog/images/" + fileName);
                Files.createDirectories(savePath.getParent());
                Files.write(savePath, img.getBytes());

                dao.insertGallery(groupId, fileName, uploadedBy);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<WalkGroupNoticeVO> selectNotices(Long groupId) throws Exception {
        return dao.selectNotices(groupId);
    }

    public List<WalkGroupGalleryVO> selectGallery(Long groupId) throws Exception {
        return dao.selectGallery(groupId);
    }

    public PostVO getPostDetail(int postId) throws Exception {
        return dao.selectPostDetail(postId);
    }

    public List<CommentVO> selectComments(int postId) throws Exception {
        List<CommentVO> allComments = dao.selectComments(postId);

        Map<Integer, CommentVO> commentMap = new HashMap<>();
        List<CommentVO> roots = new ArrayList<>();

        for (CommentVO c : allComments) {
            c.setReplies(new ArrayList<>());
            commentMap.put(c.getCommentId(), c);
        }

        for (CommentVO c : allComments) {
            if (c.getParentId() == null) {
                roots.add(c);
            } else {
                CommentVO parent = commentMap.get(c.getParentId());
                if (parent != null) {
                    parent.getReplies().add(c);
                } else {
                    roots.add(c);
                }
            }
        }
        return roots;
    }


    public boolean insertComment(CommentVO vo) throws Exception {
        try {
            dao.insertComment(vo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertReply(CommentVO vo) throws Exception {
        try {
            dao.insertReply(vo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLikeCount(int postId) throws Exception {
        return dao.getLikeCount(postId);
    }

    @Transactional
    public boolean toggleLike(int postId, String userId) {
        Integer liked = dao.checkUserLiked(postId, userId);
        if (liked != null && liked > 0) {
            int rows = dao.deleteLike(postId, userId);
            return false;
        } else {
            int rows = dao.insertLike(postId, userId);
            return true;
        }
    }
}