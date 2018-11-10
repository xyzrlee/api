package app.illl.api.struct.dns.section;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    @JsonProperty("QName")
    private String questionName;
    @JsonProperty("QType")
    private Integer questionType;
    @JsonProperty("QClass")
    private Integer questionClass;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionClass() {
        return questionClass;
    }

    public void setQuestionClass(Integer questionClass) {
        this.questionClass = questionClass;
    }
}
