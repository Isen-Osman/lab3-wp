package mk.finki.ukim.mk.wezba1.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data

@Entity
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;


    String eventName;

    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;



    @OneToOne
    Event event;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
        this.eventName = eventName;
    }
    public EventBooking() {

    }
}

