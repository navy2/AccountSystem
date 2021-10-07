package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository membersRepository) {
        this.memberRepository = membersRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDto = new ArrayList<>();
        try {
            for (Member member : memberRepository.findAll()) {
                memberDto.add(new MemberDto((member)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return memberDto;
    }

    @Override
    public MemberDto create(MemberDto memberDto){
        try{
            Member members = memberRepository.save(memberDto.getMember());
            return new MemberDto(members);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}