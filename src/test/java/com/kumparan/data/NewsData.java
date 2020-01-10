package com.kumparan.data;

public class NewsData {
    private static String newsTitle;
    private static String keyword;

    public static String getNewsTitle() {
        return newsTitle;
    }

    public static void setNewsTitle(String newsTitle) {
        NewsData.newsTitle = newsTitle;
    }

    public static String getKeyword() {
        return keyword;
    }

    public static void setKeyword(String keyword) {
        NewsData.keyword = keyword;
    }
}
