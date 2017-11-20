package com.transact.main.smart_home;

import com.transact.main.config.ResponseStatus;
import com.transact.main.login.User;
import com.transact.main.smart_home.beans.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/smart_home")
public class SmartHomeController {
    StringBuffer str;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "/get_house", method = RequestMethod.POST)
    public ResponseEntity<SmartHomeCollector> getHouseCollectorObj(@RequestBody User user) {
        if (user == null) {
            System.out.println("User object is null, can com.transact.main.login ");
        }


        System.out.println("User trying to get house details");

        return new ResponseEntity<SmartHomeCollector>(SmartHomeCollector.getHomeCollectorObj(user.getUser_id()), HttpStatus.OK);
    }

    @RequestMapping(value = "/update_peripherals", method = RequestMethod.POST)
    public ResponseEntity<ResponseStatus> updatePeripherals(@RequestBody ArrayList<Peripheral> alPeripherals) {
        if (alPeripherals == null) {
            System.out.println("alPeripherals object is null");
        }

        SmartHomeCollector smCOllector = SmartHomeCollector.getHomeCollectorObj(100);
        for (int i = 0; i < smCOllector.getAlPeripherals().size(); i++) {
            for (int j = 0; j < alPeripherals.size(); j++) {
                if (smCOllector.getAlPeripherals().get(i).getPer_id() == alPeripherals.get(j).getPer_id()) {
                    smCOllector.getAlPeripherals().set(i, alPeripherals.get(j));
                    break;
                }
            }
        }
        System.out.println("User modifying Peripherals list details");

        ResponseStatus status = new ResponseStatus();
        status.setResponse(ResponseStatus.RESPONSE.e_PERIPHERALS_LIST_UPDATED_SUCCESSFULLY);
        return new ResponseEntity<ResponseStatus>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "/get_water_level_peripherals", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Peripheral>> getWaterLevelPeripherals(@RequestBody House house) {
        if (house == null) {
            System.out.println("house object is null, cant Work, error condition");
        }
        //find house, authenticate user.
        ArrayList<Peripheral> alWaterLevelPeripherals = new ArrayList<>();

        SmartHomeCollector homeCollector = SmartHomeCollector.getHomeCollectorObj(house.getOwner_id());

        for (int j = 0; j < homeCollector.getAlPeripherals().size(); j++) {
            Peripheral per = homeCollector.getAlPeripherals().get(j);
            if (per.getPer_type() == Peripheral.PERIPHERAL_TYPE.UNDERGROUND_WATER_TANK)
                alWaterLevelPeripherals.add(per);
            else if (per.getPer_type() == Peripheral.PERIPHERAL_TYPE.TERRES_WATER_TANK)
                alWaterLevelPeripherals.add(per);
        }

        System.out.println("User trying to get house Water level peripherals details");

        return new ResponseEntity<ArrayList<Peripheral>>(alWaterLevelPeripherals, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_room", method = RequestMethod.POST)
    public ResponseEntity<ResponseStatus> updateRoom(@RequestBody Room room) {
        if (room == null) {
            System.out.println("room object is null, cant Work, error condition");
        }
        for (int i = 0; i < SmartHomeCollector.getHomeCollectorObj(111).getAlRooms().size(); i++) {
            if (room.getRoom_id() == SmartHomeCollector.getHomeCollectorObj(111).getAlRooms().get(i).getRoom_id())
                SmartHomeCollector.getHomeCollectorObj(111).getAlRooms().set(i, room);
        }

        System.out.println("User trying to modify room details");

        ResponseStatus status = new ResponseStatus();
        status.setResponse(ResponseStatus.RESPONSE.e_ROOM_INFORMATION_UPDATED_SUCCESSFULLY);
        return new ResponseEntity<ResponseStatus>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "/add_new_room", method = RequestMethod.POST)
    public ResponseEntity<Room> addNewRoom(@RequestBody Room room) {
        if (room == null) {
            System.out.println("room object is null, cant Work, error condition");
        }
        SmartHomeCollector.getHomeCollectorObj(111).getAlRooms().add(room);

        room.setRoom_id((int) counter.incrementAndGet() + 100);
        System.out.println("User is Adding new room :: " + room);
        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_peripheral_status", method = RequestMethod.POST)
    public ResponseEntity<Peripheral> updatePeripheralStatus(@RequestBody @Valid @NotNull Peripheral peripheral) {

        if (peripheral.getPer_type() == Peripheral.PERIPHERAL_TYPE.MAIN_SWITCH) {
            System.out.println("Room object is not important, switching MAIN Switch");
        }
        System.out.println("User trying to update peripheral details :: " + peripheral);

        return new ResponseEntity<Peripheral>(peripheral, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove_user_sh_access", method = RequestMethod.POST)
    public ResponseEntity<SHUser> removeUserAccess(@RequestBody @Valid @NotNull SHUser user) {

        ResponseStatus status = new ResponseStatus();
        System.out.println("Removing user from smart home ::" + user);
        //   SmartHomeCollector.getHomeCollectorObj(123).getAlUsers().remove(user);

        for (int i = 0; i < SmartHomeCollector.getHomeCollectorObj(123).getAlUsers().size(); i++) {
            if (SmartHomeCollector.getHomeCollectorObj(123).getAlUsers().get(i).getMobile_number().equals(user.getMobile_number())) {
                SmartHomeCollector.getHomeCollectorObj(123).getAlUsers().remove(i);
                break;
            }
        }

        System.out.println("Remainig users:: " + SmartHomeCollector.getHomeCollectorObj(123).getAlUsers());

        return new ResponseEntity<SHUser>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/add_user_sh_access", method = RequestMethod.POST)
    public ResponseEntity<SHUser> addUserAccess(@RequestBody @Valid @NotNull SHUser user) {

        System.out.println("Adding user from smart home ::" + user);
        SmartHomeCollector.getHomeCollectorObj(123).getAlUsers().add(user);

        System.out.println("All users:: " + SmartHomeCollector.getHomeCollectorObj(123).getAlUsers());

        return new ResponseEntity<SHUser>(user, HttpStatus.OK);
    }


    /*@RequestMapping(value = "/update_peripheral_status", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @ResponseBody
    public ResponseEntity<Peripheral> updatePeripheralStatus(@RequestPart("room") @Valid Room room,
                                                             @RequestPart("peripheral") @Valid @NotNull Peripheral peripheral) {

        if (peripheral.getPer_type() == Peripheral.PERIPHERAL_TYPE.MAIN_SWITCH) {
            System.out.println("Room object is not important, switching MAIN Switch");
        }

        System.out.println("User trying to update peripheral details :: " + peripheral);
        System.out.println("User trying to update room details :: " + room);
        return new ResponseEntity<Peripheral>(peripheral, HttpStatus.OK);
    }*/
}
