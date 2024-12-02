package mk.finki.ukim.mk.wezba1.boostrap;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> eventList = new ArrayList<>(10);
    public static List<Location> locationList = new ArrayList<>(10);


    //treba za sekoj event da ima broj na karti naprimer 90 i koga kje napravam bookingConfriamtion so 4 karti da se namali 86
    @PostConstruct
    public void init(){
//        Location location = new Location("USA","Los Angeles","30","Description for USA");
//        Location location2 = new Location("Russia","s","330","Description for Russia");
//        Location locatio3 = new Location("Japan","Japan","44","Description for Japan");
//
//        locationList.add(location);
//        locationList.add(location2);
//        locationList.add(locatio3);
//
//        eventList.add(new Event("Theater Play", "A night of drama and performances", 5,location));
//        eventList.add(new Event("Yoga Retreat", "A relaxing weekend retreat", 65,location2));
//        eventList.add(new Event("Charity Gala", "A gala dinner for charity", 54,locatio3));
//        eventList.add(new Event("Isen Movie","Night",12,location,55));
    }
}
