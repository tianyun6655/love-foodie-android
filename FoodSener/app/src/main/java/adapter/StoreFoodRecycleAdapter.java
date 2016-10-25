package adapter;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianyunchen.foodsener.R;

import java.util.zip.Inflater;

/**
 * Created by tianyun chen on 2016/10/10.
 */
public class StoreFoodRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     private  Context context;
    public StoreFoodRecycleAdapter(Context context){
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          StoreFoodViewHold storeFoodViewHold = new StoreFoodViewHold(LayoutInflater.from(context).inflate(R.layout.item_store_food_recycle,parent,false));
         return storeFoodViewHold;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class StoreFoodViewHold extends RecyclerView.ViewHolder{

        public StoreFoodViewHold(View itemView) {
            super(itemView);
        }
    }
}

