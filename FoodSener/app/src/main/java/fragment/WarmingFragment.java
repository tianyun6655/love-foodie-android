package fragment;

/**
 * Created by tianyun chen on 2016/10/10.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tianyunchen.foodsener.R;
import com.example.tianyunchen.foodsener.activity.CreateStoreActivity;

public class WarmingFragment extends  Fragment implements View.OnClickListener {
  private Button btn_create;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warming,container,false);
        initViews(view);
        return view;
    }

    private  void initViews(View view){
        btn_create = (Button)view.findViewById(R.id.btn_create);
        btn_create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==btn_create.getId()){
            Intent intent = new Intent(getActivity(), CreateStoreActivity.class);
            getActivity().startActivityForResult(intent,1);
            getActivity().overridePendingTransition(R.anim.slide_bottom,R.anim.slide_bottom_out);

        }
    }
}
