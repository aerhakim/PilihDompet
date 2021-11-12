package io.github.aerhakim.pilihdompet.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPromo {

    @SerializedName("users")
    List<Promo> promoList;
    String error;

    public GetPromo(List<Promo> promoList, String error) {
        this.promoList = promoList;
        this.error = error;
    }

    public List<Promo> getPromoList() {
        return promoList;
    }

    public String getError() {
        return error;
    }


}