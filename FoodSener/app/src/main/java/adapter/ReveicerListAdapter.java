package adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import  android.support.v4.app.*;

import com.example.tianyunchen.foodsener.R;
import com.example.tianyunchen.foodsener.activity.DetailActivity;

/**
 * Created by tianyun chen on 2016/9/29.
 */
public class ReveicerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity context;
    public ReveicerListAdapter (Context context){
        this.context =(Activity) context;
    }
    MyViewHolder myViewHolder;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 把Layout解析出来
        myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_receiver_list,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof MyViewHolder){
                MyViewHolder myViewHolder = (MyViewHolder)holder;
            }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
         /*   ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context,
            v.findViewById(R.id.restanrant_pic), "hello");*/
        //    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(context,v,"hello");
            context.startActivity(intent);
        }
    }
}
