package org.westada.quicklauncher;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter2 extends BaseAdapter {
    LayoutInflater mInflater;
    String[] items1;
    String[] prices1;
    String[] descriptions1;

    public ItemAdapter2(Context c, String[] i, String[] p, String[] d) {
        items1 = i;
        prices1 = p;
        descriptions1 = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int i, View view, ViewGroup viewGroup) {
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
