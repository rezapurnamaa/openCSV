package com.example.reza.opencsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reza on 27/11/16.
 */

public class ItemArrayAdapter extends ArrayAdapter<String[]> {

    private List<String[]> stolpersteineList = new ArrayList<>();

    static  class ItemViewHolder{
        TextView name;
        TextView nachname;
        TextView adresse;

    }

    public ItemArrayAdapter(Context context, int resource){
        super(context,resource);
    }

    public void add(String[] object){
        stolpersteineList.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return this.stolpersteineList.size();
    }

    @Override
    public String[] getItem(int position){
        return this.stolpersteineList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.nachname = (TextView) row.findViewById(R.id.nachname);
            viewHolder.adresse = (TextView) row.findViewById(R.id.adresse);
            row.setTag(viewHolder);
        }
        else {
            viewHolder = (ItemViewHolder) row.getTag();
        }
        String[] stolpersteine = getItem(position);
        viewHolder.name.setText(stolpersteine[0]);
//        viewHolder.nachname.setText(stolpersteine[2]);
        viewHolder.adresse.setText(stolpersteine[4]);
        return row;
    }
}
