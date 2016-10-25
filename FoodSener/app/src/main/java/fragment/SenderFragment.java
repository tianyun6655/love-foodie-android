package fragment;

import android.support.v4.app.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianyunchen.foodsener.R;

/**
 * Created by tianyun chen on 2016/9/29.
 */
public class SenderFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             View view = inflater.inflate(R.layout.fragment_sender,container,false);
        return view;
}
}
