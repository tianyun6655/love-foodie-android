package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianyunchen.foodsener.R;

/**
 * Created by tianyun chen on 2016/10/5.
 */
public class SubRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private Context context;
    private SubCallBack subCallBack;

  public   SubRecycleAdapter(Context context){
        this.context =context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SubViewHolder subViewHolder = new SubViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sub_recycle,parent,false));

        return subViewHolder;
    }

    public void setSubCallBack(SubCallBack subCallBack) {
        this.subCallBack = subCallBack;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof SubViewHolder){

        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public void onClick(View v) {
        subCallBack.startAnimation(v.getX());
    }


    private class  SubViewHolder extends RecyclerView.ViewHolder{

        public SubViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(SubRecycleAdapter.this);
        }
    }

    public interface SubCallBack{
        public  void startAnimation( float x);

    }
}
