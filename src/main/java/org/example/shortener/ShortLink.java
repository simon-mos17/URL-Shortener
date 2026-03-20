package org.example.shortener;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalLink;
    @Column(unique = true)
    private String shortedLink;
    private LocalDateTime createTime;
    private int clickCount = 0;
    private LocalDateTime lastClickTime = null;

    public ShortLink(String originalLink, String shortedLink) {
        this.originalLink = originalLink;
        this.shortedLink = shortedLink;
    }

    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
    }

    public ShortLink() {
    }

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


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getLastClickTime() {
        return lastClickTime;
    }

    public void setLastClickTime(LocalDateTime lastClickTime) {
        this.lastClickTime = lastClickTime;
    }
}