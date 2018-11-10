package app.illl.api.struct.io.dns;

import app.illl.api.struct.dns.section.Additional;
import app.illl.api.struct.dns.section.Answer;
import app.illl.api.struct.dns.section.Question;
import app.illl.api.struct.io.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DNSResponse extends ApiResponse {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("TC")
    private boolean truncatedResponse;
    @JsonProperty("RD")
    private boolean recursionDesired;
    @JsonProperty("RA")
    private boolean recursionAvailable;
    @JsonProperty("AD")
    private boolean authenticData;
    @JsonProperty("CD")
    private boolean checkingDisabled;
    @JsonProperty("Question")
    private List<Question> questions;
    @JsonProperty("Answer")
    private List<Answer> answers;
    @JsonProperty("Additional")
    private List<Additional> additionals;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isAuthenticData() {
        return authenticData;
    }

    public void setAuthenticData(boolean authenticData) {
        this.authenticData = authenticData;
    }

    public boolean isCheckingDisabled() {
        return checkingDisabled;
    }

    public void setCheckingDisabled(boolean checkingDisabled) {
        this.checkingDisabled = checkingDisabled;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Additional> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(List<Additional> additionals) {
        this.additionals = additionals;
    }

}
