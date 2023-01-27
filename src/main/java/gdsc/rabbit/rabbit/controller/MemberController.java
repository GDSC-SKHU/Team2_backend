package gdsc.rabbit.rabbit.controller;

import gdsc.rabbit.rabbit.domain.dto.LoginDTO;
import gdsc.rabbit.rabbit.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 메인 페이지
    @GetMapping("/")
    public ResponseEntity<String> main() {
        return ResponseEntity.ok("메인 페이지");
    }

    // 입력한 이름이 멤버로 등록되어 있는지 확인
    @PostMapping("/")
    public boolean login(@RequestBody LoginDTO loginDTO) {
        String name = loginDTO.getName();
        return memberService.login(name);
    }

    // 게임 페이지 보여주기
    @GetMapping("/game")
    public ResponseEntity<String> game() {
        return ResponseEntity.ok("게임 페이지");
    }

}
