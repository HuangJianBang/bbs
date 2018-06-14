package bbs_gradle.bbs.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id                                                     // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "名字不能为空")
    @Size(min=2, max = 10)
    @Column(nullable = false, length = 10, unique = true)
    private String username;

   @NotEmpty(message = "电话不能为空")
   @Size(min=11, max = 20)
   @Column(nullable = false, unique = true)
    private String phone;

    private String password;



    protected User() {
    }

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPhone() {
        return phone;
    }

}
