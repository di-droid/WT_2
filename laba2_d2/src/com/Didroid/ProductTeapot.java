package com.Didroid;

/**
 * The type Product teapot.
 */
public class ProductTeapot implements IProducts{

    private String type;
    private String model;
    private int price;
    private String curr;

    private int specSize;
    private String specSizeAtr;
    private int specPower;
    private String specPowerAtr;

    /**
     * Instantiates a new Product teapot.
     *
     * @param type         the type
     * @param model        the model
     * @param price        the price
     * @param curr         the curr
     * @param specSize     the spec size
     * @param specSizeAtr  the spec size atr
     * @param specPower    the spec power
     * @param specPowerAtr the spec power atr
     */
    public ProductTeapot(String type, String model, int price, String curr, int specSize,
                         String specSizeAtr, int specPower, String specPowerAtr) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.curr = curr;
        this.specSize = specSize;
        this.specSizeAtr = specSizeAtr;
        this.specPower = specPower;
        this.specPowerAtr = specPowerAtr;
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
        return "Size="+specSize+specSizeAtr+", Power="+specPower+specPowerAtr;
    }
}
