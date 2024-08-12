package example.review.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member; //리뷰하는 회원

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewBook> reviewBooks = new ArrayList<>();



    private LocalDate reviewDate;
}
