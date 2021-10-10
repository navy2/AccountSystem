package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER", schema = "ACCOUNTSYSTEM")
public class Member implements Serializable {
    private static final long serialVersionUID = 624652389550473387L;
    private Long memberId;
    private String name;
    private Long accountTypeId;
    private Integer balance;
    private LocalDate creationDate;

    public Member() {
    }

    public Member(Long memberId, String name, Long accountTypeId, Integer balance, LocalDate creationDate) {
        this.memberId = memberId;
        this.name = name;
        this.accountTypeId = accountTypeId;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public Member(Long memberId, Long accountTypeId, Integer balance) {
        this.memberId = memberId;
        this.accountTypeId = accountTypeId;
        this.balance = balance;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "ACCOUNTSYSTEM.MEMBER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTSYSTEM.MEMBER_SEQ")
    @Column(name = "Member_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Account_Type_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Min(0)
    @Column(name = "Balance")
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer Balance) {
        this.balance = Balance;
    }

    @Column(name = "Creation_Date")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member that = (Member) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(name, that.name) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(balance, that.balance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, accountTypeId, balance, creationDate);
    }

    @Override
    public java.lang.String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name=" + name +
                ", accountTypeId=" + accountTypeId +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                '}';
    }
}