package com.planet.kafkaconsumer;

import com.planet.kafkaconsumer.domain.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(DomainKafkaConsumer.class);

    @Bean
    public Consumer<KStream<String, Domain>> domainService(){
        return kstream -> kstream.foreach((key, domain) -> {
            LOG.info("Domain consumed {} Status {}", domain.getDomain(), domain.isDead());
        });
    }
}
