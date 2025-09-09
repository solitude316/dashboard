package info.mointeng.dashboard.Entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * 建立時間
     */
    @CreatedDate
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    /**
     * 建立人
     */
    @CreatedBy
    @Column(name = "create_user")
    private String createUser;

    /**
     * 最後修改時間
     */
    @LastModifiedDate
    @Column(name = "updated_at")
    protected ZonedDateTime updatedAt;

    /**
     * 最後修改人
     */
    @LastModifiedBy
    @Column(name = "update_user")
    protected String updateUser;

    public BaseEntity() {
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }

    public UUID getId() { 
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setcreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
