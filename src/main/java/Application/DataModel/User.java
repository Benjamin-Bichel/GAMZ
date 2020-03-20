package Application.DataModel;

import javax.persistence.*;

@Table
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private Role role;

    public User(){
        this.id = id;
    }
    public User(String name){
        this.name = name;
    }
    public User(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    public User(Integer id, String name, Role role){
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(){
        this.role = role;
    }
    public Role getRole(){
        return role;
    }
}
