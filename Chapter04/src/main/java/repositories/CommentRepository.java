package repositories;

import entities.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
