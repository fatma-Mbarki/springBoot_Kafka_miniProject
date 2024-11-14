package net.javaguides;
import io.micrometer.common.util.internal.logging.AbstractInternalLogger;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic () {
        return TopicBuilder.name("wikimedia_recent_change")
                            .build();
    }
}
