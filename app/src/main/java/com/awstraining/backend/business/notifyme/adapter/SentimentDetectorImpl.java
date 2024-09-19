package com.awstraining.backend.business.notifyme.adapter;

import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.awstraining.backend.business.notifyme.Sentiment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SentimentDetectorImpl implements Sentiment {

    private static final Logger LOGGER = LogManager.getLogger(SentimentDetectorImpl.class);
    private AmazonComprehend comprehend;

    @Autowired
    public SentimentDetectorImpl(AmazonComprehend comprehend) {
        this.comprehend = comprehend;
    }

    @Override
    public String detectSentiment(String language, String text) {
      final DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest()
              .withText(text)
              .withLanguageCode(language);
      DetectSentimentResult detectSentimentResult = comprehend.detectSentiment(detectSentimentRequest);
        return detectSentimentResult.getSentiment();
    }
}
