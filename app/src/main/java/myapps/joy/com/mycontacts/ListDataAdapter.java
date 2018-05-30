package myapps.joy.com.mycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jecihjoy on 6/10/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);

    }

    static class LayoutHandler {
        TextView NAME, MOB, EMAIL;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler lh;
        if (row == null) {
            LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = li.inflate(R.layout.row_layout, parent, false);
            lh = new LayoutHandler();
            lh.NAME = (TextView) row.findViewById(R.id.UN);
            lh.MOB = (TextView) row.findViewById(R.id.UM);
            lh.EMAIL = (TextView) row.findViewById(R.id.UE);
            row.setTag(lh);
        } else {
            lh = (LayoutHandler) row.getTag();
        }
        DataProvider Db = (DataProvider) this.getItem(position);
        lh.NAME.setText(Db.getName().toString());
        lh.MOB.setText(Db.getMob().toString());
        lh.EMAIL.setText(Db.getEmail().toString());

        return row;

    }


}
