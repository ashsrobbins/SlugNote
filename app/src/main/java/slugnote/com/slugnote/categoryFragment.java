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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class categoryFragment extends Activity{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    private String[] collegeIds = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Button categories = (Button)findViewById(R.id.button1);
        Button search = (Button)findViewById(R.id.button2);
        Button upload = (Button)findViewById(R.id.button3);
        Button mynotebook = (Button)findViewById(R.id.button4);


        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),categoryFragment.class);
                startActivity(intent1);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),searchFragment.class);
                startActivity(intent1);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),uploadFragment.class);
                startActivity(intent1);
            }
        });

        mynotebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),myNotebook.class);
                startActivity(intent1);
            }
        });


        ListView list = (ListView) findViewById(R.id.listViewColleges);

        try{
//            try{
//                URL url = new URL("http://api.slugnote.com");
//
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                connection.setDoOutput(true);
//                connection.setRequestMethod("POST");
//
//                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//
//              //  writer.write("message=" + message);
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            String in = "[\"UCSC\",\"UCSD\",\"UCLA\",\"UCSB\",\"UCSF\"]";
            JSONArray jsIn = new JSONArray(in);
            int len = jsIn.length();
            List<String> lc = new ArrayList<>(len);
            for(int i = 0; i< len ; i++){
                lc.add(jsIn.getString(i));
            }
            list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lc));
            list.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String temp = ((TextView)view).getText() + Integer.toString(position);
                    Toast.makeText(getApplicationContext(),temp ,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),coursesFragment.class);
                    //intent.putExtra("college-name", ((TextView)view).getText());
                    //intent.putExtra("college-id", XXXX);
                    startActivity(intent);
                }
            });
        }
        catch (Exception e){
            //
        }



        //create tabhost to have tabs
//        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
//        System.out.println("aosdjalksdjaskldh" + tabHost);
//        tabHost.setup();
        //different tabs
//        TabHost.TabSpec categories = tabHost.newTabSpec("Categories");
//        TabHost.TabSpec search = tabHost.newTabSpec("Search");
//        TabHost.TabSpec upload = tabHost.newTabSpec("Upload");
//        TabHost.TabSpec notebook = tabHost.newTabSpec("Notebook");

//        categories.setIndicator("", getResources().getDrawable(R.drawable.ic_launcher));
//        categories.setIndicator("Poop");
//        Intent categoriesIntent= new Intent(this, categoriesFragment.class);
//        categories.setContent(categoriesIntent);
//        categories.setContent(R.id.tab1);
//        tabHost.addTab(categories);
//        search.setIndicator("Sea");
//        Intent searchIntent = new Intent(this, searchFragment.class);
//        search.setContent(searchIntent);
//
//
//        upload.setIndicator("Upl");
//        Intent uploadIntent = new Intent(this, uploadFragment.class);
//        upload.setContent(uploadIntent);
//        //add upload and notebook intents here
//
//        notebook.setIndicator("Not");
        //Intent notebookIntent = new Intent(this, notebookFragment.class);
        //notebook.setContent(notebookIntent);

        //add actual tabs
//        System.out.println("Categories:" + categories);
//        tabHost.addTab(categories);
//        tabHost.addTab(search);
//        tabHost.addTab(upload);
//        tabHost.addTab(notebook);


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
