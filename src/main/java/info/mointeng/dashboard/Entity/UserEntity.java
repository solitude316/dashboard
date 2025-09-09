package info.mointeng.dashboard.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

    /**
     * User login account
     */
    @Column(name = "account", length = 64, nullable = false)
    private String account;

    /**
     * User password
     */
    @Column(name = "password", length = 64, nullable = false)
    private String password;

    /**
     * User status
     */
    @Column(name = "status")
    private short status;

    public UserEntity(){
        super();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getStatus()
    {
        return status;
    }

    public void setUserStatus(short status)
    {
        this.status = status;
    }
}
