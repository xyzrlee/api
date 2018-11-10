package app.illl.api.struct.io.dns;

import app.illl.api.struct.io.ApiResponse;
import app.illl.api.struct.io.dns.meta.Additional;
import app.illl.api.struct.io.dns.meta.Answer;
import app.illl.api.struct.io.dns.meta.Question;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DNSResponse extends ApiResponse {

    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("TC")
    private Boolean truncatedResponse;
    @JsonProperty("RD")
    private Boolean recursionDesired;
    @JsonProperty("RA")
    private Boolean recursionAvailable;
    @JsonProperty("AD")
    private Boolean authenticData;
    @JsonProperty("CD")
    private Boolean checkingDisabled;
    @JsonProperty("Question")
    private List<Question> questions;
    @JsonProperty("Answer")
    private List<Answer> answers;
    @JsonProperty("Additional")
    private List<Additional> additionals;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean isTruncatedResponse() {
        return truncatedResponse;
    }

    public void setTruncatedResponse(Boolean truncatedResponse) {
        this.truncatedResponse = truncatedResponse;
    }

    public Boolean isRecursionDesired() {
        return recursionDesired;
    }

    public void setRecursionDesired(Boolean recursionDesired) {
        this.recursionDesired = recursionDesired;
    }

    public Boolean isRecursionAvailable() {
        return recursionAvailable;
    }

    public void setRecursionAvailable(Boolean recursionAvailable) {
        this.recursionAvailable = recursionAvailable;
    }

    public Boolean isAuthenticData() {
        return authenticData;
    }

    public void setAuthenticData(Boolean authenticData) {
        this.authenticData = authenticData;
    }

    public Boolean isCheckingDisabled() {
        return checkingDisabled;
    }

    public void setCheckingDisabled(Boolean checkingDisabled) {
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
