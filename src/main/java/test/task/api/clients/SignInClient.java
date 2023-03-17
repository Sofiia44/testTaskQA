package test.task.api.clients;

import io.restassured.response.Response;
import test.task.api.models.PostRequest;
import test.task.api.models.PostResponse;

public class SignInClient extends BaseClient{
    public SignInClient() {
        super();
    }

    public PostResponse post(PostRequest credential) {
        Response response =  prepareRequest()
                .body(credential)
                .when()
                .post(baseUrl+"/auth");
        PostResponse singInResponse = response.as(PostResponse.class);
        return singInResponse;
    }
}
