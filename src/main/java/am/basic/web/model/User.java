package am.basic.web.model;

import am.basic.web.repository.UserRepositoryImpl;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "test")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true, columnDefinition = "int(32) NOT NULL")
    private long id;
    private String name;
    // @Transient
    private String surname;
    private int age;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Card card;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private List<Action> list;

    public List<Action> getList() {
        return list;
    }

    public void setList(List<Action> list) {
        this.list = list;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @NotBlank
    @Size(min = 8, max = 12, message = "")
    private String password;
    private String username;
    private String code;

}

