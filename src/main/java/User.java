import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Table
@Entity
public class User {
    @Id
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
