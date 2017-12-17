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
@RequestMapping("/smart_home/device")
public class SmartHomeHWDeviceController {


    @RequestMapping(value = "/get_updates", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<PhyPeripheral>> getUpdates(@RequestBody Device device) {

        //Check flag has_update == true and if it is true then search peripherals table for particular updates.

        System.out.println("ESP is trying to get peripherals updates :: " + device);
        //if(device is not registered already then register it after authenticating. )
        //if user requested for some updates then get create one peripheral object and add it as a 1st element in arraylist.
        ArrayList<PhyPeripheral> alPeripherals = new ArrayList<>();
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        alPeripherals.add(new PhyPeripheral());
        // set all thr has_updates flags to false;

        return new ResponseEntity<ArrayList<PhyPeripheral>>(alPeripherals, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_peripherals_list", method = RequestMethod.POST)
    public ResponseEntity<String> updatePerList(@RequestBody DevicePeripheralList devicePeripheralList) {

        System.out.println("ESP is trying to update peripherals List ::" + devicePeripheralList);
        //if(device is not registered already then register it after authenticating. )
        //if user requested for some updates then get create one peripheral object and add it as a 1st element in arraylist.

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    @RequestMapping(value = "/register_peripheral", method = RequestMethod.POST)
    public ResponseEntity<Integer> registerPeripheral(@RequestBody Device device) {

        System.out.println("ESP is trying to register_peripheral ::Parent Device:: " + device);
        int regId = 10000002; // 8 digit id
        //if(device is not registered already then register it after authenticating. )
        //if user requested for some updates then get create one peripheral object and add it as a 1st element in arraylist.


        return new ResponseEntity<Integer>(regId, HttpStatus.OK);

    }

    @RequestMapping(value = "/update_ip", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<PhyPeripheral>> updateDevIP(@RequestBody Device device) {

        System.out.println("ESP is trying to update IP details of :: " + device);

        //if(device is not registered already then register it after authenticating. )
//if user requested for some updates then get create one peripheral object and add it as a 1st element in arraylist.
        ArrayList<PhyPeripheral> alPeripherals = new ArrayList<>();
        alPeripherals.add(new PhyPeripheral());
        return new ResponseEntity<ArrayList<PhyPeripheral>>(alPeripherals, HttpStatus.OK);
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
