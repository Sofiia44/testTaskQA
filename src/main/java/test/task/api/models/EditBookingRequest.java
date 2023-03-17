package test.task.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class EditBookingRequest {
    private String firstname;
    private String lastame;
    private int totalprice;
    private boolean depositpaid;
    private String checkin;
    private String checkout;
//    private List<BookingDates> bookingDatesList;
    private String additionalneeds;


}
