package slugnote.com.slugnote;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Ash on 1/30/2016.
 */
public class notesFragment extends ListFragment{
    //Server transfer notes(obj/id)

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=inf.inflate(R.layout.notes, container,false);

        //adapter here
        //Change this to make it so its not only string, get separate fields of the object array
        ListAdapter adapt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1);
        setListAdapter(adapt);


        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //SEND ID to server, and call the courses fragment?

        return;
    }



}
