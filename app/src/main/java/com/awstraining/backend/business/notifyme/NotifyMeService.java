package com.awstraining.backend.business.notifyme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.comprehend.AmazonComprehend;

@Service
public class NotifyMeService {

    private MessageSender sender;
    private Translator translator;
    private AmazonComprehend comprehend;

    @Autowired
    public NotifyMeService(MessageSender sender, Translator translator, AmazonComprehend comprehend) {
        this.sender = sender;
        this.translator = translator;
        this.comprehend = comprehend;
    }
    
    public String notifyMe(NotifyMeDO notifyMe) {
        String translatedText = translator.translate(notifyMe);
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
        return "This service is not available.";
    }
    
}
