package humber.android.group.six.carshare;

import android.content.Context;
import android.widget.Toast;

public class Common {

    public static void makeToast(Context context, String text, int duration) {
        Toast.makeText(context, text, duration).show();
    }
}