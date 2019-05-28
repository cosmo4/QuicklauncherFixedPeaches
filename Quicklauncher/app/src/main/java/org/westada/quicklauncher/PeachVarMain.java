package org.westada.quicklauncher;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PeachVarMain extends AppCompatActivity {
    ListView myListView;
    String[] items1;
    String[] prices1;
    String[] descriptions1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peach_var_main);

        Resources res = getResources();
        myListView = (ListView)findViewById(R.id.myListView);
        items1 = res.getStringArray(R.array.items1);
        prices1 = res.getStringArray(R.array.prices1);
        descriptions1 = res.getStringArray(R.array.descriptions1);

        ItemAdapter itemAdapter = new ItemAdapter(this, items1, prices1, descriptions1);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity2.class);
                showDetailActivity.putExtra("org.westada.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });

    }

    public static class ItemAdapter extends BaseAdapter {

        LayoutInflater mInflater;
        String[] items1;
        String[] prices1;
        String[] descriptions1;

        public ItemAdapter(Context c, String[] i, String[] p, String[] d) {

            items1 = i;
            prices1 = p;
            descriptions1 = d;
            mInflater = (LayoutInflater) c.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return items1.length;
        }

        @Override
        public Object getItem(int i) {
            return items1[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {

            View v = mInflater.inflate(R.layout.my_listview_detail_var, null);
            TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
            TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

            String name = items1[i];
            String desc = descriptions1[i];
            String cost = prices1[i];

            nameTextView.setText(name);
            descriptionTextView.setText(desc);
            priceTextView.setText(cost);


            return v;
        }


    }
}


