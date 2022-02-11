package com.kodolamacz.newsapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class News {

    private String status;
    private long totalResults;
    private List<Articles> articles;

    public News() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        articles.forEach(a -> stringBuilder.append(a.toString()));
        return stringBuilder.toString();
    }
}
