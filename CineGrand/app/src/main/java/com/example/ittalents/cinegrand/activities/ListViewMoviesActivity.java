package com.example.ittalents.cinegrand.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ittalents.cinegrand.R;
import com.example.ittalents.cinegrand.models.Cinema;
import com.example.ittalents.cinegrand.models.Movie;
import com.example.ittalents.cinegrand.models.User;

import java.util.ArrayList;

public class ListViewMoviesActivity extends Activity {

    public static final ArrayList<Movie> movies = new ArrayList<>();

    static {
        addMovies();
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private String movieName, infoMovies;
    private Button contactsBtn;
    private TextView cinemaName;
    private ArrayList<Movie> listMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_movies);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contactsBtn = (Button) findViewById(R.id.button_contacts);
        cinemaName = (TextView)findViewById(R.id.cinema_name);
        listMovies = new ArrayList<>();

        final Cinema kino = (Cinema) getIntent().getExtras().get("Kino");

        cinemaName.setText(kino.getName());


        for (Movie movie: movies) {
            Movie m = new Movie(movie.getImgRes(), movie.getTitle(), movie.getInfoMovie());
            movieName = m.getTitle();
            infoMovies = m.getInfoMovie();
            listMovies.add(m);
        }

        adapter = new MyRecyclerAdapter(listMovies, this);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ContactsActivity.class);
                i.putExtra("Kino", kino);
                startActivity(i);
            }
        });
    }

    private static void addMovies() {
        Movie m1 = new Movie("IT", "Drama | Horror", "Genre:Drama | Horror\n" +
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
                "determination to kill It.", "https://youtu.be/s7S74IElVow",
                "08.10.2017 - 10:30 12:30 14:30 16:30 18:30 21:30\n" +
                        "09.10.2017 - 10:50 12:45 14:15 16:20 18:50 21:55\n" +
                        "10.10.2017 - 10:00 11:20 13:30 15:50 17:30 20:45\n" +
                        "11.10.2017 - 10:15 11:45 14:30 15:20 19:30 22:30\n" +
                        "12.10.2017 - 10:00 12:00 14:00 16:00 18:00 22:30\n" +
                        "13.10.2017 - 10:10 12:35 13:35 15:45 17:35 21:45\n" +
                        "14.10.2017 - 10:20 12:05 14:35 16:50 18:20 21:30", R.drawable.it);
        movies.add(m1);

        Movie m2 = new Movie("XII А", "Comedy | Drama", "Genre:Comedy | Drama\n" +
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
                "https://youtu.be/sB4zz9sajsw", "08.10.2017 - 11:30 15:30 14:30 16:35 18:50 21:30\n" +
                "09.10.2017 - 10:50 12:50 14:30 16:20 18:50 21:55\n" +
                "10.10.2017 - 10:30 11:20 13:30 15:55 17:30 20:55\n" +
                "11.10.2017 - 10:15 11:45 14:30 15:20 19:30 22:30\n" +
                "12.10.2017 - 10:30 12:45 14:20 16:50 18:50 22:35\n" +
                "13.10.2017 - 11:10 12:35 14:35 15:45 17:35 21:45\n" +
                "14.10.2017 - 10:20 12:15 14:35 16:50 18:30 22:30", R.drawable.xii_a);
        movies.add(m2);

        Movie m3 = new Movie("Despicable Me 3", "Action | Comedy | Animation | Adventure",
                "Genre:Action | Comedy | Animation | Adventure\n" +
                "Length (in min.): 90\n" +
                "Released on: 30/06/2017\n" +
                "Rating:G\n" +
                "Director: Kyle Balda, Pierre Coffin\n" +
                "Actors:\n" +
                "Kristen Wiig, Trey Parker, Steve Carell\n" +
                "Country / Year: USA 2017\n" +
                "Balthazar Bratt, a child star from the 1980s, hatches a scheme for world domination.\n",
                "https://youtu.be/I5rf_YfG8yQ", "08.10.2017 - 10:20 11:30 13:30 15:35 17:50 22:30\n" +
                "09.10.2017 - 11:50 12:50 14:30 16:00 18:50 21:55\n" +
                "10.10.2017 - 10:30 11:20 13:30 15:55 17:30 20:55\n" +
                "11.10.2017 - 10:00 11:45 14:35 15:20 19:35 22:30\n" +
                "12.10.2017 - 10:30 12:45 14:20 16:50 18:50 22:35\n" +
                "13.10.2017 - 11:15 12:35 14:30 15:45 17:30 21:45\n" +
                "14.10.2017 - 10:00 12:10 14:30 16:45 18:35 22:00", R.drawable.despicable_me_3);
        movies.add(m3);

        Movie m4 = new Movie("Hitmans Bodyguard", "Action | Comedy", "Genre:Action | Comedy\n" +
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
                " to make it to the trial on time.\n", "https://youtu.be/97lZB5GiU_k",
                "08.10.2017 - 10:10 11:35 13:50 15:20 17:30 22:00\n" +
                        "09.10.2017 - 11:55 12:45 14:30 16:20 18:55 21:55\n" +
                        "10.10.2017 - 10:30 11:30 13:35 15:55 17:35 20:55\n" +
                        "11.10.2017 - 10:00 11:45 14:35 15:20 19:30 22:30\n" +
                        "12.10.2017 - 10:35 12:45 14:30 16:50 18:55 22:35\n" +
                        "13.10.2017 - 11:15 12:30 14:35 15:45 17:35 21:45\n" +
                        "14.10.2017 - 10:20 12:30 14:45 16:30 18:20 22:20", R.drawable.hitmans_bodyguard);
        movies.add(m4);

        Movie m5 = new Movie("The Nut Job 2", "Comedy | Animation | Adventure", "Genre:Comedy | Animation | Adventure\n" +
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
                "https://youtu.be/UY7ETehkUR0", "08.10.2017 - 10:20 11:35 13:55 15:20 17:30 22:05\n" +
                "09.10.2017 - 11:00 12:50 14:35 16:20 18:20 21:30\n" +
                "10.10.2017 - 10:30 11:20 13:45 15:00 17:20 20:55\n" +
                "11.10.2017 - 10:00 11:45 14:35 15:20 19:30 22:30\n" +
                "12.10.2017 - 10:35 12:45 14:30 16:50 18:55 22:35\n" +
                "13.10.2017 - 11:15 12:30 14:35 15:45 17:35 21:45\n" +
                "14.10.2017 - 10:25 12:20 14:50 16:30 18:45 22:20", R.drawable.the_nut_job_2_nutty_by_nature);
        movies.add(m5);

        Movie m6 = new Movie("Logan Lucky", "Comedy | Drama | Crime", "Genre:Comedy | Drama | Crime\n" +
                "Length (in min.): 119\n" +
                "Language:English\n" +
                "Released on: 08/09/2017\n" +
                "Rating:G\n" +
                "Director: Steven Soderbergh\n" +
                "Actors:\n" +
                "Adam Driver, Channing Tatum, Daniel Craig\n" +
                "Country / Year: USA 2017\n" +
                "Two brothers attempt to pull off a heist during a NASCAR race in North Carolina.",
                "https://youtu.be/XHLw0wfpcT0", "08.10.2017 - 10:00 11:35 13:20 15:20 17:30 22:20\n" +
                "09.10.2017 - 11:30 12:50 14:30 16:35 18:20 21:30\n" +
                "10.10.2017 - 10:45 11:20 13:45 15:00 17:20 20:55\n" +
                "11.10.2017 - 10:00 11:45 14:35 15:55 19:30 22:30\n" +
                "12.10.2017 - 10:35 12:20 14:20 16:50 18:55 22:35\n" +
                "13.10.2017 - 11:15 12:30 14:35 15:45 17:35 21:45\n" +
                "14.10.2017 - 10:30 12:20 14:50 16:30 18:45 22:05", R.drawable.logan_lucky);
        movies.add(m6);
    }
}