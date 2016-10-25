package fragment;

/**
 * Created by tianyun chen on 2016/10/10.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianyunchen.foodsener.R;

import adapter.StoreFoodRecycleAdapter;
import dao.LoginDao;

public class StoreFragment extends Fragment{
   private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view  = inflater.inflate(R.layout.fragment_store,container,false);
         initViews(view);
         bandAdapter();
         return view;
    }

    private void initViews(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.store_food_recycle);

    }

    private void bandAdapter(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new StoreFoodRecycleAdapter(getActivity()));
        recyclerView.addItemDecoration(new MyItemDecoration(5,getActivity()));

    }

    private   class MyItemDecoration extends RecyclerView.ItemDecoration{
        private int offset;
        private Drawable drawable;
        private  final int[] ATTRS = new int[]{android.R.attr.listDivider};

        public
        MyItemDecoration(int offset, Context context){
            this.offset = offset;
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            drawable = a.getDrawable(0);
            a.recycle();
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            outRect.set(0, 0, 0, drawable.getIntrinsicHeight());
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            Log.d("MyItem","hello");
               drawHorizontalLine(c,parent,state);
        }

        private void drawHorizontalLine(Canvas c,RecyclerView parent,RecyclerView.State state){
            int left = parent.getPaddingLeft();
            int right = parent.getWidth()-parent.getPaddingRight();
            final  int childcount1 = parent.getChildCount();
            Log.d("childcount",childcount1+"");
            for(int i =0;i<childcount1;i++){
                final  View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
                final int top  = child.getBottom()+params.bottomMargin;
                final int bottom = top+drawable.getIntrinsicHeight();
                drawable.setBounds(left,top,right,bottom);
                drawable.draw(c);

            }
        }
    }
}
