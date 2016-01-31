package slugnote.com.slugnote;

/**
 * Created by Ash on 1/31/2016.
 */
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class unneccessary extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText userName, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        userEmail = (EditText) findViewById(R.id.userEmail);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.bLogout:
                startActivity(new Intent(this, activity_Main.class));
                break;
        }
    }
}