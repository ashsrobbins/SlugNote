package slugnote.com.slugnote;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Ash on 1/30/2016.
 */
public class notesFragment extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        if(savedInstanceState==null){
            Toast.makeText(getApplicationContext(), "State == null", Toast.LENGTH_SHORT).show();
        }


        Button categories = (Button) findViewById(R.id.button1);
        Button search = (Button) findViewById(R.id.button2);
        Button upload = (Button) findViewById(R.id.button3);
        Button notes = (Button) findViewById(R.id.button4);
        Button settings = (Button) findViewById(R.id.button5);


        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), searchFragment.class);
                startActivity(intent1);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), uploadFragment.class);
                startActivity(intent1);
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), notesFragment.class);
                startActivity(intent1);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), settingsFragment.class);
                startActivity(intent1);
            }
        });

        ListView list = (ListView) findViewById(R.id.listViewNotes);

        try {
            String in = "[\"Lecture1\",\"Lecture2\",\"Lecture 3\",\"Lecture 4\",\"Lecture 5\",\"Lecture1\",\"Lecture2\",\"Lecture 3\",\"Lecture 4\",\"Lecture 5\",\"Lecture2\",\"Lecture 3\",\"Lecture 4\",\"Lecture 5\"]";
            JSONArray jsIn = new JSONArray(in);
            int len = jsIn.length();
            List<String> lc = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                lc.add(jsIn.getString(i));
            }
            list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lc));
            list.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String temp = ((TextView) view).getText() + Integer.toString(position);
                    Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();

                    //Intent intent = new Intent(getApplicationContext(),coursesFragment.class);
                    //intent.putExtra("college-name", ((TextView)view).getText());
                    //intent.putExtra("college-id", XXXX);
                    //startActivity(intent);
                }
            });
        } catch (Exception e) {
            //
        }


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        // client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://slugnote.com.slugnote/http/host/path")
        );
        // AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://slugnote.com.slugnote/http/host/path")
        );
        // AppIndex.AppIndexApi.end(client, viewAction);
        //client.disconnect();
    }
}