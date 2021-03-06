package com.company.threebutton.tuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.company.threebutton.data.DataGenerator;
import com.company.threebutton.model.People;
import com.material.components.R;
import com.company.threebutton.adapter.AdapterListBasic;

import java.util.List;

public class OrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterListBasic mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        //more code here

        initComponent(view);
        return view;
    }

    private void initComponent(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerView.setHasFixedSize(true);

        List<People> items = DataGenerator.getPeopleData(v.getContext());
        items.addAll(DataGenerator.getPeopleData(v.getContext()));
        items.addAll(DataGenerator.getPeopleData(v.getContext()));

        //set data and list adapter
        mAdapter = new AdapterListBasic(v.getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int position) {
                viewOrder(obj);
                System.out.println("Fuck off this shit im done");
            }
        });

    }

    private void viewOrder(People obj) {
        Intent intent = new Intent(getActivity(), ShoppingCheckoutTimeline.class);
        intent.putExtra("fuck you", "fuck");
        startActivity(intent);
    }
}
