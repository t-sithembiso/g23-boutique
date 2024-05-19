package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.RoomRepository;
import java.util.Optional;
import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomServiceTest {
    private RoomService roomService;
    private RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
        roomRepository = mock(RoomRepository.class);
        roomService = new RoomService(roomRepository);
    }

    @Test
    void testCreateRoom() {
        Room room = new Room();
        when(roomRepository.save(room)).thenReturn(room);

        Room createdRoom = roomService.create(room);

        assertEquals(room, createdRoom);
        verify(roomRepository, times(1)).save(room);
    }

    @Test
    void testReadRoom() {
        Long roomTypeId = 1L;
        Room room = new Room();
        when(roomRepository.findById(roomTypeId)).thenReturn(of(room))

        Room foundRoom = roomService.read(roomTypeId);

        assertEquals(room, foundRoom);
        verify(roomRepository, times(1)).findById(roomTypeId);
    }

    @Test
    void testUpdateRoom() {
        Room room = new Room();
        when(roomRepository.save(room)).thenReturn(room);

        Room updatedRoom = roomService.update(room);

        assertEquals(room, updatedRoom);
        verify(roomRepository, times(1)).save(room);
    }

}




