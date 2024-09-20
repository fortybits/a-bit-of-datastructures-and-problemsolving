package org.uber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Build a reservation system for a predefined set of conference rooms given as a list of room Ids [‘roomA’, roomB’...].
 * It should have a method like scheduleMeeting(startTime, endTime) should return a reservation identifier (including roomId)
 * and reserve it or return an error if no rooms are available.
 */
public class ScheduleMeeting {

    public static void main(String[] args) {
        List<Room> rooms = List.of(new Room("a"), new Room("b"));
        ReservationService reservationService = new ReservationService(rooms);
        String reservationId = reservationService.scheduleMeeting(1726137000000L, 1726138800000L);
        System.out.println("Reservation Id: " + reservationId);
        reservationId = reservationService.scheduleMeeting(1726137000000L, 1726138800000L);
        System.out.println("Reservation Id: " + reservationId);
        System.out.println(reservationService.scheduleMeeting(1726139100000L, 1726139700000L));
        System.out.println(reservationService.scheduleMeeting(1726137000000L, 1726138800000L)); // not available
    }

    record Reservation(String id, long startTime, long endTime, String roomId, long reservationTime) {
    } // reservationTimestamp

    record Room(String id) {
    }

    static class ReservationService {
        final List<Room> rooms;
        List<Reservation> reservations;

        public ReservationService(List<Room> rooms) {
            this.rooms = rooms;
            this.reservations = new ArrayList<>();
        }

        // worst case: O(N)
        public String scheduleMeeting(long startTime, long endTime) {
            // find available rooms :
            // what all rooms are already reserved
            // not exists query
            // reserve that room (adding to the list)
            // return the reserved room

            List<String> allRoomIds = allRoomIds(); // O(N) rooms
            List<String> reservedRoomIds = findReservedRooms(startTime, endTime); // O(R)
            String bookedRoom = null;
            for (String room : allRoomIds) { // O(N)
                if (!reservedRoomIds.contains(room)) {
                    bookedRoom = room;
                    break;
                }
            }
            if (bookedRoom == null) {
                return "Error";
            }

            return reserveRoom(bookedRoom, startTime, endTime);
        }

        private String reserveRoom(String roomId, long startTime, long endTime) {
            String reservationId = String.format("%s_%s_%s", roomId, startTime, endTime);
            reservations.add(new Reservation(reservationId, startTime, endTime, roomId, System.currentTimeMillis()));
            return reservationId;
        }


        private List<String> allRoomIds() {
            return rooms.stream().map(room -> room.id).toList();
        }

        // R reservations O(R)    O <= R <= N
        private List<String> findReservedRooms(long startTime, long endTime) {
            return reservations.stream()
                    .filter(res -> (res.endTime() >= startTime && res.endTime() <= endTime)) // active
                    .map(Reservation::roomId)
                    .toList();
        }

        private List<String> lastNReservations(int N) {
            return reservations.stream()
                    .sorted(Comparator.comparingLong(Reservation::reservationTime))
                    .limit(N)
                    .map(Reservation::id)
                    .toList()
                    .reversed();
        }
    }
}