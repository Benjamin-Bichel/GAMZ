package Application.DataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {
    @Id
    @GeneratedValue()
    private int id;
    //@Index()
    private String name;
    private String role;
    private String number;
    //@Index()
    private String email;
    //@Index()
    private String url1;
    //@Index()
    private String url2;


    public User(){}
    public User(String name){
        this.name = name;
    }

    public User(String name, String role){
        this.name = name;
        this.role = role;
    }

    public Integer getId(){  return id; }

    public String getName(){  return name; }

    public void setName(String name){
        this.name = name;
    }

    public String getRole(){
        return role;
    }
}
