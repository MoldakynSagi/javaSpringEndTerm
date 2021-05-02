package kz.spring.endterm.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import kz.spring.endterm.model.MethodE;
import kz.spring.endterm.model.StatusE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class MyBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private Integer cost;
    @Enumerated(EnumType.STRING)
    private StatusE status;
    @Enumerated(EnumType.STRING)
    private MethodE methodE;
    private Date day;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "myBasket", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductStatus> productStatuses;
}
