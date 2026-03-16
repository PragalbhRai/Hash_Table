import java.util.*;

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;

    TokenBucket(int max) {
        this.tokens = max;
        this.maxTokens = max;
        this.lastRefill = System.currentTimeMillis();
    }
}

public class RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(5));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        RateLimiter rl = new RateLimiter();

        System.out.println(rl.checkRateLimit("abc"));
        System.out.println(rl.checkRateLimit("abc"));
    }
}