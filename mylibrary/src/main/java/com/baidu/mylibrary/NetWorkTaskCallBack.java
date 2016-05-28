package com.baidu.mylibrary;

/**
 * Project: MyDemo
 * Author: wm
 * Data:   16-5-27
 */
public interface NetWorkTaskCallBack {

    /**
     *  当 NetWorkTask 执行完成，会回调这个接口方法
     * @param data
     */
    void onTaskFinished(byte[] data);
}
