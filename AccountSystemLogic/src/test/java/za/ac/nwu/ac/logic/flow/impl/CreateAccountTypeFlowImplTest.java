package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CreateAccountTypeFlowImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mem","string", LocalDate.now());
    }
}