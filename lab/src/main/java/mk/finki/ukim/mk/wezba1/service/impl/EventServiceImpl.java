package mk.finki.ukim.mk.wezba1.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.Location;
import mk.finki.ukim.mk.wezba1.model.exception.EventTextExceptions;
import mk.finki.ukim.mk.wezba1.repository.jpa.EventRepository;
import mk.finki.ukim.mk.wezba1.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.wezba1.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository inMemoryEventRepository;
    private final LocationRepository inMemoryLocationRepository;

    public EventServiceImpl(EventRepository inMemoryEventRepository, LocationRepository inMemoryLocationRepository) {
        this.inMemoryEventRepository = inMemoryEventRepository;
        this.inMemoryLocationRepository = inMemoryLocationRepository;
    }

    @Override
    public List<Event> listAll() {
        return inMemoryEventRepository.findAll();
    }



//    @Override
//    public List<Event> searchEvents(String text, long number) {
//        if ((text == null) || text.isEmpty()) {
//            throw new EventTextExceptions("Tekstot ne moze da bide prazen");
//        } else if (number <= 0 ) {
//            throw new EventTextExceptions("Poleto treba da bide pogolemo od 0");
//        }
//
//        return this.inMemoryEventRepository.findAllByLocation_Id(number);
//   }

    @Override
    public Optional<Event> findById(long id) {
        return inMemoryEventRepository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return inMemoryEventRepository.findByName(name);
    }


    @Override
    public void deleteById(long id) {
        inMemoryEventRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationid) {
       Location location = inMemoryLocationRepository.findById(locationid).orElse(null);
       Event event = new Event(name, description, popularityScore, location);
       return Optional.of(inMemoryEventRepository.save(event));
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationid) {
        Event event = inMemoryEventRepository.findById(id).orElse(null);
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);

        Location location = inMemoryLocationRepository.findById(locationid).orElse(null);
        event.setLocation(location);

        return Optional.of(inMemoryEventRepository.save(event));
    }

    @Override
    public List<Event> findAllByLocation_Id(Long locationId) {
        return this.inMemoryEventRepository.findAllByLocation_Id(locationId);
    }
}
