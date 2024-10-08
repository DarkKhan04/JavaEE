package kz.bitlab.techorda.db;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private String comment;
    private User user;
    private News news;
    private Timestamp postDate;


    public Comment() {
    }

    public Comment(Long id, String comment, User user, News news, Timestamp postDate) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.news = news;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}
