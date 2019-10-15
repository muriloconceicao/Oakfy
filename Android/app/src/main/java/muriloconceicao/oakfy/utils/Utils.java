package muriloconceicao.oakfy.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static void showToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}