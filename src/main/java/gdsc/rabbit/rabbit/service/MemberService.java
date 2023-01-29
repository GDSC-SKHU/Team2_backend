package gdsc.rabbit.rabbit.service;

import gdsc.rabbit.rabbit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 로그인이 가능한지, 멤버로 DB에 있는지 확인
    public boolean login(String name) {
        return memberRepository.findByName(name).isPresent();
    }

}
