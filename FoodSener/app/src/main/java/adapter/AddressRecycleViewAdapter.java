package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tianyunchen.foodsener.R;

import java.util.List;

/**
 * Created by tianyun chen on 2016/10/3.
 */
public class AddressRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> data;
    public AddressRecycleViewAdapter(Context context,List<String> data){
        this.data =data;
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         AddressViewHodler addressViewHodler = new AddressViewHodler(LayoutInflater.from(context).inflate(R.layout.item_address_recycle,parent,false));
        return addressViewHodler;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if( holder instanceof AddressViewHodler){
            AddressViewHodler addressViewHodler = (AddressViewHodler) holder;
            addressViewHodler.city_tv.setText(data.get(position));

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AddressViewHodler  extends RecyclerView.ViewHolder{
        TextView city_tv;
        public AddressViewHodler(View itemView) {
            super(itemView);
            city_tv = (TextView)itemView.findViewById(R.id.city_tv);
        }
    }
}
