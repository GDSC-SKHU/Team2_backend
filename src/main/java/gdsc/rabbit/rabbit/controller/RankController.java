package gdsc.rabbit.rabbit.controller;

import gdsc.rabbit.rabbit.domain.dto.RankDTO;
import gdsc.rabbit.rabbit.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static gdsc.rabbit.rabbit.service.RankService.convertString;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    // 순위 및 덕담 페이지
    @GetMapping("/rank")
    public List<RankDTO> main() {
        return rankService.rankList();
    }

    // 점수창 보여주기, 기존 점수 및 이름 전달
    @GetMapping("/score")
    public RankDTO showRank(@RequestBody RankDTO rankDTO) {
        String name = convertString(rankDTO.getName());
        return rankService.showRank(name);
    }

    // 점수 및 덕담 갱신
    @PatchMapping("/score")
    public ResponseEntity<String> updateRank(@RequestBody RankDTO rankDTO) {
        try {
            rankService.updateRank(rankDTO);
        }
        catch (Exception e) {
            return ResponseEntity.ok("실패");
        }
        return ResponseEntity.ok("성공적으로 덕담 저장");
    }

}
