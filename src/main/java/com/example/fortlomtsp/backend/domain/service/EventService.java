package com.example.fortlomtsp.backend.domain.service;
import com.example.fortlomtsp.backend.domain.model.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
public interface EventService {
    List<Event> getAllEvents();
    Page<Event> getAllEvents(Pageable pageable);
    Event getEventById(Long eventId);
    Event createEvent(Long Artist, Event event);
    Event updateEventreleasedate(Long eventId, Date releasedDate);
    List<Event> getEventsByArtistId(Long artistId);
    ResponseEntity<?> deleteEvent(Long eventId);
    boolean existsById(Long eventId);
}
