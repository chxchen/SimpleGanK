package com.blanke.simplegank.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.blanke.simplegank.R;
import com.socks.library.KLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by blanke on 16-2-3.
 */
public class BitmapUtils {


    public static String getPhotoPath(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + ResUtils.getResString(context, R.string.app_name);
    }

    public static Observable<Boolean> savaImage(Context context, Bitmap bitmap, String fileName) {
        return Observable.just(fileName).map(s -> {
            try {
                return savaImageInNewThread(context, bitmap, s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static boolean savaImageInNewThread(Context context, Bitmap bitmap, String fileName) throws IOException {
        File f = new File(getPhotoPath(context), fileName);
        KLog.d(f.getAbsolutePath());
        if (!f.exists()) {
            FileOutputStream out = null;
            f.getParentFile().mkdirs();
            out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        }
        return true;
    }
}
