package com.transact.main.smart_home.beans;

import java.util.ArrayList;

/**
 * Created by patilsp on 11/5/2017.
 */

public class SmartHomeCollector {

    private House house;
    private ArrayList<Room> alRooms;
    private ArrayList<Peripheral> alPeripherals;

    private ArrayList<Device> alDevices = new ArrayList<>();
    private ArrayList<SHUser> alUsers = new ArrayList<>();

    public ArrayList<Device> getAlDevices() {
        return alDevices;
    }

    public ArrayList<SHUser> getAlUsers() {
        return alUsers;
    }

    private static SmartHomeCollector homeCollector;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public ArrayList<Room> getAlRooms() {
        return alRooms;
    }

    public void setAlRooms(ArrayList<Room> alRooms) {
        this.alRooms = alRooms;
    }

    public ArrayList<Peripheral> getAlPeripherals() {
        return alPeripherals;
    }

    public void setAlPeripherals(ArrayList<Peripheral> alPeripherals) {
        this.alPeripherals = alPeripherals;
    }

    public static SmartHomeCollector getHomeCollectorObj(int owner_id) {
        /* TODO
         * Check whether house is already stored.
         * if stored in local memory retrieve from their
         *
         */

        if (homeCollector == null) {
            homeCollector = new SmartHomeCollector();
            House house = new House(123, "Sanjeevan House", 123, "333");
            homeCollector.setHouse(house);
            homeCollector.setAlRooms(new ArrayList<>());

            Room room1 = new Room(1, 123, "Hall", 101, false);

            ArrayList<Peripheral> al_peripherals = new ArrayList<>();
            al_peripherals.add(new Peripheral(1, 1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 1", Peripheral.Status.OFF, 100, false));
            al_peripherals.add(new Peripheral(2, 1, Peripheral.PERIPHERAL_TYPE.FRIDGE, "Fridge", Peripheral.Status.ON, 0, false));
            al_peripherals.add(new Peripheral(3, 1, Peripheral.PERIPHERAL_TYPE.FAN, "Fan", Peripheral.Status.ON, 100, false));
            al_peripherals.add(new Peripheral(4, 1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 2", Peripheral.Status.ON, 10, false));
            al_peripherals.add(new Peripheral(5, 1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 3", Peripheral.Status.ON, 50, false));
            al_peripherals.add(new Peripheral(6, 1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 4", Peripheral.Status.ON, 100, false));

            al_peripherals.add(new Peripheral(13, 1, Peripheral.PERIPHERAL_TYPE.UNDERGROUND_WATER_TANK, "Underground Water Tank", Peripheral.Status.ON, 50, false));
            al_peripherals.add(new Peripheral(14, 1, Peripheral.PERIPHERAL_TYPE.TERRES_WATER_TANK, "Terres Water Tank", Peripheral.Status.ON, 90, false));

            homeCollector.setAlPeripherals(al_peripherals);

            //ArrayList<Peripheral> al_peripheralsQuickOptions= new ArrayList<>();
            // al_peripheralsQuickOptions.add(new Peripheral(Peripheral.PERIPHERAL_TYPE.ROOM_SWITCH, "Switch", Peripheral.Status.ON, 100));
            // room1.setAl_peripheralsQuickAccess(al_peripheralsQuickOptions);

  /*      Peripheral p1 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 1", Peripheral.Status.ON, 100);
        Peripheral p2 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.FRIDGE, "Fridge", Peripheral.Status.ON, 0);
        Peripheral p3 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.FAN, "Fan", Peripheral.Status.ON, 100);
        Peripheral p4 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 2", Peripheral.Status.ON, 100);
        Peripheral p5 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 3", Peripheral.Status.ON, 100);
        Peripheral p6 =new Peripheral(room1, Peripheral.PERIPHERAL_TYPE.BULB, "BULB 4", Peripheral.Status.ON, 100);
*/

            Room room2 = new Room(2, 123, "Kitchen", 101, true);

            Room room3 = new Room(3, 123, "Sans Room", 102, false);

            Room room4 = new Room(4, 123, "Govinds Room", 102, true);

            Room room5 = new Room(5, 123, "Kapil & Vijen Room", 103, false);

            homeCollector.getAlRooms().add(room1);
            homeCollector.getAlRooms().add(room2);
            homeCollector.getAlRooms().add(room3);
            homeCollector.getAlRooms().add(room4);
            homeCollector.getAlRooms().add(room5);

            //  public Device(int device_id, int house_id, String device_phy_id, String dev_mac_addr, String local_ip_addr) {
            ArrayList<Device> alDevices = new ArrayList<>();
            homeCollector.getAlDevices().add(new Device(101, 123, "phy1", "23:32:23:23", "192.168.1.4"));
            homeCollector.getAlDevices().add(new Device(102, 123, "phy2", "23:32:23:24", "192.168.1.5"));
            homeCollector.getAlDevices().add(new Device(103, 123, "phy3", "23:32:23:25", "192.168.1.6"));

            homeCollector.getAlUsers().add(new SHUser(123, "123", "Sandeep"));
            homeCollector.getAlUsers().add(new SHUser(123, "123", "Gov"));
            homeCollector.getAlUsers().add(new SHUser(123, "123", "Vij"));
            homeCollector.getAlUsers().add(new SHUser(123, "123", "Kapil"));

        }

        return homeCollector;


    }

}
