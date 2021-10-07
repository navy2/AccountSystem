package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMembersFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow {

    private final MemberTranslator membersTranslator;

    public CreateMemberFlowImpl(MemberTranslator memberTranslator) {
        this.membersTranslator = memberTranslator;
    }

    @Override
    public MemberDto create(MemberDto member) {
        return membersTranslator.create(member);
    }
}
