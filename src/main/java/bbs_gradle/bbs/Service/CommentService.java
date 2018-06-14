package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment, String userName, Long cardid);
    List<Comment> showComment(Long cardid);
    void deleteComment();
}
