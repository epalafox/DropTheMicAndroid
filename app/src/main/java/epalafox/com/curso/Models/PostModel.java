package epalafox.com.curso.Models;

import java.util.List;

/**
 * Created by epalafox on 12/08/2017.
 */

public class PostModel {
    int Id;
    String Post;
    String Date;
    String Hour;
    UserModel User;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public UserModel getUser() {
        return User;
    }

    public void setUser(UserModel user) {
        User = user;
    }

    public List<CommentModel> getComments() {
        return Comments;
    }

    public void setComments(List<CommentModel> comments) {
        Comments = comments;
    }

    List<CommentModel> Comments;

}
