package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

/**
 * Must use WS2812 LEDs
 * Connect data pin to PWM and create new instance using port
 * MUST be a PWM header on the roboRIO
 */
public class LEDLights {
    private final AddressableLED led;
    private final AddressableLEDBuffer ledBuffer;

    public LEDLights(int port, int lightCount) {
        led = new AddressableLED(port);
        ledBuffer = new AddressableLEDBuffer(lightCount);
        led.setLength(ledBuffer.getLength());

        // ledBuffer.setRGB()
        // ledBuffer.setHSV()
        // https://docs.wpilib.org/en/stable/docs/software/hardware-apis/misc/addressable-leds.html#using-hsv-values

        led.setData(ledBuffer);
        led.start();
    }

    // call in periodical
    private int rainbowFirstPixelHue = 0;
    public void rainbow() {
        // For every pixel
        for (var i = 0; i < ledBuffer.getLength(); i++) {
          // Calculate the hue - hue is easier for rainbows because the color
          // shape is a circle so only one value needs to precess
          final int hue = (rainbowFirstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
          // Set the value
          ledBuffer.setHSV(i, hue, 255, 128);
        }
        // Increase by to make the rainbow "move"
        rainbowFirstPixelHue += 3;
        // Check bounds
        rainbowFirstPixelHue %= 180;
    }
}
