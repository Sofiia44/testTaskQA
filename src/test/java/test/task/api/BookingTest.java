package test.task.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.task.api.clients.BookingClient;
import test.task.api.clients.SignInClient;
import test.task.api.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookingTest {
    private BookingClient client;
    private BookingDates bookingDates = new BookingDates();


    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        PostRequest credential = new PostRequest("admin", "password123");
        PostResponse responseSI = clientSI.post(credential);
        client = new BookingClient(responseSI.getToken());
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");

    }

    @Test
    public void successfulCreatedBooking() {
        CreateBookingRequest requestBody = new CreateBookingRequest(
                "Jim",
                "Brown",
                111,
                true,
                bookingDates,
                "Breakfast");
        CreateBookingResponse response = client.successPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getBookingid(), requestBody);
        softAssert.assertEquals(response.getBooking(), requestBody);
        softAssert.assertAll();

    }


    @Test
    public void updateBookingData() {
        EditBookingRequest requestBody = new EditBookingRequest(
                "Jim",
                "Brown",
                111,
                true,
                "2018-01-01",
                "2019-01-01",
                "Breakfast"
        );
        EditBookingResponse response = client.successfulPut(requestBody, 8882);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getTotalprice(), 123);
        softAssert.assertEquals(response.getFirstname(), "Roman");
        softAssert.assertAll();


    }


}
