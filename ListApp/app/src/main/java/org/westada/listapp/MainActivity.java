package org.westada.listapp;

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

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView)findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("org.westada.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });

    }

    public static class ItemAdapter extends BaseAdapter {

        LayoutInflater mInflater;
        String[] items;
        String[] prices;
        String[] descriptions;

        public ItemAdapter(Context c, String[] i, String[] p, String[] d) {

            items = i;
            prices = p;
            descriptions = d;
            mInflater = (LayoutInflater) c.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int i) {
            return items[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {

            View v = mInflater.inflate(R.layout.my_listview_detail, null);
            TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            TextView descriptionTextView = (TextView) v.findViewById(R.id.decriptionTextView);
            TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

            String name = items[i];
            String desc = descriptions[i];
            String cost = prices[i];

            nameTextView.setText(name);
            descriptionTextView.setText(desc);
            priceTextView.setText(cost);


            return v;
        }


    }
}
