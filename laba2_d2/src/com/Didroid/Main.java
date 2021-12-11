package com.Didroid;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Document doc = null;
        try{
            doc = BuildDocument();
        }   catch (Exception e){
            System.out.println("Open error: "+e.toString());
        }

        Node rootNode = doc.getFirstChild();
        NodeList catalogProducts = rootNode.getChildNodes();

        String typeTemp = "";
        String modelTemp = "";
        int priceTemp = 0;
        String currTemp = "";

        int powerTemp = 0;
        String powerAtrTemp = "";
        int sizeCapacityTemp = 0;
        String sizeCapacityAtrTemp = "";

        boolean freezerTemp = false;
        boolean noFrostTemp = false;
        int energyConsum = 0;
        String energyConsumAtrTemp = "";

        int specPowerGrillTemp = 0;
        String specPowerGrillAtrTemp = "";
        int specPowerWaveTemp = 0;
        String specPowerWaveAtrTemp = "";
        int specSizeCameraTemp = 0;
        String specSizeCameraAtrTemp = "";

        List<IProducts> productsList = new ArrayList<>();

        for (int i=0;i<catalogProducts.getLength();i++){
            if (catalogProducts.item(i).getNodeType()!=Node.ELEMENT_NODE){
                continue;
            }

            NodeList element = catalogProducts.item(i).getChildNodes();
            for (int j = 0; j < element.getLength();j++){
                if (element.item(j).getNodeType()!=Node.ELEMENT_NODE){
                    continue;
                }
                Node currentItem = element.item(j);
                switch (currentItem.getNodeName()) {
                    case "type": {
                        typeTemp = currentItem.getTextContent();
                        break;
                    }
                    case "model": {
                        modelTemp = currentItem.getTextContent();
                        break;
                    }
                    case "price": {
                        priceTemp = Integer.parseInt(currentItem.getTextContent());
                        currTemp = currentItem.getAttributes().getNamedItem("curr").getNodeValue();
                        break;
                    }
                    case "specif":{
                        NodeList currentItemSpecList = currentItem.getChildNodes();
                        for (int g = 0; g<currentItemSpecList.getLength();g++){
                            if (currentItemSpecList.item(g).getNodeType()!=Node.ELEMENT_NODE){
                                continue;
                            }
                            Node currentItemSpec = currentItemSpecList.item(g);
                            switch (currentItemSpec.getNodeName()){
                                case "power": {
                                    powerTemp = Integer.parseInt(currentItemSpec.getTextContent());
                                    powerAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                                case "sizeCapacity": {
                                    sizeCapacityTemp = Integer.parseInt(currentItemSpec.getTextContent());
                                    sizeCapacityAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                                case "freezer": {
                                    freezerTemp = Boolean.parseBoolean(currentItemSpec.getTextContent());
                                    break;
                                }
                                case "noFrost": {
                                    noFrostTemp = Boolean.parseBoolean(currentItemSpec.getTextContent());
                                    break;
                                }
                                case "energyConsum": {
                                    energyConsum = Integer.parseInt(currentItemSpec.getTextContent());
                                    energyConsumAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                                case "powerGrill": {
                                    specPowerGrillTemp = Integer.parseInt(currentItemSpec.getTextContent());
                                    specPowerGrillAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                                case "powerWave": {
                                    specPowerWaveTemp = Integer.parseInt(currentItemSpec.getTextContent());
                                    specPowerWaveAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                                case "sizeCamera": {
                                    specSizeCameraTemp = Integer.parseInt(currentItemSpec.getTextContent());
                                    specSizeCameraAtrTemp = currentItemSpec.getAttributes().getNamedItem("MS").getNodeValue();
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }

            switch (typeTemp){
                case "teapot":{
                    ProductTeapot pteapot = new ProductTeapot(typeTemp,modelTemp,priceTemp,currTemp,
                            sizeCapacityTemp,sizeCapacityAtrTemp,powerTemp,powerAtrTemp);
                    productsList.add(pteapot);
                    break;
                }
                case "fridge":{
                    ProductFridge pfridge = new ProductFridge(typeTemp,modelTemp,priceTemp,currTemp,
                            freezerTemp,noFrostTemp,energyConsum,energyConsumAtrTemp);
                    productsList.add(pfridge);
                    break;
                }
                case "microwave":{
                    ProductMicrowave pmicrowave = new ProductMicrowave(typeTemp,modelTemp,priceTemp,currTemp,
                            specPowerGrillTemp,specPowerGrillAtrTemp,specPowerWaveTemp,specPowerWaveAtrTemp,
                            specSizeCameraTemp,specSizeCameraAtrTemp);
                    productsList.add(pmicrowave);
                    break;
                }
            }

        }

        Catalog newCatalog = new Catalog(productsList);

        int minPrice=priceTemp;
        int minPrTemp;
        System.out.println("Catalog of techniques:");
        for (IProducts prod: newCatalog.getProductsList()){
            System.out.println("Type of technique: " + prod.getType());
            System.out.println("Model: " + prod.getModel());
            System.out.println("Price: "+prod.getPrice() + prod.getCurr());
            System.out.println(prod.getSpec());
            System.out.println();
            minPrTemp = prod.getPrice();
            if (minPrice>minPrTemp){
                minPrice = minPrTemp;
            }
        }

        System.out.println("What you want to search? ");
        System.out.println("1. write '1' to find minimal price");
        System.out.println("2. write '2' to find your type of product");
        Scanner in = new Scanner(System.in);
        int chooseDo = in.nextInt();

        if (chooseDo == 2) {
            System.out.println("What type of product you want?");
            String typeSearch = in.next();
            newCatalog.getProductsList().stream().filter(product -> product.getType().equals(typeSearch)
            ).forEach(product -> {
                System.out.println("Type of technique: " + product.getType());
                System.out.println("Model: " + product.getModel());
                System.out.println("Price: "+product.getPrice() + product.getCurr());
                System.out.println(product.getSpec());
                System.out.println();
            });
        } else {
            System.out.println("The product with minimal price is:");
            int priceSearch = minPrice;
            newCatalog.getProductsList().stream().filter(product -> product.getPrice() == priceSearch
            ).forEach(product -> {
                System.out.println("Type of technique: " + product.getType());
                System.out.println("Model: " + product.getModel());
                System.out.println("Price: "+product.getPrice() + product.getCurr());
                System.out.println(product.getSpec());
            });
        }

    }

    private static Document BuildDocument() throws Exception{
        File file = new File("Catalog.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
