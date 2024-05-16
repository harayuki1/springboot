package com.example.sample;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WeatherReport {
    private String publishingOffice;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime reportDatetime;
    
    private String targetArea;
    private String headlineText;
    private String text;

    // コンストラクタ
    public WeatherReport() {
    }

    public WeatherReport(String publishingOffice, LocalDateTime reportDatetime, String targetArea, String headlineText, String text) {
        this.publishingOffice = publishingOffice;
        this.reportDatetime = reportDatetime;
        this.targetArea = targetArea;
        this.headlineText = headlineText;
        this.text = text;
    }

    // ゲッターとセッター
    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public LocalDateTime getReportDatetime() {
        return reportDatetime;
    }

    public void setReportDatetime(LocalDateTime reportDatetime) {
        this.reportDatetime = reportDatetime;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // toStringメソッド
    @Override
    public String toString() {
        return "WeatherReport{" +
                "publishingOffice='" + publishingOffice + '\'' +
                ", reportDatetime=" + reportDatetime +
                ", targetArea='" + targetArea + '\'' +
                ", headlineText='" + headlineText + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
