package roteyping.service.repositories;

import java.util.Map;

public interface AuthenticationRepository {
    boolean exists(String email, String password);
    Map<String, String> getCredentials();
}
