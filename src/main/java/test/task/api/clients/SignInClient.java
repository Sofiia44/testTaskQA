package test.task.api.clients;

import io.restassured.response.Response;
import test.task.api.models.SignInRequest;
import test.task.api.models.SignInResponse;

public class SignInClient extends BaseClient{
    public SignInClient() {
        super();
    }

    public SignInResponse post(SignInRequest credential) {
        Response response =  prepareRequest()
                .body(credential)
                .when()
                .post(baseUrl+"/auth");
        SignInResponse singInResponse = response.as(SignInResponse.class);
        return singInResponse;
    }
}
