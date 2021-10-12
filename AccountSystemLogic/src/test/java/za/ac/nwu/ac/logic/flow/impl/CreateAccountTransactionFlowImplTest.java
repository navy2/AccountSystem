package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CreateAccountTransactionFlowImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(Long.parseLong("1"), Long.parseLong("1"), 1000, LocalDate.now());
    }
}