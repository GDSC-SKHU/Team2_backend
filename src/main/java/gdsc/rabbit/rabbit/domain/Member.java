package gdsc.rabbit.rabbit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "member")
    private Rank rank;
}
