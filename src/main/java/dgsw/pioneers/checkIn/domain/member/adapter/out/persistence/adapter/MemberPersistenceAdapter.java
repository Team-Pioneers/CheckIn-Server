package dgsw.pioneers.checkIn.domain.member.adapter.out.persistence.adapter;

import dgsw.pioneers.checkIn.global.annotation.PersistenceAdapter;
import dgsw.pioneers.checkIn.domain.member.adapter.out.persistence.MemberMapper;
import dgsw.pioneers.checkIn.domain.member.adapter.out.persistence.MemberRepository;
import dgsw.pioneers.checkIn.domain.member.application.domain.model.Member;
import dgsw.pioneers.checkIn.domain.member.application.port.out.CreateMemberPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements CreateMemberPort {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public void createMember(Member member) {

        memberRepository.save(memberMapper.mapToJpaEntity(member));
    }
}
