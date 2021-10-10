package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface MemberTranslator {
    List<MemberDto> getAllMembers();

    MemberDto create(MemberDto member);
    public MemberDto getMemberByIdandTypeId(Long memberId, Long AccountTypeId);

    public MemberDto updateMember(Long memberId, Long AccountTypeId, Integer amount);
}
