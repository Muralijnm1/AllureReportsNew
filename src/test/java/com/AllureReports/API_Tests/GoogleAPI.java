
package com.AllureReports.API_Tests;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleAPI {

    @SerializedName("keys")
    @Expose
    private List<Key> keys = null;

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

}
