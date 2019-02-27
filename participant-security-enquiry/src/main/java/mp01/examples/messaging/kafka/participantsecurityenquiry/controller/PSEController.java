package mp01.examples.messaging.kafka.participantsecurityenquiry.controller;

import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.Account;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.rest.AccountCreateRequest;
import mp01.examples.messaging.kafka.participantsecurityenquiry.domain.rest.AccountCreateResponse;
import mp01.examples.messaging.kafka.participantsecurityenquiry.repository.PSERepository;
import mp01.examples.messaging.kafka.participantsecurityenquiry.serivce.PSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pse")
public class PSEController {

    @Autowired
    private PSERepository pseRepository;

    @Autowired
    private PSEService pseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountCreateResponse> createAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        Account account = new Account(accountCreateRequest.getParticipantId(), accountCreateRequest.getIsinNumber(), accountCreateRequest.getAmount());
        Account resultAccount = pseService.createAccount(account);
        if(resultAccount == null) {return new ResponseEntity<>(HttpStatus.CONFLICT);}
        else {return new ResponseEntity<>(HttpStatus.CREATED);}
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{participantId}")
    public ResponseEntity<Account> retrieveAccount(@PathVariable("participantId") int participantId) {
        Account resultAccount = pseRepository.findAccountByParticipantId(participantId);
        if(resultAccount != null) { return new ResponseEntity<Account>(resultAccount, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;}
    }


}
