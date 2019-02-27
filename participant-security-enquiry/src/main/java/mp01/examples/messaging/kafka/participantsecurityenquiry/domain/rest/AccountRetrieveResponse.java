package mp01.examples.messaging.kafka.participantsecurityenquiry.domain.rest;

public class AccountRetrieveResponse {

    private int participantId;
    private String ISIN;
    private Double amount;

    public AccountRetrieveResponse(int participantId, String ISIN, Double amount) {
        this.participantId = participantId;
        this.ISIN = ISIN;
        this.amount = amount;
    }

    public AccountRetrieveResponse() {
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getISIN() {
        return ISIN;
    }

    public Double getAmount() {
        return amount;
    }
}
