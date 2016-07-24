package com.gudong.client.androidx.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.gudong.client.androidx.annotation.ViewFinder;

import java.lang.reflect.Field;

/**
 * Created by fangtest on 16/7/24.
 */
public class XActivity extends Activity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        findViews();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        findViews();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        findViews();
    }

    private void findViews() {
        Field[] fields = getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(ViewFinder.class)) {
                    ViewFinder annotation = field.getAnnotation(ViewFinder.class);
                    int resId = annotation.id();
                    try {
                        field.setAccessible(true);
                        field.set(this, findViewById(resId));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}
