package app.illl.api.struct.dns;

import app.illl.api.struct.dns.section.Additional;
import app.illl.api.struct.dns.section.Answer;
import app.illl.api.struct.dns.section.Authority;
import app.illl.api.struct.dns.section.Question;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response extends Header {

    @JsonProperty("Question")
    private List<Question> questions;
    @JsonProperty("Answer")
    private List<Answer> answers;
    @JsonProperty("Authority")
    private List<Authority> authorities;
    @JsonProperty("Additional")
    private List<Additional> additionals;

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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<Additional> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(List<Additional> additionals) {
        this.additionals = additionals;
    }


}
