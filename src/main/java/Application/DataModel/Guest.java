package Application.DataModel;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
public class Guest extends User {
    private Role role;

    public Guest(){
        super();
        this.role = Role.GUEST;
    }
}
