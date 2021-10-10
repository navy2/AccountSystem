package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT " +
            "m " +
            "FROM " +
            "Member m " +
            "WHERE m.memberId = :memberId")
    Member getMember(Long memberId);

    @Query(value = "SELECT " +
            "m " +
            "FROM " +
            "Member m " +
            "WHERE m.memberId = :memberId "+
            "AND m.accountTypeId = :accountTypeId ")
    Member getMemberByIdandTypeId(Long memberId, Long accountTypeId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE " +
            "Member m " +
            "SET " +
            "m.balance = :amount " +
            "WHERE memberId = :memberId " +
            "AND " +
            "accountTypeId = :accountTypeId")
    public void updateMemberBalance(Long memberId, Long accountTypeId, Integer amount);



}
