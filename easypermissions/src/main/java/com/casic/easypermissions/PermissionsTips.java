package com.casic.easypermissions;

/**
 * Created by pchsun on 2018/5/18.
 */

public class PermissionsTips {

    private static IRefusingPermission iRefusingPermission;

    public void setRefusingPermission(IRefusingPermission iRefusingPermission) {
        this.iRefusingPermission = iRefusingPermission;
    }

    /**
     * 用户点击拒绝授权的提示
     *
     * @param permission
     */
    public static void permissionsDeniedTips(String permission) {
        //此时可以提示用户不开启权限有什么影响
        iRefusingPermission.refusingPermission(Permission2Code.getRequestCode(permission));
    }

    /**
     * 用户选择不再提示，并点击拒绝，再次进入APP时执行
     *
     * @param permission
     */
    public static void refusingHintsTips(String permission) {
        //此时可以弹出对话框，引导用户进入设置界面开启权限
        iRefusingPermission.refusingAgainPermission(Permission2Code.getRequestCode(permission));
    }
}
