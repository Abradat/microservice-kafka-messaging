package mp01.examples.messaging.kafka.centralsecuritysettlement.controller;

import mp01.examples.messaging.kafka.centralsecuritysettlement.domain.kafka.AccountRequest;
import mp01.examples.messaging.kafka.centralsecuritysettlement.service.CSSKafkaProducerService;
import mp01.examples.messaging.kafka.centralsecuritysettlement.service.CSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/css")
public class CSSController {

    @Autowired
    private CSSService cssService;

    @Autowired
    private CSSKafkaProducerService cssKafkaProducerService;

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{participantId}")
    public ResponseEntity<Void> retrieveAccountInfo(@PathVariable("participantId") int participantId) {
        AccountRequest accountRequest = new AccountRequest(participantId);
        cssKafkaProducerService.sendMessageToPSE(accountRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
