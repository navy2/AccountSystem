package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

   @Query(value = "SELECT " +
            "a " +
            "FROM " +
            "AccountType a " +
            "WHERE a.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT "+
            "accountTypeId," +
            "accountTypeName," +
            "creationDate," +
            "mnemonic, " +
            "FROM " +
            "ACCOUNTSYSTEM.AccountType"+
            "WHERE mnemonic = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Modifying
    @Query(value = "UPDATE " +
            "AccountType a " +
            "SET " +
            "a.accountTypeName = :AccountTypeName, " +
            "a.creationDate = :creationDate " +
            "WHERE a.mnemonic = :mnemonic ")
    void updateAccountType(String mnemonic, String AccountTypeName, LocalDate creationDate);

    @Modifying
    @Query(value = "DELETE " +
            "FROM " +
            "AccountType a " +
            "WHERE a.mnemonic = :mnemonic ")
    void DeleteAccountType(String mnemonic);
}