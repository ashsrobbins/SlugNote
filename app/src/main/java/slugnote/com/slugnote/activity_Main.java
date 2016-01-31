package slugnote.com.slugnote;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import slugnote.com.slugnote.Register;

public class activity_Main extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText userName1, userPassword;
    TextView Register_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName1 = (EditText) findViewById(R.id.userName);//look through the content view to find the xml id that matches
        userPassword = (EditText) findViewById(R.id.userPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        Register_link = (TextView) findViewById(R.id.Register_link);


        bLogin.setOnClickListener(this);
        Register_link.setOnClickListener(this);

        List<String> lc = new ArrayList<>(3);
        lc.add("@userName");
        lc.add("slug@slug.com");
        lc.add("@password");
        String uSend = "[{\"userName\":\"@userName\",\"userEmail\":\"slug@ucsc.edu\",\"userPassword\":\"@password\"}]";



        try {
            JSONArray jsonArray = new JSONArray(uSend);
        }catch(JSONException e){}




        try{
            URL url = new URL("http://slugnote.com:8080/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

              writer.write();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:
                startActivity(new Intent(this, categoriesFragment.class));

                break;


            case R.id.Register_link:

                startActivity(new Intent(this, Register.class));

                break;
        }
    }
}