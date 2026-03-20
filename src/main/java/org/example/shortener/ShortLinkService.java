package org.example.shortener;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ShortLinkService {

    private final ShortLinkRepository repo;
    private static final String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ShortLinkService(ShortLinkRepository repo) {
        this.repo = repo;
    }

    public String getShortedLink(String originalLink) {

        Optional<ShortLink> optional = repo.findByOriginalLink(originalLink);

        if (optional.isPresent()) {
            return optional.get().getShortedLink();
        }
        return null;
    }

    public String getOriginalLink(String shortedLink) {

        Optional<ShortLink> optional = repo.findByShortedLink(shortedLink);

        if (optional.isPresent()) {
            ShortLink link = optional.get();
            link.setClickCount(link.getClickCount() + 1);
            link.setLastClickTime(LocalDateTime.now());
            repo.save(link);
            return link.getOriginalLink();
        }
        return null;
    }

    public ShortLink createShortLink(String originalLink) {

        Optional<ShortLink> existing = repo.findByOriginalLink(originalLink);
        if (existing.isPresent()) {
            return existing.get();
        }

        ShortLink shortLink = repo.save(new ShortLink(originalLink, null));
        long n = shortLink.getId();

        String shortedLink = "";

        while (n > 0) {
            int mod = (int) (n % 62);
            shortedLink = base62.charAt(mod) + shortedLink;
            n = n / 62;
        }

        shortLink.setShortedLink(shortedLink);

        return repo.save(shortLink); // update
    }
}
