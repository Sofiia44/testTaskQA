package test.task.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.task.api.clients.SignInClient;
import test.task.api.models.SignInRequest;
import test.task.api.models.SignInResponse;

public class SignInTests {

    @Test
    public void successfulPost() {
        SignInClient client = new SignInClient();
        SignInRequest credential = new SignInRequest(
                "admin",
                "password123");
        SignInResponse response = client.post(credential);
        Assert.assertNotNull(response.getToken());
        System.out.println(response.getToken());

    }
}
