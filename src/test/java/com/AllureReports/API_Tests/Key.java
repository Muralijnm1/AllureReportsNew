
package com.AllureReports.API_Tests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key {

    @SerializedName("kid")
    @Expose
    private String kid;
    @SerializedName("e")
    @Expose
    private String e;
    @SerializedName("alg")
    @Expose
    private String alg;
    @SerializedName("use")
    @Expose
    private String use;
    @SerializedName("n")
    @Expose
    private String n;
    @SerializedName("kty")
    @Expose
    private String kty;

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

}
