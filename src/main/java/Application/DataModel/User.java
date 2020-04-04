package Application.DataModel;

import javax.persistence.*;


@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank(message = "Name is mandatory")
    @Column
    private String name;
    @Column
    private String email;

    public User(){
    }

    public User(String name, String email){
        this.name = name;
        this.email = email;

    }


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" + "id=" + getId() + ", name=" + name + ", email=" + getEmail() + '}';
    }


}
