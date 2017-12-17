package com.transact.main.smart_home.beans;

import java.util.ArrayList;

/**
 * Created by patilsp on 11/13/2017.
 */

public class DevicePeripheralList {

    private int device_id;
    private int house_id;
    private String device_phy_id;
    private String dev_mac_addr;
    private String local_ip_addr;

    public ArrayList<PhyPeripheral> alPeripherals;
    public DevicePeripheralList() {
    }

    public DevicePeripheralList(int device_id, int house_id, String device_phy_id, String dev_mac_addr, String local_ip_addr) {
        this.device_id = device_id;
        this.house_id = house_id;
        this.device_phy_id = device_phy_id;
        this.dev_mac_addr = dev_mac_addr;
        this.local_ip_addr = local_ip_addr;
    }

    public int getDevice_id() {
        return device_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public String getDevice_phy_id() {
        return device_phy_id;
    }

    public String getDev_mac_addr() {
        return dev_mac_addr;
    }

    public String getLocal_ip_addr() {
        return local_ip_addr;
    }

    @Override
    public String toString() {
        return "DevicePeripheralList{" +
                "device_id=" + device_id +
                ", house_id=" + house_id +
                ", device_phy_id='" + device_phy_id + '\'' +
                ", dev_mac_addr='" + dev_mac_addr + '\'' +
                ", local_ip_addr='" + local_ip_addr + '\'' +
                ", alPeripherals=" + alPeripherals +
                '}';
    }
}
