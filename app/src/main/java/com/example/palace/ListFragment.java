package com.example.palace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    public ReservationRecyclerAdapter mRecyclerAdapter;
    public ReservationRecyclerAdapter2 mRecyclerAdapter2;

    public ArrayList<ListItem> mListItem;
    public ArrayList<ListItem2> mListItem2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler);
        RecyclerView mRecyclerView2 = rootView.findViewById(R.id.recycler2);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        /* initiate adapter */
        mRecyclerAdapter = new ReservationRecyclerAdapter();
        mRecyclerAdapter2 = new ReservationRecyclerAdapter2();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView2.setAdapter(mRecyclerAdapter2);

        mListItem = new ArrayList<>();
        mListItem.add(new ListItem("2023년 3월 30일 12:00 - 19:00", R.drawable.list_place_1, "한양대학교 - 경영관 SK홀", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_wait_btn));
        mListItem.add(new ListItem("2023년 4월 11일 12~19시", R.drawable.list_place_2, "숭실대 - 프로젝트룸 Passion", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_suc_btn));
        mListItem.add(new ListItem("2023년 4월 13일 12:00 - 19:00", R.drawable.list_place_3, "한양대 - 학생회관 체육실", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_x_btn));
        mRecyclerAdapter.setDonationList(getContext(), mListItem);

        mListItem2 = new ArrayList<>();
        mListItem2.add(new ListItem2("2023년 1월 15일 12:00 - 19:00", R.drawable.list_place_4, "한양대학교 - 경영관 SK홀", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_fin_btn));
        mListItem2.add(new ListItem2("2023년 1월 11일 12:00 - 19:00", R.drawable.list_place_5, "홍익대 - 학생회관 체육실", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_fin_btn));
        mListItem2.add(new ListItem2("2023년 1월 10일 12:00 - 19:00", R.drawable.list_place_6, "한양대 - 학생회관 체육실", "서울특별시 성동구 왕십리로 222", "큐시즘 27기", "예약인원 72명", R.drawable.list_fin_btn));
        mRecyclerAdapter2.setDonationList(getContext(), mListItem2);


        TabHost tabHost1 = rootView.findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("예약 진행") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("사용완료") ;
        tabHost1.addTab(ts2) ;

        return rootView;
    }
}