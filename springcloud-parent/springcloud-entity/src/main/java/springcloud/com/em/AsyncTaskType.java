package springcloud.com.em;

public enum AsyncTaskType {

	SEND_MAIL("SEND_MAIL"), SEND_SMS("SEND_SMS"), SEND_WEIXIN("SEND_WEIXIN"),BANK_AGENT_PAY("BANK_AGENT_PAY");

    private final String value;

    private AsyncTaskType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
