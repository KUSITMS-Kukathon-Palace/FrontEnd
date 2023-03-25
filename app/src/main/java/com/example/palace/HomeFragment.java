package com.example.palace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public HomeAdapter adapter;
    public ArrayList<HomeItem> hItem;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =(ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new HomeAdapter();
        recyclerView.setAdapter(adapter);
        hItem = new ArrayList<>();
        hItem.add(new HomeItem("경영관 SKT홀", R.drawable.image_01, "서울특별시 성동구 왕십리로 222 한양대학교 경영관", "세미나실", 300));
        hItem.add(new HomeItem("한양플라자(학생복지관) 연습실", R.drawable.image_02, "서울특별시 성동구 왕십리로 222 한양대학교 학생복지관", "세미나실", 80));
        hItem.add(new HomeItem("HIT 6층 세미나실",  R.drawable.image_03, "서울특별시 성동구 왕십리로 222 한양대학교 HIT", "세미나실", 50));
        hItem.add(new HomeItem("학생회관 체육관", R.drawable.image_04,"서울특별시 성동구 왕십리로 222 학생회관", "체육관", 200));
        hItem.add(new HomeItem("올림픽 체육관B1", R.drawable.image_05,"서울특별시 성동구 왕십리로 222 올림픽체육관", "체육관", 500));
        hItem.add(new HomeItem("프로젝트룸Make",  R.drawable.image_06,"서울특별시 동작구 상도로 369 벤처관 3층", "세미나실", 72));
        hItem.add(new HomeItem("프로젝트룸 Passion",  R.drawable.image_07,"서울특별시 동작구 상도로 369 벤처관 1층", "멀티미디어실", 20));
        hItem.add(new HomeItem("프로젝트룸Make",  R.drawable.image_08,"서울특별시 동작구 상도로 369 벤처관 2층", "세미나실", 40));
        hItem.add(new HomeItem("첨단강의실(국제회의장)",R.drawable.image_09, "서울특별시 마포구 와우산로 94", "세미나실", 327));
        hItem.add(new HomeItem("대회의실", R.drawable.image_10,"서울특별시 마포구 와우산로 94", "세미나실", 200));
        hItem.add(new HomeItem("세미나실",  R.drawable.image_11,"서울특별시 마포구 와우산로 94", "세미나실", 50));
//        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
//        list = HomeDataView.createContactList();
//        recyclerView.setHasFixedSize(true);
//        homeViewAdapter = new HomeViewAdapter(getActivity(), list);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(homeViewAdapter);
        return rootView;
//        Log.d("Home", "homefrag");
//        //백엔드 연동
//        RetrofitAPI retrofitAPI = RetrofitClient.getInstance().create(RetrofitAPI.class);
//        Call<List<HomeData>> call = retrofitAPI.getHomeData();
//        call.enqueue(new Callback<List<HomeData>>() {
//            //성공
//            @Override
//            public void onResponse(Call<List<HomeData>> call, Response<List<HomeData>> response) {
//                getDataList(response.body());
//                Log.d("HOME", "성공");
//            }
//
//            //실패
//            @Override
//            public void onFailure(Call<List<HomeData>> call, Throwable t) {
//
//            }
//        });
    }

//    private void initUI(ViewGroup rootView)
//    {
//        recyclerView = rootView.findViewById(R.id.rv);
//        LinearLayoutManager lm = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(lm);
//        homeViewAdapter = new HomeViewAdapter();
//        homeViewAdapter.addItem(new HomeDataView("경영관 SKT홀", "서울특별시 성동구 왕십리로 222 한양대학교 경영관", "세미나실", 300));
//        homeViewAdapter.addItem(new HomeDataView("한양플라자(학생복지관) 연습실", "서울특별시 성동구 왕십리로 222 한양대학교 학생복지관", "세미나실", 80));
//        homeViewAdapter.addItem(new HomeDataView("HIT 6층 세미나실", "서울특별시 성동구 왕십리로 222 한양대학교 HIT", "세미나실", 50));
//        homeViewAdapter.addItem(new HomeDataView("학생회관 체육관", "서울특별시 성동구 왕십리로 222 학생회관", "체육관", 200));
//        homeViewAdapter.addItem(new HomeDataView("올림픽 체육관B1", "서울특별시 성동구 왕십리로 222 올림픽체육관", "체육관", 500));
//        homeViewAdapter.addItem(new HomeDataView("프로젝트룸Make", "서울특별시 동작구 상도로 369 벤처관 3층", "세미나실", 72));
//        homeViewAdapter.addItem(new HomeDataView("프로젝트룸 Passion", "서울특별시 동작구 상도로 369 벤처관 1층", "멀티미디어실", 20));
//        homeViewAdapter.addItem(new HomeDataView("프로젝트룸Make", "서울특별시 동작구 상도로 369 벤처관 2층", "세미나실", 40));
//        homeViewAdapter.addItem(new HomeDataView("첨단강의실(국제회의장)", "서울특별시 마포구 와우산로 94", "세미나실", 327));
//        homeViewAdapter.addItem(new HomeDataView("대회의실", "서울특별시 마포구 와우산로 94", "세미나실", 200));
//        homeViewAdapter.addItem(new HomeDataView("세미나실", "서울특별시 마포구 와우산로 94", "세미나실", 50));
//    }
//    private void getDataList(List<HomeData> homeData) {
//        recyclerView = rootView.findViewById(R.id.rv);
//        adapter = new HomeAdapter(getActivity(), homeData);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        Log.e("Frag: ", "HOMEFRAG");
//    }
}