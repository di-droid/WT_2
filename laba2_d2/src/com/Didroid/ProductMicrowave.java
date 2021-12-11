package com.Didroid;

/**
 * The type Product microwave.
 */
public class ProductMicrowave implements IProducts{

    private String type;
    private String model;
    private int price;
    private String curr;

    private int specPowerGrill;
    private String specPowerGrillAtr;
    private int specPowerWave;
    private String specPowerWaveAtr;
    private int specSizeCamera;
    private String specSizeCameraAtr;

    /**
     * Instantiates a new Product microwave.
     *
     * @param type              the type
     * @param model             the model
     * @param price             the price
     * @param curr              the curr
     * @param specPowerGrill    the spec power grill
     * @param specPowerGrillAtr the spec power grill atr
     * @param specPowerWave     the spec power wave
     * @param specPowerWaveAtr  the spec power wave atr
     * @param specSizeCamera    the spec size camera
     * @param specSizeCameraAtr the spec size camera atr
     */
    public ProductMicrowave(String type, String model, int price, String curr, int specPowerGrill,
                            String specPowerGrillAtr, int specPowerWave, String specPowerWaveAtr,
                            int specSizeCamera, String specSizeCameraAtr) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.curr = curr;
        this.specPowerGrill = specPowerGrill;
        this.specPowerGrillAtr = specPowerGrillAtr;
        this.specPowerWave = specPowerWave;
        this.specPowerWaveAtr = specPowerWaveAtr;
        this.specSizeCamera = specSizeCamera;
        this.specSizeCameraAtr = specSizeCameraAtr;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getCurr() {
        return curr;
    }

    @Override
    public String getSpec() {
        return "Power of grill="+specPowerGrill+specPowerGrillAtr+", " +
                "Power of waves="+specPowerWave+specPowerWaveAtr+", "+
                "Size of camera="+specSizeCamera+specSizeCameraAtr;
    }
}
