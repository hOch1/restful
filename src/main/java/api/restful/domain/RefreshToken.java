package api.restful.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "jwtToken",
        timeToLive = 1000 * 60 * 60 * 24 * 7 ) // 1주일
@AllArgsConstructor
@Getter
public class RefreshToken {

    @Id
    private String email;
    private String refreshToken;

    @Indexed
    private String accessToken;
}
