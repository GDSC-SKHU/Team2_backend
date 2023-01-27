package gdsc.rabbit.rabbit.domain.dto;

import gdsc.rabbit.rabbit.domain.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private Long id;

    private String name;

    private Rank rank;

}
