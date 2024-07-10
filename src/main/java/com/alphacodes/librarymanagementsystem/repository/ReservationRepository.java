package com.alphacodes.librarymanagementsystem.repository;

import com.alphacodes.librarymanagementsystem.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    // 2 find the reservations that are before a certain date
    List<Reservation> findByReservationTimeBefore(LocalDateTime dateTime);

    // find the reservation by member id and status
    @Query("SELECT r FROM Reservation r WHERE r.member.userID = ?1 AND r.status = ?2")
    Optional<Reservation> findByMemberIdAndStatus(String userId, String active);

    // custom query to find all active reservations
    @Query("SELECT r FROM Reservation r WHERE r.status = 'Active'")
    List<Reservation> findAllActiveReservations();

    // custom query to find all past reservations by user id
    @Query("SELECT r FROM Reservation r WHERE r.member.userID = :userId AND (r.status = 'Expired' OR r.status = 'Cancelled')")
    List<Reservation> findPastReservationsByUserId(String userId);
}
