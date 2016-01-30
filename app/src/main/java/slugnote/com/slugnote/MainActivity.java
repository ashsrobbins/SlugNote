package slugnote.com.slugnote;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create tabhost to have tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


        //different tabs
        TabHost.TabSpec categories = tabHost.newTabSpec("Categories");
        TabHost.TabSpec search=tabHost.newTabSpec("Search");
        TabHost.TabSpec upload=tabHost.newTabSpec("Upload");
        TabHost.TabSpec notebook=tabHost.newTabSpec("Notebook");

        categories.setIndicator("Cat");
        categories.setContent(new Intent(this, categoriesFragment.class));

        search.setIndicator("Sea");
        search.setContent(new Intent(this, searchFragment.class));


        upload.setIndicator("Upl");
        //add upload and notebook intents here

        notebook.setIndicator("Not");

        //add actual tabs
        tabHost.addTab(categories);
        tabHost.addTab(search);
        tabHost.addTab(upload);
        tabHost.addTab(notebook);


    }





}
