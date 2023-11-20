package concurencyLocking;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventRepository {

    void deleteAll(){
        try(Session session = HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaDelete<TicketEntity> deleteTicket = criteriaBuilder.createCriteriaDelete(TicketEntity.class);
            deleteTicket.from(TicketEntity.class);
            session.createMutationQuery(deleteTicket).executeUpdate();

            CriteriaDelete<EventEntity> deleteEvent = criteriaBuilder.createCriteriaDelete(EventEntity.class);
            deleteEvent.from(EventEntity.class);
            session.createMutationQuery(deleteEvent).executeUpdate();

            session.getTransaction().commit();
        }
    }

    EventEntity createEmptyEvent(EventEntity event){
        try(Session session = HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(event);
            session.getTransaction().commit();
            return event;
        }
    }

    void saveNewTicket(String firstName, String lastName, Long eventId){
        try(Session session = HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            EventEntity eventEntity = session.find(EventEntity.class, eventId);
//            session.lock(eventEntity, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            Map<String, Object> properties = new HashMap<>();
            properties.put("javax.persistence.lock.timeout", 10000L);
            session.lock(eventEntity, LockModeType.PESSIMISTIC_WRITE, properties);
            if(eventEntity.getCapacity() <= eventEntity.getTicket().size()){
                throw new RuntimeException("Capacity exceeded");
            }
            TicketEntity ticketEntity = TicketEntity.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
            eventEntity.addTicket(ticketEntity);
            session.persist(ticketEntity);

            session.getTransaction().commit();
        }

    }
    void changeDateTime(OffsetDateTime newDateTime, Long eventId){
        try(Session session = HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            EventEntity eventEntity = session.find(EventEntity.class, eventId);
            eventEntity.setDateTime(newDateTime);

            session.getTransaction().commit();
        }
    }
}
