package test.task.api.models;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
@Data
@Jacksonized
public class BookingDetails {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingDates;
    private String additionalneeds;
}
