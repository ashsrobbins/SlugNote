package slugnote.com.slugnote;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by Ash on 1/31/2016.
 */
public class noteviewFragment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noteview);

        String imageName = getIntent().getStringExtra("note-name");

        ImageView SlugImageView = (ImageView) findViewById(R.id.SlugNoteView);
        Bitmap stb = StringToBitMap(imageName);
        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);
        //SlugImageView.setImageResource(icon);
        SlugImageView.setImageResource(R.drawable.image5);

    }


    public String BitMapToString(Bitmap bitmap)//changes bit from bitmap to a string
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
