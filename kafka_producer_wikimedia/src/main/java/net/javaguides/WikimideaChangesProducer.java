package net.javaguides;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimideaChangesProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimideaChangesProducer.class);
    private  KafkaTemplate<String,String> KafkaTemplate;
    //constructeure
    public WikimideaChangesProducer(KafkaTemplate<String,String>KafkaTemplate){
        this.KafkaTemplate=KafkaTemplate;
    }
    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia_recent_change";//put the name of the topic that we built in the KafkaTopic class

        //to read real time stream data from wikimedia, we use event source
        EventHandler eventHandler=new WikimediaChangesHandler(KafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }

}
