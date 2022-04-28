package main;

import config.ProjectConfig;
import entities.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo Comment");
        comment.setAuthor("Fosi");

        service.publishComment(comment);
    }
}
