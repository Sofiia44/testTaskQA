package test.task.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.task.api.models.*;

import static java.lang.String.format;

public class BookingClient extends BaseClient {
    private String token;

    public BookingClient() {
        super();
    }

    public BookingClient(String token) {
        super();
        this.token = token;
    }

    public CreateBookingResponse successPost(CreateBookingRequest request) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request.toString())
                .when()
                .post(baseUrl + "/booking")
                .as(CreateBookingResponse.class);
    }

    public Response getById(int bookingId){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/booking/" + bookingId);
    }

    public EditBookingResponse successfulPut(EditBookingRequest request, int bookingId){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/booking/" + bookingId)
                .as(EditBookingResponse.class);
    }

    public Response delete(int bookingId) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/booking/" +bookingId );
    }
}
