package mp01.examples.messaging.kafka.participantsecurityenquiry.domain.kafka;

public class AccountResponse {

    private int participantId;
    private String ISIN;
    private Double amount;

    public AccountResponse(int participantId, String ISIN, Double amount) {
        this.participantId = participantId;
        this.ISIN = ISIN;
        this.amount = amount;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "participantId=" + participantId +
                ", ISIN='" + ISIN + '\'' +
                ", amount=" + amount +
                '}';
    }
}
