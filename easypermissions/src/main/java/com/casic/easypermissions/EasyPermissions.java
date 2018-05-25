package com.casic.easypermissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

/**
 * Created by pchsun on 2018/5/17.
 */

public class EasyPermissions implements DangerousPermissions, RequestCode {

    /**
     * 检查单个权限是否开启
     *
     * @param activity
     * @param permission
     * @return
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static boolean checkDangerousPermissions(Activity activity, String permission) {
        return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 检查APP所需权限是否已经全部开启
     *
     * @param activity
     * @param permissions
     * @return boolean
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static boolean checkAllDangerousPermissionsBool(Activity activity, String[] permissions) {
        for (String permission : permissions) {
            if (permission != null)
                if (!checkDangerousPermissions(activity, permission)) {
                    return false;
                }
        }
        return true;
    }

    /**
     * 检查APP需要，但未开启的权限
     *
     * @param activity
     * @param permissions
     * @return String[]
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static String[] checkAllDangerousPermissions(Activity activity, String[] permissions) {
        ArrayList<String> permissionDeniedList = new ArrayList<>();
        for (String permission : permissions) {
            if (permission != null)
                if (!checkDangerousPermissions(activity, permission)) {
                    permissionDeniedList.add(permission);
                }
        }
        String[] permissionDenied = new String[permissionDeniedList.size()];
        permissionDeniedList.toArray(permissionDenied);
        return permissionDenied;
    }

    /**
     * 申请单个危险权限
     *
     * @param activity
     * @param permission
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static void requestSingleDangerousPermissions(Activity activity, String permission) {
        if (!checkDangerousPermissions(activity, permission)) {
            int requestCode = Permission2Code.getRequestCode(permission);
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
        }
    }


    /**
     * 申请多个危险权限
     *
     * @param activity
     * @param permissions
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static void requestMultiDangerousPermissions(Activity activity, String[] permissions) {
        if (permissions.length == 0) {
            return;
        }
        String[] permissionDenieds = checkAllDangerousPermissions(activity, permissions);
        ArrayList<String> permissionDeniedList = new ArrayList<>();
        for (String permissionDenied : permissionDenieds){
            permissionDeniedList.add(permissionDenied);
        }
        String[] permissionRefusings = shouldShowRequestPermissions(activity, permissions);
        for (String permissionRefusing : permissionRefusings){
            permissionDeniedList.remove(permissionRefusing);
        }
        permissionDeniedList.toArray(permissionDenieds);
        if (permissionDenieds != null && permissionDenieds.length != 0)
            ActivityCompat.requestPermissions(activity, permissionDenieds, RequestCode.MULTI_PERMISSION_CODE);
    }

    /**
     * 获取APP所需权限中被用户完全禁用的权限（不提示开启权限）
     *
     * @param activity
     * @param permissions
     * @return
     */
    public static String[] shouldShowRequestPermissions(Activity activity, String[] permissions) {
        ArrayList<String> permissionDeniedList = new ArrayList<>();
        for (String permission : permissions) {
            if (permission != null)
                if (!checkDangerousPermissions(activity, permission)) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                        if (!(new FirstTimeLoginUtil(activity).getState())) {
                            permissionDeniedList.add(permission);
                        }
                    }
                }
        }
        String[] permissionDenied = new String[permissionDeniedList.size()];
        permissionDeniedList.toArray(permissionDenied);
        return permissionDenied;
    }

    /**
     * 给予APP所需权限中被用户完全禁用的相应提示
     * @param activity
     * @param permissions
     * @return
     */
    public static void refusingHintsPermissionTips(Activity activity, String[] permissions) {
        String[] shouldShowRequestPermissions = EasyPermissions.shouldShowRequestPermissions(activity, permissions);
        for (String shouldShowRequestPermission : shouldShowRequestPermissions) {
            if (shouldShowRequestPermission != null) {
                PermissionsTips.refusingHintsTips(shouldShowRequestPermission);
            }
        }
    }

}
