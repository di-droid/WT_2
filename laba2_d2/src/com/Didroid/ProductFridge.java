package com.Didroid;

/**
 * The type Product fridge.
 */
public class ProductFridge implements IProducts{

    private String type;
    private String model;
    private int price;
    private String curr;

    private boolean freezer;
    private boolean noFrost;
    private int specEnergyConsum;
    private String specEnergyConsumAtr;

    /**
     * Instantiates a new Product fridge.
     *
     * @param type                the type
     * @param model               the model
     * @param price               the price
     * @param curr                the curr
     * @param freezer             the freezer
     * @param noFrost             the no frost
     * @param specEnergyConsum    the spec energy consum
     * @param specEnergyConsumAtr the spec energy consum atr
     */
    public ProductFridge(String type, String model, int price, String curr, boolean freezer,
                         boolean noFrost, int specEnergyConsum, String specEnergyConsumAtr) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.curr = curr;
        this.freezer = freezer;
        this.noFrost = noFrost;
        this.specEnergyConsum = specEnergyConsum;
        this.specEnergyConsumAtr = specEnergyConsumAtr;
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
        return "Freezer="+freezer+", noFrost="+noFrost+", " +
                "energy consumption=" + specEnergyConsum+specEnergyConsumAtr;
    }
}
