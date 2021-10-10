package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.MemberTranslator;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;
    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository, AccountTransactionTranslator accountTransactionTranslator) {
        this.memberRepository = memberRepository;
        this.accountTransactionTranslator = accountTransactionTranslator;
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
    public MemberDto getMemberByIdandTypeId(Long memberId, Long AccountTypeId) {
        try {
            Member mem = memberRepository.getMember(memberId);
            return new MemberDto(mem);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
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

    @Transactional
    @Override
    public MemberDto updateMember(Long memberId, Long accountTypeId, Integer amount){
        try {
            Integer currentBalance = memberRepository.getMember(memberId).getBalance();
            Integer newBalance = currentBalance + amount;
            LocalDate date = LocalDate.now();

            AccountTransactionDto acc = new AccountTransactionDto(memberId, amount, date);
            Member mem = new Member(memberId, accountTypeId, newBalance);

            memberRepository.updateMemberBalance(memberId, accountTypeId, newBalance);
            accountTransactionTranslator.create(acc);
            return new MemberDto(mem);
        }
        catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

}