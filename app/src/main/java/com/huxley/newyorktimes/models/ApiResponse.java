package com.huxley.newyorktimes.models;

import java.util.ArrayList;

public class ApiResponse {

    private String status;
    private String copyright;
    private int num_results;
    private ArrayList<NewsItem> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public ArrayList<NewsItem> getResults() {
        return results;
    }

    public void setResults(ArrayList<NewsItem> results) {
        this.results = results;
    }
}
