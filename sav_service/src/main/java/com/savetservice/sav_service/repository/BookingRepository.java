package com.savetservice.sav_service.repository;


import com.savetservice.sav_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * <p>
 * Nothing but simple JPA Repository.
 * </p>
 *
 * @author Railean Iurie
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
