import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
@Table
@Entity
public class Education {
    @Id
    private int id;
    private boolean graduated;
    private Date yaer;
    private String institution;
    private String program;
    private int grade;

}
