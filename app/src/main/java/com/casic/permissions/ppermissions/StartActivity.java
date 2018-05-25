package com.casic.permissions.ppermissions;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.casic.easypermissions.DangerousPermissions;
import com.casic.easypermissions.EasyPermissions;
import com.casic.easypermissions.FirstTimeLoginUtil;
import com.casic.easypermissions.IRefusingPermission;
import com.casic.easypermissions.PermissionsTips;
import com.casic.easypermissions.RequestCode;

/**
 * 启动界面
 * 敏感权限申请在此进行
 * Created by pchsun on 2018/5/17.
 */
public class StartActivity extends AppCompatActivity implements IRefusingPermission {

    private FirstTimeLoginUtil firstTimeLoginUtil;
    private PermissionsTips permissionsTips;
    private String[] permissions = {DangerousPermissions.READ_PHONE_STATE, DangerousPermissions.CAMERA, DangerousPermissions.READ_CALENDAR};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        firstTimeLoginUtil = new FirstTimeLoginUtil(this);
        permissionsTips = new PermissionsTips();
        permissionsTips.setRefusingPermission(this);

        if (EasyPermissions.checkAllDangerousPermissionsBool(this, permissions)) {
            Log.e("EasyPermission", "onCreate所有权限已经开启");
            toMainActivity();
        } else {
            EasyPermissions.requestMultiDangerousPermissions(this, permissions);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstTimeLoginUtil.setState();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case RequestCode.MULTI_PERMISSION_CODE:
                for (int i = 0; i < grantResults.length; i++) {
                    if (!(grantResults[i] == PackageManager.PERMISSION_GRANTED)) {
                        if (!TextUtils.isEmpty(permissions[i])) {
                            PermissionsTips.permissionsDeniedTips(permissions[i]);
                        }
                    }
                }
                if (EasyPermissions.checkAllDangerousPermissionsBool(this, this.permissions)) {
                    Log.e("EasyPermission", "所有权限已经开启");
                    toMainActivity();
                } else {
                    EasyPermissions.refusingHintsPermissionTips(this, this.permissions);
                }
                break;
            case RequestCode.CAMERA_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("EasyPermission", "相机权限获取成功");
                    toMainActivity();
                } else {
                    PermissionsTips.permissionsDeniedTips(permissions[0]);
                    Log.e("EasyPermission", "相机权限获取失败");
                }
                break;
        }
    }

    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void refusingAgainPermission(int code) {
        switch (code) {
            case RequestCode.CAMERA_CODE:
                Log.e("EasyPermission", "相机权限已经被完全拒绝!");
                break;
            case RequestCode.READ_PHONE_STATE_CODE:
                Log.e("EasyPermission", "获取电话信息权限已经被完全拒绝!");
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                dialogBuilder.setTitle("提示");
                dialogBuilder.setMessage("去开启电话权限");
                dialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogBuilder.show();
                break;
            case RequestCode.READ_CALENDAR_CODE:
                Log.e("EasyPermission", "日历权限已经被完全拒绝!");
                break;
        }
    }

    @Override
    public void refusingPermission(int code) {

    }
}
