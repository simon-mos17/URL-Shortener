package org.example.shortener;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {
    Optional<ShortLink> findByShortedLink(String shortedLink);
    Optional<ShortLink> findByOriginalLink(String originalLink);

}
