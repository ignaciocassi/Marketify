package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    int id;
    String email;
    String passwd;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    
}
