package humber.android.group.six.carshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class Common {

    public static void makeToast(Context context, String text, int duration) {
        Toast.makeText(context, text, duration).show();
    }


}

