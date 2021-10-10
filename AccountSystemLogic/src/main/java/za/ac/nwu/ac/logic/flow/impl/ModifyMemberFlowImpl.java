package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("modifyMemberFlowName")
public class ModifyMemberFlowImpl implements ModifyMemberFlow {
    private final MemberTranslator translator;

    public ModifyMemberFlowImpl(MemberTranslator translator) {
        this.translator = translator;
    }

    @Transactional
    @Override
    public MemberDto updateMember(Long memberId, Long accountTypeId, Integer amount) {
        return translator.updateMember(memberId, accountTypeId, amount);
    }
}