package com.transact.main.smart_home.beans;

import java.io.Serializable;

import static com.transact.main.smart_home.beans.PhyPeripheral.PERIPHERAL_TYPE.DT1;

/**
 * Created by patilsp on 10/14/2017.
 */

public class PhyPeripheral implements Serializable {
    private int pid;    //per_id
    private int pval;   //per_value

    //private PERIPHERAL_TYPE pty; //peripheral_type

//  private String ppi; //per_phy_id;
//  private String plpi;          //platform_phy_id;


    enum PERIPHERAL_TYPE {
        DG1, /* DEVICE_GENERIC_TYPE_1. */
        DT1, /* DEVICE_TRIGGER_TYPE_1. */
    }

    public PhyPeripheral() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPval() {
        return pval;
    }

    public void setPval(int pval) {
        this.pval = pval;
    }

/*
    public PERIPHERAL_TYPE getPty() {
        return pty;
    }

    public void setPty(PERIPHERAL_TYPE pty) {
        this.pty = pty;
    }

*/

    @Override
    public String toString() {
        return "PhyPeripheral{" +
                "pid=" + pid +
                ", pval=" + pval +
//                   ", pty=" + pty +
                '}';
    }
}
