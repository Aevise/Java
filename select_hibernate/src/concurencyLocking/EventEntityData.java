package concurencyLocking;

import java.time.OffsetDateTime;

public class EventEntityData {

    static EventEntity someEvent1(){
        return EventEntity.builder()
                .eventName("hehe")
                .capacity(5)
                .dateTime(OffsetDateTime.now());
                .build();
    }

    static EventEntity someEvent2(){
        return EventEntity.builder()
                .eventName("not hehe")
                .capacity(65)
                .dateTime(OffsetDateTime.now());
                .build();
    }
}
