package slugnote.com.slugnote;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Ash on 1/30/2016.
 */

public class myNotebook extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynotebook);

        Button categories = (Button) findViewById(R.id.button1);
        Button search = (Button) findViewById(R.id.button2);
        Button upload = (Button) findViewById(R.id.button3);
        Button mynotebook = (Button) findViewById(R.id.button4);


        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), categoryFragment.class);
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

        mynotebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), myNotebook.class);
                startActivity(intent1);
            }
        });



        ListView list = (ListView) findViewById(R.id.myNotebook);

        try {
            String in = "[\"My Notes\",\"Saved Notes\",\"Settings\"]";
            JSONArray jsIn = new JSONArray(in);
            int len = jsIn.length();
            List<String> nb = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                nb.add(jsIn.getString(i));
            }
            list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nb));
            list.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String temp = ((TextView) view).getText() + Integer.toString(position);
                    Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),myNotebook.class);
                    //intent.putExtra("college-name", ((TextView)view).getText());
                    //intent.putExtra("college-id", XXXX);
                    startActivity(intent);
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