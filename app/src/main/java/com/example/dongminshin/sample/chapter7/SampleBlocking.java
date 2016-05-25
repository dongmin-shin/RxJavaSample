package com.example.dongminshin.sample.chapter7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.example.dongminshin.executor.BaseExecutor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DongMinShin on 16. 5. 25..
 */
public class SampleBlocking extends BaseExecutor {

    @Override
    public void execute() {
    }

    @Override
    public void execute(Context context) {
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<AppInfoRich> apps = new ArrayList<>();
        List<ResolveInfo> infoList = context.getPackageManager().queryIntentActivities(mainIntent, 0);
        for (ResolveInfo info : infoList) {
            apps.add(new AppInfoRich(context, info));
        }

        for (AppInfoRich appInfoRich : apps) {
            Bitmap icon = drawableToBitmap(appInfoRich.getIcon());
            String name = appInfoRich.getName();

            String iconPath = name;
            blockingStoreBitmap(context, icon, iconPath);
        }
    }

    private void blockingStoreBitmap(Context context, Bitmap bitmap, String filename) {
        FileOutputStream fOut = null;
        try {
            fOut = context.openFileOutput(filename, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fOut != null) {
                    fOut.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
