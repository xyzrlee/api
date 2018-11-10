package app.illl.api.struct.dns;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {

    @JsonProperty("ID")
    private int identifier;
    @JsonProperty("QR")
    private boolean queryResponseFlag;
    @JsonProperty("Opcode")
    private int operationCode;
    @JsonProperty("AA")
    private boolean authoritativeAnswer;
    @JsonProperty("TC")
    private boolean truncatedResponse;
    @JsonProperty("RD")
    private boolean recursionDesired;
    @JsonProperty("RA")
    private boolean recursionAvailable;
    @JsonProperty("RCode")
    private int responseCode;
    @JsonProperty("QDCount")
    private int questionCount;
    @JsonProperty("ANCount")
    private int answerRecordCount;
    @JsonProperty("NSCount")
    private int authorityRecordCount;
    @JsonProperty("ARCount")
    private int additionalRecordCount;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public boolean isQueryResponseFlag() {
        return queryResponseFlag;
    }

    public void setQueryResponseFlag(boolean queryResponseFlag) {
        this.queryResponseFlag = queryResponseFlag;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public boolean isAuthoritativeAnswer() {
        return authoritativeAnswer;
    }

    public void setAuthoritativeAnswer(boolean authoritativeAnswer) {
        this.authoritativeAnswer = authoritativeAnswer;
    }

    public boolean isTruncatedResponse() {
        return truncatedResponse;
    }

    public void setTruncatedResponse(boolean truncatedResponse) {
        this.truncatedResponse = truncatedResponse;
    }

    public boolean isRecursionDesired() {
        return recursionDesired;
    }

    public void setRecursionDesired(boolean recursionDesired) {
        this.recursionDesired = recursionDesired;
    }

    public boolean isRecursionAvailable() {
        return recursionAvailable;
    }

    public void setRecursionAvailable(boolean recursionAvailable) {
        this.recursionAvailable = recursionAvailable;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
