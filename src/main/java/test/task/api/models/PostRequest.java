package test.task.api.models;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PostRequest {
    private String username;
    private String password;

}
