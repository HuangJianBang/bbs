package bbs_gradle.bbs.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private int cardId;
    private String content;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public int getCardId() {
        return cardId;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }
}
