package test.task.api.models;

import lombok.Data;

import java.util.List;

@Data
public class EditBookingResponse {
    private String firstname;
    private String lastame;
    private int totalprice;
    private boolean depositpaid;
    private List<BookingDates> bookingDatesList;
    private String additionalneeds;
}
