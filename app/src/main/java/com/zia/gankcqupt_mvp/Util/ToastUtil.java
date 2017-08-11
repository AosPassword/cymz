package com.zia.gankcqupt_mvp.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zia on 17-8-11.
 */

public class ToastUtil {
        private static Toast toast;

        public static void showToast(Context context,
                                     String content) {
            if (toast == null) {
                toast = Toast.makeText(context,
                        content,
                        Toast.LENGTH_SHORT);
            } else {
                toast.setText(content);
            }
            toast.show();
        }
}
