package com.gh.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private List<String> datas = new ArrayList<>();
    private MyAdatpter mAdatpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdatpter = new MyAdatpter(datas);
        mRecycleView.setAdapter(mAdatpter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        // mRecycleView.setLayoutManager(new GridLayoutManager(this,2));
        //mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        mRecycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdatpter.setOnItemClickListener(new MyAdatpter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, String city) {
                Toast.makeText(MainActivity.this, "city:" + city + "position" + position, Toast.LENGTH_LONG);
            }
        });

    }

    private void initDatas() {
        datas.add("Gena's Demo");
        datas.add("China");
        datas.add("Hoston");
        datas.add("Krea");
        datas.add("Chicago");
        datas.add("San Antnio");
        datas.add("Washington");
        datas.add("Las Vegas");
        datas.add("New york");
        datas.add("Boston");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_add:
                mAdatpter.addData(0, "new City");
                break;
            case R.id.id_action_delete:
                mAdatpter.removeData(1);
                break;
            case R.id.id_action_gridview:
                mRecycleView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case R.id.id_action_listview:
                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.id_action_stag:
                mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return true;
    }
}
