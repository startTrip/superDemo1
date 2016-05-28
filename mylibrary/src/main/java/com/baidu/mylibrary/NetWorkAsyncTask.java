package com.baidu.mylibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

/**
 * Project: MyDemo
 * Author: wm
 * Data:   16-5-27
 */

/**
 *  实现网址的请求，返回字节数组
 */
public class NetWorkAsyncTask extends AsyncTask<String,Integer,byte[]>{

    private Context mContext;
    private NetWorkTaskCallBack mCallback;

    public NetWorkAsyncTask(Context context,NetWorkTaskCallBack callback) {
        mContext = context;
        this.mCallback= callback;
    }

    @Override
    protected byte[] doInBackground(String... params) {
        byte[] ret = null;

        if (params != null) {
            int len = params.length;

            if (len>0) {

                // TODO: 每一次执行网络请求之前，建议检测网络，没有网络就不加载
                ConnectivityManager manager =
                        (ConnectivityManager) mContext.getSystemService
                                (Context.CONNECTIVITY_SERVICE);

                // 返回 null 代表飞行模式
                NetworkInfo info = manager.getActiveNetworkInfo();

                if (info != null) {

                    // TODO: 联网

                    ret=HttpTools.doGet(params[0]);
                }
            }
        }

        return ret;
    }

    @Override
    protected void onPostExecute(byte[] bytes) {

        if (mCallback != null) {
            mCallback.onTaskFinished(bytes);
        }
    }
}
