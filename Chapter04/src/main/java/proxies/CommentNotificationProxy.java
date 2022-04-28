package proxies;

import entities.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
