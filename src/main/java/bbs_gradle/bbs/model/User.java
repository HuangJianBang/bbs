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
    @Column(nullable = false, length = 10)
    private String name;

//    @NotEmpty(message = "电话不能为空")
//    @Column(nullable = false, unique = true)
//    private String phone;

    private String password;

//    @Column(length = 200)
//    private String avater;

    protected User() {
    }

//    public User(String name, String password, String avater, String phone) {
//        this.name = name;
//        this.password = password;
//        this.avater = avater;
//        this.phone = phone;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
