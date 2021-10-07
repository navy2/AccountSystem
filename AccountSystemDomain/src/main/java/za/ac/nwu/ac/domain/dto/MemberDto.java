package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "Member", description = "This DTO represents the Member")
public class MemberDto implements Serializable {

    private Long memberId;
    private String name;
    private Long accountTypeId;
    private Integer balance;
    private LocalDate creationDate;

    public MemberDto() {
    }

    public MemberDto(Long memberID, String name, Long accountTypeID, Integer balance, LocalDate creationDate) {
        this.memberId = memberID;
        this.name = name;
        this.accountTypeId = accountTypeID;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public MemberDto(Member Member){
        this.memberId = Member.getMemberId();
        this.name = Member.getName();
        this.accountTypeId = Member.getAccountTypeId();
        this.balance = Member.getBalance();
        this.creationDate = Member.getCreationDate();
    }

    @ApiModelProperty(
            position = 1,
            value = "Member MemberId",
            name = "MemberId",
            notes = "Unique ID of account member",
            dataType = "java.lang.Long",
            example ="001",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 2,
            value = "Member Name",
            name = "Name",
            notes = "The name of the member",
            dataType = "java.lang.String",
            example ="John",
            required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(
            position = 3,
            value = "Member AccountType",
            name = "AccountTypeId",
            notes = "Account Type of the member",
            dataType = "java.lang.String",
            example = "a",
            required = true
    )
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(
            position = 4,
            value = "Member balance",
            name = "balance",
            notes = "Contains the balance that a user holds",
            dataType = "java.lang.Integer",
            example = "42069",
            required = true
    )
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @ApiModelProperty(
            position = 5,
            value = "Member CreationDate",
            name = "The date of member creation",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )
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
        MemberDto that = (MemberDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(balance, that.balance) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountTypeId, balance, creationDate);
    }

    @JsonIgnore
    public Member getMember(){
        return new Member(getMemberId(), getName(), getAccountTypeId(), getBalance(), getCreationDate());
    }

    @Override
    public java.lang.String toString() {
        return "MemberDto{" +
                "memberID=" + memberId +
                ", name=" + name +
                ", accountTypeID=" + accountTypeId +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                '}';
    }
}