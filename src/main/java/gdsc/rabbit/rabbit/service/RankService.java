package gdsc.rabbit.rabbit.service;

import gdsc.rabbit.rabbit.domain.Rank;
import gdsc.rabbit.rabbit.domain.dto.RankDTO;
import gdsc.rabbit.rabbit.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {

    private final RankRepository rankRepository;

    // 순위 보여주기
    public List<RankDTO> rankList() {
        List<Rank> list = rankRepository.findAll();
        list.sort(new Comparator<Rank>() {
            @Override
            public int compare(Rank o1, Rank o2) {
                Long firstScore = o1.getScore();
                Long secondScore = o2.getScore();
                LocalDateTime date1 = o1.getModifiedDate();
                LocalDateTime date2 = o2.getModifiedDate();

                if (firstScore > secondScore) {
                    return -1;
                } else if (firstScore == secondScore) {
                    if (date1.isBefore(date2)) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        return list.stream()
                .map(Rank::toDTO)
                .collect(Collectors.toList());
    }

    // 기존 점수 보여주기
    public RankDTO showRank(String name) {
        return rankRepository.findByMember_Name(name).get().toDTO();
    }

    // 점수와 덕담 갱신
    public void updateRank(RankDTO rankDTO) {
        String name = rankDTO.getName();
        Long score = rankDTO.getScore();
        String text = rankDTO.getText();

        Rank rank = rankRepository.findByMember_Name(name).get();
        rank.setScore(score);
        rank.setText(text);
        rankRepository.save(rank);
    }

}
