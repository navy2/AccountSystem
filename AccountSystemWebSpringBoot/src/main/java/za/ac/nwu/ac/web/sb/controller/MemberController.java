package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;

@RestController
@RequestMapping("member")
public class MemberController {
    private final CreateMemberFlow createMemberFlow;
    private final FetchMemberFlow fetchMemberFlow;
    private final ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public MemberController(CreateMemberFlow createMemberFlow, FetchMemberFlow fetchMemberFlow, ModifyMemberFlow modifyMemberFlow) {
        this.createMemberFlow = createMemberFlow;
        this.fetchMemberFlow = fetchMemberFlow;
        this.modifyMemberFlow = modifyMemberFlow;
    }

    @GetMapping("{memberId}/{accountTypeId}")
    @ApiOperation(value="Gets a members information given a Member ID and AccountTypeId", notes = "Gets a members information given a Member ID and AccountTypeId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account Types Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getMember(
            @ApiParam(value = "The member Id of a given member.",
                    name = "memberId",
                    type = "Long",
                    example = "001",
                    required = true)
            @PathVariable("memberId") final Long memberId,
            @ApiParam(value = "The account type id of a given account type",
                    name = "accountTypeId",
                    type = "Long",
                    example = "001",
                    required = true)
            @PathVariable("accountTypeId") final Long accountTypeId){
        MemberDto MemberAccount = fetchMemberFlow.getMemberByIdandTypeId(memberId , accountTypeId);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, MemberAccount);
        return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @PostMapping("")
    @ApiOperation(value = "Create a new member and account type")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creation Successful", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value = "Request body to create a new Member Account", required = true)
            @RequestBody MemberDto MemberAccount ){
        MemberDto MemberAccountResponse = createMemberFlow.create(MemberAccount);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, MemberAccountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{amount}")
    @ApiOperation(value = "Adds or subtracts miles from member account", notes = "Allows for the addition or subtraction of miles from member table")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Update Successful", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> updateMember(
            @ApiParam(value="Amount that will be added or subtracted from balance",
                    name="amount",
                    example = "-100 or 100",
                    required = true)
            @PathVariable("amount") final Integer amount,
            @ApiParam(value = "The member id that specifies member.",
                    name = "memberId",
                    example = "001",
                    required = true)
            @RequestParam("memberId") final Long memberId,
            @ApiParam(value = "The Account Type Id that specifies the account type that is updated.",
                    name="accountTypeId",
                    example = "1",
                    required = true)
            @RequestParam("accountTypeId") final Long accountTypeId
    ){
        MemberDto Member = modifyMemberFlow.updateMember(memberId, accountTypeId, amount);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, Member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
