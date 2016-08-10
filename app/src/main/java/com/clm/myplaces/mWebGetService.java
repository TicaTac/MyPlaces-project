package com.clm.myplaces;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class mWebGetService extends IntentService {
    final String ACTION_QUERY="query";
    String query;


    mGetJsonHelper jsonHelper;
    public mWebGetService(String name) {
        super(name);
        query=null;

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            query=intent.getStringExtra(ACTION_QUERY);
            jsonHelper= new mGetJsonHelper();
            jsonHelper.getJsonQuery(mConstants.QUERY_URL_HTTPS+query+mConstants.QUERY_URL_KEY);

        }
    }

}
