package frc.robot.subsystems;

import java.util.List;

import edu.wpi.first.wpilibj.Solenoid;


public class Cannon {

    private List<Solenoid> solenoids;
    private int delay;

    /**
     * Initializes a controller with a list of solenoids and a delay in ms
     * 
     * @param solenoidsToControl a list of controllable solenoids
     * @param delay              the delay between opening and closing a solenoid,
     *                           in milliseconds
     */
    public Cannon(List<Solenoid> solenoidsToControl, int delay) {
        this.solenoids = solenoidsToControl;
        this.delay = delay;
    }

    /**
     * Initializes a controller with a list of solenoids and a default delay of 400
     * ms
     * 
     * @param solenoidsToControl a list of controllable solenoids
     */
    public Cannon(List<Solenoid> solenoidsToControl) {
        this(solenoidsToControl, 400);
    }

    /**
     * Fires a solenoid with an index passed by parameter
     * 
     * @param index the index of the solenoid to fire
     */
    public void fireSolenoid(int index) {
        Solenoid s = this.solenoids.get(index);
        s.setPulseDuration(delay / 1000.0);
        s.startPulse();
    }

    /**
     * Fires all solenoids associated with this cannon controller
     */
    public void fireAllSolenoids() {
        for (int i = 0; i < solenoids.size(); i++) {
            this.fireSolenoid(i);
        }
    }
    
}
