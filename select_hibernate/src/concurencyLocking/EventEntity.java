package concurencyLocking;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "event_id")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "date_time")
    private OffsetDateTime dateTime;

    private Integer capacity;

    @Version
    private Integer version;

    @OneToMany(mappedBy = "event")
    private Set<TicketEntity> tickets;

    public void addTicket(TicketEntity ticket){
        ticket.setEvent(this);
        getTickets().add(ticket);
    }
}
