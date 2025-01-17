package uk.ac.edinburghcollege.coffeeshop.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppConnectivity {

    private Context mContext;


    public AppConnectivity(Context context){
        this.mContext = context;
    }

    public boolean isConnectedToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivity != null){
            NetworkInfo[] info = connectivity.getAllNetworkInfo();

            if(info != null){

                for (int i = 0; i < info.length; i++){

                    if(info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
