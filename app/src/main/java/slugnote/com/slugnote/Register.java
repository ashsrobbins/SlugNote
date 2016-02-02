package slugnote.com.slugnote;

/**
 * Created by Ash on 1/31/2016.
 */
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button bRegister;
    EditText userName, userPassword, userEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        userEmail = (EditText) findViewById(R.id.userEmail);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bRegister:
                break;

        }

    }

}