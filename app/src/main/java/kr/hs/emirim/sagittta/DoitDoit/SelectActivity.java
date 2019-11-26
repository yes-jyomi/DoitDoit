package kr.hs.emirim.sagittta.DoitDoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    private TabLayout sTabLayout;

    private ArrayList<Subjects> sList;
    private RecyclerAdapter sAdapter;
    private int count = -1;

    private ViewPager sViewPager;
    private ContentsPagerAdapter sContentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        
        this.sTabLayout = findViewById(R.id.tabLayout);

        sTabLayout.addTab(sTabLayout.newTab().setText("과목"));
        sTabLayout.addTab(sTabLayout.newTab().setText("분량"));
        sTabLayout.addTab(sTabLayout.newTab().setText("날짜"));

        sViewPager = (ViewPager) findViewById(R.id.pager_content);
        sContentPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), sTabLayout.getTabCount());
        sViewPager.setAdapter(sContentPagerAdapter);
        sViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(sTabLayout));
        sTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*

        RecyclerView sRecyclerView = (RecyclerView) findViewById(R.id.subjectRecyclerView);
        LinearLayoutManager sLinearLayoutManager = new LinearLayoutManager(this);
        sRecyclerView.setLayoutManager(sLinearLayoutManager);

        sList = new ArrayList<>();

        sAdapter = new RecyclerAdapter(sList);
        sRecyclerView.setAdapter(sAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(sRecyclerView.getContext(), sLinearLayoutManager.getOrientation());
        sRecyclerView.addItemDecoration(dividerItemDecoration);

        sRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), sRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Subjects subj = sList.get(position);
                Toast.makeText(getApplicationContext(), subj.getSubject(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        */
    }

/*
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private SelectActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final SelectActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

    }

    */
}
