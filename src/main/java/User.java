import javax.persistence.*;

@Table
@Entity
public class User {
    @Id
    @GeneratedValue()
    private int id;
    @Index()
    private String name;

    private String number;
    @Index()
    private String email;
    @Index()
    private String url1;
    @Index()
    private String url2;
}
