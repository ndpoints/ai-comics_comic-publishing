package com.ai.comics.model;

import java.time.LocalDateTime;

public class PublicationResponse {

    private Integer publicationId;
    private Integer comicId;
    private LocalDateTime publishedAt;
    private String status;
    private String platform;

    public Integer getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Integer publicationId) {
        this.publicationId = publicationId;
    }

    public Integer getComicId() {
        return comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "PublicationResponse{" +
                "publicationId=" + toIndentedString(publicationId) + ", " +
                "comicId=" + toIndentedString(comicId) + ", " +
                "publishedAt=" + toIndentedString(publishedAt) + ", " +
                "status='" + toIndentedString(status) + '\'' + ", " +
                "platform='" + toIndentedString(platform) + '\'' +
                '}';
    }

    private String toIndentedString(Object value) {
        if (value == null) {
            return "null";
        }
        return value.toString().replace("\n", "\n    ");
    }
}