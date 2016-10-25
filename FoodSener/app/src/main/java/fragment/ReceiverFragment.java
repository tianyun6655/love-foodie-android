package fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.*;

import com.example.tianyunchen.foodsener.R;

import adapter.ReveicerListAdapter;

/**
 * Created by tianyun chen on 2016/9/29.
 */
public class ReceiverFragment extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view =  inflater.inflate(R.layout.fragment_receiver,container,false);
        initViews(view);
        bandAdapter();
        return view;
    }


    private void initViews(View view){
         recyclerView =(RecyclerView)view.findViewById(R.id.recycle_view);
         recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
          recyclerView.addItemDecoration(new MyItemDecoration(10));

    }

    private void bandAdapter(){
        ReveicerListAdapter reveicerListAdapter = new ReveicerListAdapter(getActivity());
        recyclerView.setAdapter(reveicerListAdapter);

    }


    private   class MyItemDecoration extends RecyclerView.ItemDecoration{
        private int offset;
        public MyItemDecoration(int offset){
            this.offset = offset;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            outRect.bottom = offset;
        }
    }
}
