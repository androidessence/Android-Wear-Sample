package com.androidessence.watchsample;

import android.content.Context;
import android.os.Build;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * List item that is displayed on an Android Wear device.
 *
 * Created by adammcneilly on 1/1/16.
 */
public class WearableListItemLayout extends TextView implements WearableListView.OnCenterProximityListener{

    WearableListItemLayout(Context context) {
        this(context, null);
    }

    WearableListItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    WearableListItemLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    @Override
    public void onCenterPosition(boolean b) {
        // When centered, let's enlarge the text.
        // As of API 23, we don't need to pass context.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextAppearance(android.R.style.TextAppearance_Large);
        } else {
            setTextAppearance(getContext(), android.R.style.TextAppearance_Large);
        }
    }

    @Override
    public void onNonCenterPosition(boolean b) {
        // When leaving centered, set text backk to small.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextAppearance(android.R.style.TextAppearance_Small);
        } else {
            setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
        }
    }
}
