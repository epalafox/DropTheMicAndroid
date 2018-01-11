package epalafox.com.curso.Models;

/**
 * Created by epalafox on 12/08/2017.
 */

public class SessionModel {
    String WebToken;
    int IdUser;

    public String getWebToken() {
        return WebToken;
    }

    public void setWebToken(String webToken) {
        WebToken = webToken;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }
}
