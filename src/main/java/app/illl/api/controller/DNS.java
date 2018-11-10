package app.illl.api.controller;

import app.illl.api.exception.InternalServerErrorException;
import app.illl.api.struct.io.dns.DNSRequest;
import app.illl.api.struct.io.dns.DNSResponse;
import app.illl.api.struct.io.dns.meta.Answer;
import app.illl.api.struct.io.dns.meta.Question;
import app.illl.api.struct.io.dns.meta.RCode;
import app.illl.api.struct.io.dns.meta.RRType;
import app.illl.api.util.DNSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xbill.DNS.Record;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DNS {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = "/dns")
    public DNSResponse query(DNSRequest dnsRequest, HttpServletResponse response) {
        logger.debug("dnsRequest:{}", dnsRequest);
        DNSResponse dnsResponse = new DNSResponse();
        try {
            List<Record> recordList = DNSUtils.resolve(dnsRequest.getName(), dnsRequest.getType().getValue());
            if (null == recordList || recordList.isEmpty()) {
                dnsResponse.setStatus(RCode.NXDOMAIN);
            } else {
                dnsResponse.setStatus(RCode.NOERROR);
                dnsResponse.setTruncatedResponse(false);
                dnsResponse.setRecursionDesired(true);
                dnsResponse.setRecursionAvailable(true);
                dnsResponse.setAuthenticData(false);
                dnsResponse.setCheckingDisabled(false);
                Question question = new Question();
                question.setName(dnsRequest.getName());
                question.setType(dnsRequest.getType());
                List<Question> questionList = new ArrayList<>();
                questionList.add(question);
                dnsResponse.setQuestions(questionList);
                List<Answer> answerList = new ArrayList<>();
                for (Record record : recordList) {
                    Answer answer = new Answer();
                    answer.setName(record.getName().toString());
                    answer.setType(RRType.queryByValue(record.getType()));
                    answer.setTTL(record.getTTL());
                    answer.setData(record.rdataToString());
                    answerList.add(answer);
                }
                dnsResponse.setAnswers(answerList);
            }
        } catch (InternalServerErrorException e) {
            dnsResponse.setStatus(RCode.SERVFAIL);
        }
        logger.debug("dnsResponse:{}", dnsResponse);
        return dnsResponse;
    }

}
