package com.awstraining.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;

@Configuration
@Component
public class TranslatorConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.accessKey:#{null}}")
    private String snsAccessKey;

    @Value("${aws.secretKey:#{null}}")
    private String snsSecretKey;

    @Bean
    AmazonTranslate configureTranslatorClient() {
        return AmazonTranslateClientBuilder.standard().build();
    }
}
