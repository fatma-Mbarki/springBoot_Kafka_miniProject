package net.javaguides;

import net.javaguides.entity.wikimediaData;
import net.javaguides.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    public static final Logger LOGGER =LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private final WikimediaDataRepository dataRepository;
    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
    @KafkaListener(
            topics ="wikimedia_recent_change",
            groupId="myGroup"
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("event Message received -> %s", eventMessage)) ;
        wikimediaData wikimediadata = new wikimediaData();
        wikimediadata.setWikiEventData(eventMessage);

        // Save to repository
        dataRepository.save(wikimediadata);
    }
}

