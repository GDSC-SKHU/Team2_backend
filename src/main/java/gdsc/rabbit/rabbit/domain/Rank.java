package gdsc.rabbit.rabbit.domain;

import gdsc.rabbit.rabbit.domain.dto.RankDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Table(name = "ranks")
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rank extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;

    @Column
    private Long score;

    @Column
    private String text;

    @OneToOne
    @JoinColumn(name = "member_name")
    private Member member;

    public RankDTO toDTO() {
        return RankDTO.builder()
                .id(id)
                .name(member.getName())
                .score(score)
                .text(text)
                .build();
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public void setText(String text) {
        this.text = text;
    }
}
