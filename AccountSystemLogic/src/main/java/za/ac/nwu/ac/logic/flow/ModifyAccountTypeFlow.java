package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

public interface ModifyAccountTypeFlow {
    AccountTypeDto updateAccountType(AccountTypeDto accountType);
    AccountTypeDto deleteAccountType(String mnemonic);
}
