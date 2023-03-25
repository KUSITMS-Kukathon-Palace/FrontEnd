package com.example.palace;

public class ListItem2 {

    String DateTv;
    Integer PlaceImg;
    String PlaceNTv;
    String LocationTv;
    String GroupNTv;
    String ReserCountTv;
    Integer ListBtn;

    public ListItem2(String DateTv, Integer PlaceImg, String PlaceNTv, String LocationTv, String GroupNTv,
                    String ReserCountTv, Integer ListBtn) {
        this.DateTv = DateTv;
        this.PlaceImg = PlaceImg;
        this.PlaceNTv = PlaceNTv;
        this.LocationTv = LocationTv;
        this.GroupNTv = GroupNTv;
        this.ReserCountTv = ReserCountTv;
        this.ListBtn = ListBtn;

    }

    public String getDateTv() { return DateTv; }

    public Integer getPlaceImg() {
        return PlaceImg;
    }

    public String getPlaceNTv() { return PlaceNTv; }

    public String getLocationTv() { return LocationTv; }

    public String getGroupNTv() {
        return GroupNTv;
    }

    public String getReserCountTv() { return ReserCountTv; }

    public Integer getListBtn() {
        return ListBtn;
    }

}
