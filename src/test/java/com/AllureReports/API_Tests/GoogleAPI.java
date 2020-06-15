
package com.AllureReports.API_Tests;

import java.util.Iterator;
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
    
    public void display(){
    	System.out.println("The out put is ");
    	Iterator<Key> itr = getKeys().iterator();
    	while(itr.hasNext()){
    	System.out.println("\n"+itr.next().getAlg());
    	}
    }

}
