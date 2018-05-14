package com.example.android.news;

/**
 * {@link News} object contains information related to a single news.
 */

public class News {

    /** Section of the news */
    private String mSection;

    /** Title of the news */
    private String mTitle;

    /** Date of the news */
    private String mDateTime;


    /** Author of the news */
    private String mAuthor;

    /** Website URL of the news */
    private String mUrl;


    /**
     * Construct a new (@link News) object.
     * @param section is the section of the news
     * @param title is the title of the news
     * @param dateTime is the time in milliseconds (from the Epoch) when the
     * news happened
     * @param author is the author of the news
     * @param url is the website URL to find more details about the news
     */

    public News(String section, String title, String dateTime, String author, String url) {
        mSection = section;
        mTitle = title;
        mDateTime = dateTime;
        mAuthor = author;
        mUrl = url;

    }

    /*
    ** Returns section of the news
    */

    public String getSection() { return mSection; }


    /*
    ** Returns title of the news
    */

    public String getTitle () { return mTitle; }


    /*
    ** Returns the time of the news.
    */

    public String getDateTime() { return mDateTime; }



    /*
    ** Returns the author of the news.
    */

    public String getAuthor () { return mAuthor; }


    /**
     * Returns the website URL to find the newest news.
     */
    public String getUrl() {return mUrl; }


}
