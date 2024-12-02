package mk.finki.ukim.mk.wezba1.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventBooking {

    String eventName;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;

}

