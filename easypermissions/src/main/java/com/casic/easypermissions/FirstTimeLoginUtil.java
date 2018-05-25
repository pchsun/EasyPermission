package com.casic.easypermissions;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 用来判断用户是不是第一次进入APP
 * Created by pchsun on 2018/5/18.
 */

public class FirstTimeLoginUtil {

    private SharedPreferences sharedPreferences;

    public FirstTimeLoginUtil(Context context) {
        sharedPreferences = context.getSharedPreferences("EasyPermission", Context.MODE_PRIVATE);
    }

    /**
     * 设置状态  true为安装后第一次登录，false为已经登录过
     **/
    public void setState() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstTimeLoginStatus", false);
        editor.commit();
    }

    /***
     * 获取状态
     ***/
    public boolean getState() {
        boolean status = sharedPreferences.getBoolean("firstTimeLoginStatus", true);
        return status;
    }

}
