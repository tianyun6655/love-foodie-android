package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;

import com.example.tianyunchen.foodsener.R;
import com.example.tianyunchen.foodsener.activity.FoodDetailActivity;

/**
 * Created by tianyun chen on 2016/10/5.
 */
public class SubFoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

   public  SubFoodAdapter (Context context){
        this.context =context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FoodViewHolder foodViewHolder = new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_food_recycle,parent,false));

        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    private class FoodViewHolder extends RecyclerView.ViewHolder{

        public FoodViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(context, FoodDetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
