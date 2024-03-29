package com.example.testnewtronic;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DataResponse {
    @SerializedName("data")
    private List<Data> dataList;
    private int status;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

