package com.atoz_develop.springdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*Post post = new Post();
        post.setTitle("김밥 후기");

        Comment comment1 = new Comment();
        comment1.setComment("거기 노맛");

        post.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setComment("맛있는데 왜그래요");

        post.addComment(comment2);*/
        Session session = entityManager.unwrap(Session.class);  // org.hibernate.Session

//        session.save(post);

        Post getPost = session.get(Post.class, 1l);
//        session.delete(post);
        System.out.println("=============================");
        System.out.println(getPost.getTitle());

        /*Comment comment = session.get(Comment.class, 2l);
        System.out.println("=============================");
        System.out.println(comment.getComment());
        System.out.println(comment.getPost().getTitle());*/

        getPost.getComments().forEach(c -> {
            System.out.println("----------------");
            System.out.println(c.getComment());
        });
    }
}
