    package com.example.sunghuncom.hw2_0411_homeworklist2;

    import android.app.ListActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ListView;
    import android.widget.Toast;
    import android.content.Intent;

    public class MainActivity extends ListActivity {
        public void onCreate(Bundle icicle) {

            
            super.onCreate(icicle);
           //make item list
            String[] values = new String[] { "Time Table", "Tip Calculator", "Mini Calculator","Change password" };

            MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);

            setListAdapter(adapter);
        }


    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);

        //call intent message
        if(item.compareTo("Time Table")==0)
            startActivity(new Intent(this, TimeTable_desc.class));

        else if(item.compareTo("Tip Calculator")==0)
            startActivity(new Intent(this, TipCalcul_desc.class));

        else if(item.compareTo("Mini Calculator")==0)
            startActivity(new Intent(this, MiniCalcul_desc.class));

        else if(item.compareTo("Change password")==0)
            startActivity(new Intent(this, ChangePwd.class));
        else
            System.out.println("Error!!");

        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }

}