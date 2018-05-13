package com.example.android.news;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * An (@LinkNewsAdapter) knows how to create a list item layout for each news
 * in the data source (a list of (@Link News) objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {



    /**
     * Construct a new (@Link NewsAdapter).
     *
     * @param context of the app
     * @param news is the list of news, which is the data source of the adapter
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




        // Get the original author string from the News object
        String author = currentNews.getAuthor();

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        // Display the author offset of the current news in that TextView
        authorView.setText(author);





        // Create a new Date object from the author of the news
        Date dateObject = new Date(currentNews.getTimeInMilliseconds());


        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);



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
            case 0:
            case 1:
                sectionColorResourceId = R.color.Sport;
                break;
            case 2:
                sectionColorResourceId = R.color.Music;
                break;
            case 3:
                sectionColorResourceId = R.color.Life_and_style;
                break;
            case 4:
                sectionColorResourceId = R.color.Books;
                break;
            case 5:
                sectionColorResourceId = R.color.Business;
                break;
            case 6:
                sectionColorResourceId = R.color.Money;
                break;
            case 7:
                sectionColorResourceId = R.color.Politics;
                break;
            case 8:
                sectionColorResourceId = R.color.Football;
                break;
            case 9:
                sectionColorResourceId = R.color.Media;
                break;
            default:
                sectionColorResourceId = R.color.Stage;
                break;
        }

        return ContextCompat.getColor(getContext(), sectionColorResourceId);

    }




    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted time string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}

