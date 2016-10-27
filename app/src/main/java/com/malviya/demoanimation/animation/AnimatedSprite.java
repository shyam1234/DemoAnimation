package com.malviya.demoanimation.animation;

/**
 * Created by 23508 on 10/27/2016.
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class AnimatedSprite {
    private Bitmap animation;
    private int xPos;
    private int yPos;
    private Rect sRectangle;
    private int fps;
    private int numFrames;
    private int currentFrame;
    private long frameTimer;
    private int spriteHeight;
    private int spriteWidth;
    private boolean loop;
    public boolean dispose;
    private int horizontal_total_frame;


    public AnimatedSprite() {
        sRectangle = new Rect(0, 0, 0, 0);
        frameTimer = 0;
        currentFrame = 0;
        xPos = 80;
        yPos = 400;
        dispose = false;
    }

    public void initAnim(Bitmap bitmap, int height, int width, int fps, int frameCount, boolean loop, int horizontal_total_frame) {
        this.animation = bitmap;
        this.spriteHeight = height;
        this.spriteWidth = width;
        this.sRectangle.left = 0;
        this.sRectangle.top = 0;
        this.sRectangle.right = spriteWidth;
        this.sRectangle.bottom = spriteHeight;
        this.fps = 1000 / fps;
        this.numFrames = frameCount;
        this.loop = loop;
        this.horizontal_total_frame = horizontal_total_frame;

    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setXPos(int value) {
        xPos = value - (spriteWidth/2);
    }

    public void setYPos(int value) {
        yPos = value - (spriteHeight/2);
    }

    public void update(long gameTime) {
        if( gameTime > frameTimer + fps) {
            frameTimer = gameTime;
            currentFrame += 1;

            if( currentFrame >= numFrames ) {
                currentFrame = 0;

                if(!loop) dispose = true;
            }

//            this.sRectangle.left = 0;  //x
             this.sRectangle.top = 0;    //y
//            this.sRectangle.right = spriteWidth;  //w
             this.sRectangle.bottom = spriteHeight;  //h

            sRectangle.left = ((2 % horizontal_total_frame) * 200);
           // sRectangle.top   = ((currentFrame / horizontal_total_frame) * spriteHeight);
            sRectangle.right =  sRectangle.left + spriteWidth ;
            //sRectangle.right =  sRectangle.right+ spriteWidth
        }
    }

    public void draw(Canvas canvas) {
        Rect dest = new Rect(getXPos(), getYPos(), getXPos() + spriteWidth, getYPos() + spriteHeight);
        canvas.drawBitmap(animation, sRectangle, dest, null);
    }
}
