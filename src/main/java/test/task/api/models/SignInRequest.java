package test.task.api.models;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SignInRequest {
    private String username;
    private String password;

}
