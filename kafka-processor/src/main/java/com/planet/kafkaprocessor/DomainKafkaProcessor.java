package com.planet.kafkaprocessor;

import com.planet.kafkaprocessor.domain.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class DomainKafkaProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(DomainKafkaProcessor.class);

    @Bean
    public Function<KStream<String, Domain>, KStream<String, Domain>> domainProcessor() {

        return kstream -> kstream.filter((key, domain) -> {
            if(domain.isDead()){
                LOG.info("Inactive Domain: {}", domain.getDomain());
                return false;
            }
            else{
                LOG.info("Active Domain: {}", domain.getDomain());
                return true;
            }
            //return !domain.isDead();
        });

    }
}
