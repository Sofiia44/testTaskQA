package test.task.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.task.api.clients.SignInClient;
import test.task.api.models.PostRequest;
import test.task.api.models.PostResponse;

public class SignInTests {

    @Test
    public void successfulPost() {
        SignInClient client = new SignInClient();
        PostRequest credential = new PostRequest(
                "admin",
                "password123");
        PostResponse response = client.post(credential);
        Assert.assertNotNull(response.getToken());
        System.out.println(response.getToken());

    }
}
