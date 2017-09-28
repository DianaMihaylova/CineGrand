package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Movie;

import java.util.ArrayList;

public class MovieDetailsActivity extends Activity {

    private static ArrayList<Movie> movies = new ArrayList<>();

    static {
        addMovies();
    }

    private ImageView imageView;
    private TextView info, trailer;
    private Button reservationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imageView = (ImageView) findViewById(R.id.imageView3);
        info = (TextView) findViewById(R.id.textView2);
        trailer = (TextView) findViewById(R.id.textView);
        reservationBtn = (Button) findViewById(R.id.button_reservation);

        imageView.setImageResource(getIntent().getIntExtra("img_id", 00));
        String intentString = getIntent().getStringExtra("name");

        for (Movie movie: movies) {
            if (movie.getTitle().equals(intentString)) {
                trailer.setText("Watch trailer here: " + movie.getTrailer());
                info.setText(movie.getDescription());
            }
        }

        reservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ReservationActivity.class);
                startActivity(i);
            }
        });
    }
    private static void addMovies() {
        Movie m1 = new Movie("IT", "Genre:Drama | Horror\n" +
                "Length (in min.): 135\n" +
                "Language:English\n" +
                "Released on: 08/09/2017\n" +
                "Rating:NC-17\n" +
                "Director: Andy Muschietti\n" +
                "Actors:\n" +
                "Bill Skarsgard, Jaeden Lieberher, Finn Wolfhard\n" +
                "Country / Year: USA 2017\n" +
                "In the Town of Derry, the local kids are disappearing one by one, leaving behind " +
                "bloody remains. In a place known as 'The Barrens', a group of seven kids are united" +
                " by their horrifying and strange encounters with an evil clown and their " +
                "determination to kill It.", "https://youtu.be/s7S74IElVow");
        movies.add(m1);

        Movie m2 = new Movie("XII “А“", "Genre:Comedy | Drama\n" +
                "Length (in min.): 91\n" +
                "Language:Bulgarian\n" +
                "Released on: 15/09/2017\n" +
                "Rating:G\n" +
                "Director: Magdalena Ralcheva\n" +
                "Actors:\n" +
                "Radina Kurdjilova, Darin Angelov, Mariq Kavardjikova, Elena Boicheva, Aneliq Mangurova," +
                " Velislava Kostadinova, Kaloqn Minev, Deqn Georgiev\n" +
                "Country / Year: Bulgaria 2017\n" +
                "The movie XIIa is the sequel of the super successful XIa. In XIIa the journey continues." +
                " After two years break, Lina is back to school to teach a new class - a new class, new problems.",
                "https://youtu.be/sB4zz9sajsw");
        movies.add(m2);

        Movie m3 = new Movie("Despicable Me 3", "Genre:Action | Comedy | Animation | Adventure\n" +
                "Length (in min.): 90\n" +
                "Released on: 30/06/2017\n" +
                "Rating:G\n" +
                "Director: Kyle Balda, Pierre Coffin\n" +
                "Actors:\n" +
                "Kristen Wiig, Trey Parker, Steve Carell\n" +
                "Country / Year: USA 2017\n" +
                "Balthazar Bratt, a child star from the 1980s, hatches a scheme for world domination.\n",
                "https://youtu.be/I5rf_YfG8yQ");
        movies.add(m3);

        Movie m4 = new Movie("Hitmans Bodyguard", "Genre:Action | Comedy\n" +
                "Length (in min.): 118\n" +
                "Language:English\n" +
                "Released on: 01/09/2017\n" +
                "Rating:NC-17\n" +
                "Director: Patrick Hughes\n" +
                "Actors:\n" +
                "Ryan Reynolds, Samuel L. Jackson, Gary Oldman\n" +
                "Country / Year: USA 2017\n" +
                "The world's top bodyguard gets a new client, a hit man who must testify at the " +
                "International Court of Justice. They must put their differences aside and work together" +
                " to make it to the trial on time.\n", "https://youtu.be/97lZB5GiU_k");
        movies.add(m4);

        Movie m5 = new Movie("The Nut Job 2", "Genre:Comedy | Animation | Adventure\n" +
                "Length (in min.): 91\n" +
                "Released on: 08/09/2017\n" +
                "Rating:G\n" +
                "Director: Cal Brunker\n" +
                "Actors:\n" +
                "Will Arnett, Katherine Heigl, Maya Rudolph\n" +
                "Country / Year: 2017\n" +
                "Surly and his friends, Buddy, Andie and Precious discover that the mayor of Oakton City" +
                " is cracking one big hustle to build a giant yet quite-shabby amusement park, which in " +
                "turn will bulldoze their home, which is the city park, and it's up to them and the rest of" +
                " the park animals to stop the mayor, along with his daughter and a mad animal control " +
                "officer from getting away with his scheme, and take back the park",
                "https://youtu.be/UY7ETehkUR0");
        movies.add(m5);

        Movie m6 = new Movie("Logan Lucky", "Genre:Comedy | Drama | Crime\n" +
                "Length (in min.): 119\n" +
                "Language:English\n" +
                "Released on: 08/09/2017\n" +
                "Rating:G\n" +
                "Director: Steven Soderbergh\n" +
                "Actors:\n" +
                "Adam Driver, Channing Tatum, Daniel Craig\n" +
                "Country / Year: USA 2017\n" +
                "Two brothers attempt to pull off a heist during a NASCAR race in North Carolina.",
                "https://youtu.be/XHLw0wfpcT0");
        movies.add(m6);
    }
}
