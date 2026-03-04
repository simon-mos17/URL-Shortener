package org.example.shortener;

import jakarta.persistence.*;

@Entity
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalLink;

    @Column(unique = true)
    private String shortLink;

    public ShortLink(String originalLink, String shortLink){
        this.originalLink = originalLink;
        this.shortLink = shortLink;
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

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}