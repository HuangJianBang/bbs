package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Comment;

public interface CommentService {
    void addComment(Comment comment);
    void showComment();
    void deleteComment();
}
