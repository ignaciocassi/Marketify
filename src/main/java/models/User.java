package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "passwd", nullable = false, unique = true)
    String passwd;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private List<Product> products;

    public User() {
    }

    public User(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
    }

    public int getId() {
        return this.userId;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            ", passwd='" + getPasswd() + "'" +
            "}";
    }
    
}
