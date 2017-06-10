package com.cqupt.text.InnerClass.controller;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        greenhouseControls.addEvent(greenhouseControls.new Bell(900));
        Event[] eventList = {greenhouseControls.new ThermostatNight(0),
                greenhouseControls.new LightOn(200),
                greenhouseControls.new LightOff(400),
                greenhouseControls.new WaterOn(600),
                greenhouseControls.new WaterOff(800),
                greenhouseControls.new ThermostatDay(1400)};
        greenhouseControls.addEvent(greenhouseControls
                .new Restart(2000, eventList));
        if (args.length == 1) {
            greenhouseControls.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])
                    )
            );
        }
        greenhouseControls.run();

    }
}
