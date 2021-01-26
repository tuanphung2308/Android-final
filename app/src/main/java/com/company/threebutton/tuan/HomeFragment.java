package com.company.threebutton.tuan;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.material.components.R;
import com.company.threebutton.adapter.AdapterSnapGeneric;
import com.company.threebutton.data.DataGenerator;
import com.company.threebutton.helper.StartSnapHelper;
import com.company.threebutton.model.Image;

import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initComponent(view);
        //more code here
        return view;
    }

    private void initComponent(View v) {
        final ProgressBar progressBar = (ProgressBar) v.findViewById(R.id.progress);
        progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        // generate data
        List<Image> items = DataGenerator.getImageDate(getActivity()).subList(0, 5);

        recyclerView.setAdapter(new AdapterSnapGeneric(getActivity(), items, R.layout.item_snap_full));
        recyclerView.setOnFlingListener(null);

        progressBar.setMax(items.size());
        progressBar.setProgress(1);
        StartSnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);
        startSnapHelper.setSnapPositionListener(new StartSnapHelper.SnapPositionListener() {
            @Override
            public void position(View view, int position) {
                progressBar.setProgress(position + 1);
            }
        });
    }
}
