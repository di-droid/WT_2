package com.Didroid;

import java.util.List;

/**
 * The type Catalog.
 */
public class Catalog {
    private List<IProducts> productsList;

    /**
     * Instantiates a new Catalog.
     *
     * @param productsList the products list
     */
    public Catalog(List<IProducts> productsList) {
        this.productsList = productsList;
    }

    /**
     * Gets products list.
     *
     * @return the products list
     */
    public List<IProducts> getProductsList() {
        return productsList;
    }
}
