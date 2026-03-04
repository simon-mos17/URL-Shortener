package org.example.shortener;

import jakarta.persistence.*;

@Entity
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalLink;

    @Column(unique = true)
    private String shortedLink;

    public ShortLink(String originalLink, String shortedLink){
        this.originalLink = originalLink;
        this.shortedLink = shortedLink;
    }

    public ShortLink(){}

    public Long getId() {
        return id;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortedLink() {
        return shortedLink;
    }

    public void setShortedLink(String shortedLink) {
        this.shortedLink = shortedLink;
    }
}