package com.northwind.model;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorderLeve;
    private boolean discontinued;

    public Product(int productId, String productName, int supplierId, int categoryId, String quantityPerUnit, double unitPrice, int unitsInStock, int unitsOnOrder, int reorderLeve, boolean discontinued) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLeve = reorderLeve;
        this.discontinued = discontinued;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLeve() {
        return reorderLeve;
    }

    public void setReorderLeve(int reorderLeve) {
        this.reorderLeve = reorderLeve;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return "Product " +
                "productId = " + productId + '\n' +
                " productName = '" + productName + '\n' +
                " supplierId = " + supplierId + '\n' +
                " categoryId = " + categoryId + '\n' +
                " quantityPerUnit = '" + quantityPerUnit + '\n' +
                " unitPrice = " + unitPrice + '\n' +
                " unitsInStock = " + unitsInStock + '\n' +
                " unitsOnOrder = " + unitsOnOrder + '\n' +
                " reorderLeve = " + reorderLeve + '\n' +
                " discontinued = " + discontinued + '\n' + '\n';
    }
}
