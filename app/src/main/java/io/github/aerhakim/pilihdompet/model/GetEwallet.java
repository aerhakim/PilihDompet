package io.github.aerhakim.pilihdompet.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetEwallet {

    @SerializedName("users")
    List<Ewallet> ewalletList;
    String error;

    public GetEwallet(List<Ewallet> ewalletList, String error) {
        this.ewalletList = ewalletList;
        this.error = error;
    }

    public List<Ewallet> getEwalletList() {
        return ewalletList;
    }

    public String getError() {
        return error;
    }


}
