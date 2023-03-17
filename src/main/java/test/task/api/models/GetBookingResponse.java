package test.task.api.models;

import lombok.Data;

import java.util.List;

@Data
public class GetBookingResponse {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private List<BookingDates> bookingDatesList;
    private String additionalneeds;


}
