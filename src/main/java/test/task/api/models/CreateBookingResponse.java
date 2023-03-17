package test.task.api.models;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
@Jacksonized
@Data
public class CreateBookingResponse {
    private int bookingid;
    private BookingDetails booking;
}
