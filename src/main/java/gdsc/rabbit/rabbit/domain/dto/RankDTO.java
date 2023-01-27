package gdsc.rabbit.rabbit.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RankDTO {

    private Long id;

    private String name;

    private Long score;

    private String text;

}