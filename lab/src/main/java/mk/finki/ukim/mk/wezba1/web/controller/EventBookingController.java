package mk.finki.ukim.mk.wezba1.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.wezba1.model.EventBooking;
import mk.finki.ukim.mk.wezba1.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {

    private final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    // TODO EVENTBOOKING.HTMl
    @GetMapping("/eventBooking")
    public String showEventBookingPage( Model model) {

        return "eventBooking";
    }


    // TODO POST RESERVATION


    @PostMapping("/eventBooking")
    public String booking(@RequestParam String eventName,
                          @RequestParam(required = false) Long numTickets,

                          Model model) {
        String name = "Isen Osman";
        String ipAddress = "127.0.0.1";

        EventBooking booking = null;
        try {
            booking = eventBookingService.placeBooking(eventName, name, ipAddress, numTickets);
            model.addAttribute("booking", booking);

            return "bookingConfirmation";
        } catch (IllegalArgumentException e) {

            return "redirect:/events?error=NemaDovolnoKarti" ;
        }
    }

}
