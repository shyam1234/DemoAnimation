package com.malviya.demoanimation.utilies;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Admin on 23-10-2016.
 */

public class Utility {
    private static MediaPlayer m;
    static {
        m = new MediaPlayer();
    }
    public static boolean isCollide(float px, float py, float x, float y, float w, float h) {
        if (px < (x) && py < y) {
            Log.d("dd", "111");
            return false;
        } else if (px > x && py < y) {
            Log.d("dd", "222");
            return false;
        } else if (px < x && py > y) {
            Log.d("dd", "333");
            return false;
        } else if (px > (x + w) && py > (y + h)) {
            Log.d("dd", "444");
            return false;
        } else if (px > (x + w) && py <= (y + h)) {
            Log.d("dd", "555");
            return false;
        } else if (px > (x) && py > (y + h)) {
            Log.d("dd", "666");
            return false;
        }
        return true;
    }


    public static void playSound(Context pContext, String fileName, boolean loop) {
        try {
            if (m.isPlaying()) {
                m.stop();
              //  m.release();
                //m = new MediaPlayer();
            }
            m = new MediaPlayer();
            AssetFileDescriptor descriptor = pContext.getAssets().openFd(fileName);
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(loop);
            m.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void removeSound(){
        if (m.isPlaying()) {
            m.stop();
           // m.release();
        }
    }


//    private Bitmap getImage(int res) {
//        Bitmap image = null;
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), res);
//        try {
//            Log.d("gameworld", "w h" + DEVICE_WIDTH + " : " + DEVICE_HEIGHT);
//            Rect rect = new Rect(0, 0, DEVICE_WIDTH, DEVICE_HEIGHT);
//            image = Bitmap.createBitmap(DEVICE_WIDTH, DEVICE_HEIGHT, Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(image);
//            Paint paint = new Paint();
//            paint.setAntiAlias(true);
//            //canvas.drawCircle(50,50,500,paint);
//            canvas.drawARGB(0, 0, 0, 0);
//            //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//            canvas.drawBitmap(bitmap, rect, rect, paint);
//        } catch (Exception e) {
//            Log.e("gameworld", "exception " + e.getMessage());
//        }
//        return image;
//    }
//
//    public Point getPointOnCicle(float deg, float redius) {
//        int x = Math.round(getWidth() / 2);
//        int y = Math.round(getHeight() / 2);
//        double rads = Math.toRadians(deg - 90);
//
//        int xPos = Math.round((float) (x + Math.cos(rads) * redius));
//        int yPos = Math.round((float) (y + Math.sin(rads) * redius));
//        return new Point(xPos, yPos);
//    }
}
