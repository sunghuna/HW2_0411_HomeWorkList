package com.example.sunghuncom.hw2_0411_homeworklist2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunghuncom.hw2_0411_homeworklist.R;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        String s = values[position];
        if (s.startsWith("Time Table"))
            imageView.setImageResource(R.drawable.calendar);
        else if (s.startsWith("Tip Calculator"))
            imageView.setImageResource(R.drawable.usd);
        else if (s.startsWith("Mini Calculator"))
            imageView.setImageResource(R.drawable.calculator);
        else
            imageView.setImageResource(R.mipmap.ic_launcher);

        return rowView;
    }
}