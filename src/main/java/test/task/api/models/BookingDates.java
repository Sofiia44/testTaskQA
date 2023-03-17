package test.task.api.models;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class BookingDates {
    private String checkin;
    private String checkout;

}
