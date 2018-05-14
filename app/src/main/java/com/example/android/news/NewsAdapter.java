package com.example.android.news;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * An (@LinkNewsAdapter) knows how to create a list item layout for each news
 * in the data source (a list of (@Link News) objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {


    /**
     * The part of the date string from the Guardian that we use to determine
     * date and time of the news.
     */

    private static final String DATE_SEPARATOR = "T";
    private static final String TIME_SEPARATOR = "Z";


    /**
     * Construct a new (@Link NewsAdapter).
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at a given position
     * in the list of news.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }


        // Find the news at the given position in the list of news
        News currentNews = getItem(position);


        // Get the section string from the News object
        String section = currentNews.getSection();

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);


        // Display the section of the current news in that TextView
        sectionView.setText(section);


        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable sectionRectangle = (GradientDrawable) sectionView.getBackground();

        // Get the appropriate background color based on the current news section
        int sectionColor = getSectionColor(currentNews.getSection());

        // Set the color on the section rectangle
        sectionRectangle.setColor(sectionColor);


        // Get the title string from the News object
        String title = currentNews.getTitle();


        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);

        // Display the title of the current news in that TextView
        titleView.setText(title);


        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);

        if (currentNews.getAuthor() != null) {

            // Display the author of the current News in that TextView
            authorView.setText(currentNews.getAuthor());
        } else {
            authorView.setVisibility(View.INVISIBLE);
        }


        String originalDateTime = currentNews.getDateTime();

        String newsDate;
        String newsTime;

        if (originalDateTime.contains(DATE_SEPARATOR)) {
            String[] parts = originalDateTime.split(DATE_SEPARATOR);
            newsDate = parts[0];
            if (parts[1].contains(TIME_SEPARATOR)) {
                newsTime = parts[1].replace(TIME_SEPARATOR, "");
            } else {
                newsTime = parts[1];
            }
        } else {
            newsDate = null;
            newsTime = null;
        }


        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Display the date of the current earthquake in that TextView
        dateView.setText(newsDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        // Display the time of the current earthquake in that TextView
        timeView.setText(newsTime);


        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }


    /**
     * Return the color for the section rectangle based on the name of the section.
     *
     * @param section of the news
     */

    private int getSectionColor(String section) {
        int sectionColorResourceId;


        switch (section) {

            case "Sport":
                sectionColorResourceId = R.color.Sport;
                break;
            case "Music":
                sectionColorResourceId = R.color.Music;
                break;
            case "Life and style":
                sectionColorResourceId = R.color.Life_and_style;
                break;
            case "Books":
                sectionColorResourceId = R.color.Books;
                break;
            case "Business":
                sectionColorResourceId = R.color.Business;
                break;
            case "Money":
                sectionColorResourceId = R.color.Money;
                break;
            case "Politics":
                sectionColorResourceId = R.color.Politics;
                break;
            case "Football":
                sectionColorResourceId = R.color.Football;
                break;
            case "Media":
                sectionColorResourceId = R.color.Media;
                break;
            case "Stage":
                sectionColorResourceId = R.color.Stage;
                break;
            default:
                sectionColorResourceId = R.color.Default;
                break;
        }

        return ContextCompat.getColor(getContext(), sectionColorResourceId);

    }


}