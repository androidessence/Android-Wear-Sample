package com.androidessence.watchsample;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Adapter class to display list items in the WearableListView.
 *
 * Created by adammcneilly on 1/1/16.
 */
public class WearableAdapter extends WearableListView.Adapter {
    private String[] mItems;
    private Context mContext;

    public WearableAdapter(Context context, String[] items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public WearableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WearableViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_wearable, parent, false));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        ((WearableViewHolder)holder).bindString(mItems[position]);
    }

    @Override
    public int getItemCount() {
        return mItems.length;
    }

    public class WearableViewHolder extends WearableListView.ViewHolder {
        private WearableListItemLayout mListItem;

        public WearableViewHolder(View view) {
            super(view);

            mListItem = (WearableListItemLayout) view;
        }

        public void bindString(String string) {
            mListItem.setText(string);
        }
    }
}
