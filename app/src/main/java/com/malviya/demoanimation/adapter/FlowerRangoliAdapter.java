package com.malviya.demoanimation.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.malviya.demoanimation.R;
import com.malviya.demoanimation.activity.FlowerRangoliFullScreenActivity;
import com.malviya.demoanimation.data_model.Information;
import com.malviya.demoanimation.utilies.Utilities;

import java.util.ArrayList;

/**
 * Created by Prafulla on 10/26/2016.
 */

public class FlowerRangoliAdapter extends RecyclerView.Adapter<FlowerRangoliAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Information> data;
    private LayoutInflater inflater;

    public FlowerRangoliAdapter(Context context, ArrayList<Information> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.textview.setText(data.get(position).title);
        Bitmap bitmap = Utilities.decodeSampledBitmapFromResource(context.getResources(), data.get(position).imageId);
        myViewHolder.imageView.setImageBitmap(bitmap);
        //final int currentPosition = position;
        final Information infoData = data.get(position);

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Toast.makeText(context, "OnClick Called at position " + position, Toast.LENGTH_SHORT).show();
                Intent image = new Intent(context, FlowerRangoliFullScreenActivity.class);
                image.putExtra("position", position);
                context.startActivity(image);
                //addItem(currentPosition, infoData);
            }
        });

        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getShareData("Happy Diwali", infoData.title, infoData.imageId);
                return true;
            }
        });
    }

    /**
     * Returns a share intent
     */
    private void getShareData(String subject, String shareText, int shareImg) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        sharingIntent.setType("text/plain");
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        Uri uri = Uri.parse("android.resource://com.malviya.rangoliproject/drawable/" + R.drawable.rangoli1);
        Toast.makeText(context, "Image No: " + uri.getPath() + ".jpg", Toast.LENGTH_SHORT).show();
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri.getPath() + ".jpg");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textview;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textview = (TextView) itemView.findViewById(R.id.txv_row);
            imageView = (ImageView) itemView.findViewById(R.id.img_row);
        }
    }
}
