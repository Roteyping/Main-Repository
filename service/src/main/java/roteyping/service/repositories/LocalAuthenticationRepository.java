package roteyping.service.repositories;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

public class LocalAuthenticationRepository implements AuthenticationRepository {

    @Override
    public boolean exists(String email, String password) {
        Map<String, String> accounts = of("nabinnepal@gmail.com", "test123", "surajadh@gmail.com", "test123");
        return accounts.containsKey(email) && accounts.get(email).equals(password);
    }

    @Override
    public Map<String, String> getCredentials() {
        return of("nabinnepal@gmail.com", "p@ssword", "surajadh@gmail.com", "p@ssword");
    }
}
