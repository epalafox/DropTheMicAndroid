package epalafox.com.curso.Models;

import java.util.List;

/**
 * Created by epalafox on 12/08/2017.
 */

public class CommentModel {
    int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
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

    String Comment;
    String Date;
    String Hour;
    UserModel User;
    List<CommentModel> Comments;
}
