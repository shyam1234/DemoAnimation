package com.malviya.demoanimation.image_data_store;



import com.malviya.demoanimation.R;
import com.malviya.demoanimation.data_model.Information;

import java.util.ArrayList;

/**
 * Created by Prafulla on 10/26/2016.
 */

public class DataDotRangoli {
    public static ArrayList<Information> getData() {

        ArrayList<Information> data1 = new ArrayList<>();

        int[] images = {
                R.drawable.pattern_dots_r1,
                R.drawable.pattern_dots_r2,
                R.drawable.pattern_dots_r3,
                R.drawable.pattern_dots_r4,
                R.drawable.pattern_dots_r5,
                R.drawable.pattern_dots_r6,
                R.drawable.pattern_dots_r7,
                R.drawable.pattern_dots_r8,
                R.drawable.pattern_dots_r9,
                R.drawable.pattern_dots_r10,
                R.drawable.pattern_dots_r11,
                R.drawable.pattern_dots_r12,
                R.drawable.pattern_dots_r13,
                R.drawable.pattern_dots_r14,
                R.drawable.pattern_dots_r15,
                R.drawable.pattern_dots_r16,
                R.drawable.pattern_dots_r17,
                R.drawable.pattern_dots_r18,
                R.drawable.pattern_dots_r19,
                R.drawable.pattern_dots_r20,
                R.drawable.pattern_dots_r21,
                R.drawable.pattern_dots_r22,
                R.drawable.pattern_dots_r23,
                R.drawable.pattern_dots_r24,
                R.drawable.pattern_dots_r25,
                R.drawable.pattern_dots_r26,
                R.drawable.pattern_dots_r27
        };

        String[] Categories = {"Rangoli 1", "Rangoli 2", "Rangoli 3", "Rangoli 4", "Rangoli 5", "Rangoli 6", "Rangoli 7",
                "Rangoli 8", "Rangoli 9", "Rangoli 10", "Rangoli 11", "Rangoli 12",
                "Rangoli 13", "Rangoli 14", "Rangoli 15", "Rangoli 16", "Rangoli 13", "Rangoli 14", "Rangoli 15", "Rangoli 16",
                "Rangoli 13", "Rangoli 14", "Rangoli 15", "Rangoli 16", "Rangoli 13", "Rangoli 14", "Rangoli 15"
        };

        for (int i = 0; i < images.length; i++) {

            Information current = new Information();
            current.title = Categories[i];
            current.imageId = images[i];

            data1.add(current);
        }

        return data1;
    }
}
