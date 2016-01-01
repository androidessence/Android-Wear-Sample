package com.androidessence.watchsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String[] DATA_ITEMS = new String[] {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                setupListView();
            }
        });
    }

    private void setupListView() {
        WearableAdapter adapter = new WearableAdapter(this, DATA_ITEMS);
        WearableListView listView = (WearableListView) findViewById(R.id.wearable_list_view);
        listView.setAdapter(adapter);
    }
}
