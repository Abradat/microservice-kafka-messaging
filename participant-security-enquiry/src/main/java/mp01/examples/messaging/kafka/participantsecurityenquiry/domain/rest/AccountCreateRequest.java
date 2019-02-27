package mp01.examples.messaging.kafka.participantsecurityenquiry.domain.rest;

public class AccountCreateRequest {

    private int participantId;
    private String isinNumber;
    private Double amount;

    public AccountCreateRequest(int participantId, String isinNumber, Double amount) {
        this.participantId = participantId;
        this.isinNumber = isinNumber;
        this.amount = amount;
    }

    public AccountCreateRequest() {
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getIsinNumber() {
        return isinNumber;
    }

    public Double getAmount() {
        return amount;
    }
}
