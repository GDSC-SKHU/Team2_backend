package gdsc.rabbit.rabbit.service;

import gdsc.rabbit.rabbit.domain.Rank;
import gdsc.rabbit.rabbit.domain.dto.RankDTO;
import gdsc.rabbit.rabbit.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        String name = convertString(rankDTO.getName());
        Long score = rankDTO.getScore();
        String text = convertString(rankDTO.getText());

        Rank rank = rankRepository.findByMember_Name(name).get();
        rank.setScore(score);
        rank.setText(text);
        rankRepository.save(rank);
    }

    // 유니코드에서 String으로 변환
    public static String convertString(String val) {
        // 변환할 문자를 저장할 버퍼 선언
        StringBuffer sb = new StringBuffer();
        // 글자를 하나하나 탐색한다.
        for (int i = 0; i < val.length(); i++) {
            // 조합이 \u로 시작하면 6글자를 변환한다. \uxxxx
            if ('\\' == val.charAt(i) && 'u' == val.charAt(i + 1)) {
                // 그 뒤 네글자는 유니코드의 16진수 코드이다. int형으로 바꾸어서 다시 char 타입으로 강제 변환한다.
                Character r = (char) Integer.parseInt(val.substring(i + 2, i + 6), 16);
                // 변환된 글자를 버퍼에 넣는다.
                sb.append(r);
                // for의 증가 값 1과 5를 합해 6글자를 점프
                i += 5;
            } else {
                // ascii코드면 그대로 버퍼에 넣는다.
                sb.append(val.charAt(i));
            }
        }
        // 결과 리턴
        return sb.toString();
    }

}
