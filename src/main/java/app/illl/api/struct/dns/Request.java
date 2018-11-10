package app.illl.api.struct.dns;

import app.illl.api.struct.dns.section.Question;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Request {

    @JsonProperty("Question")
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
