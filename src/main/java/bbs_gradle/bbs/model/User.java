package bbs_gradle.bbs.model;

import org.springframework.beans.factory.annotation.Value;

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

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String avaterUrl = "http://sshpark.oss-cn-shenzhen.aliyuncs.com/12326324,2560,1600.jpg";



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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected User() {
    }

    public String getAvaterUrl() {
        return avaterUrl;
    }

    public void setAvaterUrl(String avaterUrl) {
        this.avaterUrl = avaterUrl;
    }

}
