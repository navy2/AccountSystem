package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Test;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CreateMemberFlowImplTest {

    @Test
    public void create() {
        MemberDto MemberDto = new MemberDto(Long.parseLong("1"),"string",Long.parseLong("1"), 1,LocalDate.now());
    }
}