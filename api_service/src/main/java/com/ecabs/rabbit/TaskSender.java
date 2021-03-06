package com.ecabs.rabbit;

import com.ecabs.model.Booking;
import org.springframework.stereotype.Service;
/**
 * <p>
 * Interface service. To guarantee the users these implementation.
 * </p>
 *
 * @author Railean Iurie
 */
@Service
public interface TaskSender {
    void messageAudit(String message);

    void editBooking(Booking booking);

    void deleteBooking(Booking booking);

    void savedBooking(Booking booking);
}
