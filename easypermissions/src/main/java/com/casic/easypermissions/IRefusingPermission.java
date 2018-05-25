package com.casic.easypermissions;

/**
 * Created by pchsun on 2018/5/18.
 */

public interface IRefusingPermission {
    void refusingAgainPermission(int code);
    void refusingPermission(int code);
}
