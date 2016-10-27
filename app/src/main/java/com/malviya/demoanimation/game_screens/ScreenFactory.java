package com.malviya.demoanimation.game_screens;

import android.content.Context;

import com.malviya.demoanimation.constants.Constant;
import com.malviya.demoanimation.game_world.BaseView;
import com.malviya.demoanimation.game_world.GameWorld;


/**
 * Created by Admin on 23-10-2016.
 */

public class ScreenFactory {

    private static ScreenFactory mInstance;
    private static GameWorld view;
    private BaseView mView;

    private ScreenFactory() {

    }

    public static BaseView getInstance(Context pContext, int screen) {
        switch (screen) {
            case Constant.SCREEN_MENU:
                break;
            case Constant.SCREEN_GAME:
                view = new GameWorld(pContext);
                return view;
            case Constant.SCREEN_PAUSE:
                break;
        }

        return view;
    }

}
