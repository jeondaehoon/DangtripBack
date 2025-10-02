package com.freefit.freefitapp.writePost.dao;

import com.freefit.freefitapp.vo.*;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface writePostDao {
    // 게시글
    public int insertPost(PostVO vo) throws Exception;

    public int insertPostImage(PostImageVO vo) throws Exception;

    public List<PostVO> getAllPosts() throws Exception;

    public List<PostVO> getPostCategory(String category) throws Exception;
    // 산책모임
    public int insertWalkGroup(WalkGroupVO vo) throws Exception;

    public Long selectLastGroupId() throws Exception;

    public int insertGroupTag(WalkGroupTagVO tag) throws Exception;

    public int insertGroupImage(WalkGroupImageVO image) throws Exception;

    public int insertGroupMember(WalkGroupMemberVO member) throws Exception;

    public List<WalkGroupVO> selectWalkGroups() throws Exception;

    public WalkGroupVO selectWalkGroupDetail(Long groupId) throws Exception;

    public String getUserRoleInGroup(@Param("groupId") Long groupId,
                                    @Param("userId") String userId);

    public int insertNotice(@Param("groupId") Long groupId,
                        @Param("notice") String notice,
                        @Param("createdBy") String createdBy);

    public int insertGallery(@Param("groupId") Long groupId,
                        @Param("imageUrl") String imageUrl,
                        @Param("uploadedBy") String uploadedBy);

    public List<WalkGroupNoticeVO> selectNotices(@Param("groupId") Long groupId);

    public List<WalkGroupGalleryVO> selectGallery(@Param("groupId") Long groupId);

    public PostVO selectPostDetail(int postId) throws Exception;

    public List<CommentVO> selectComments(@Param("postId") int postId) throws Exception;

    public int insertComment(CommentVO vo) throws Exception;

    public int insertReply(CommentVO vo) throws  Exception;

    public int getLikeCount(@Param("postId") int postId) throws Exception;

    public Integer checkUserLiked(@Param("postId") int postId, @Param("userId") String userId);

    public int insertLike(@Param("postId") int postId, @Param("userId") String userId);

    public int deleteLike(@Param("postId") int postId, @Param("userId") String userId);
}
