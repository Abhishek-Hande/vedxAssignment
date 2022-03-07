package com.vedx.platform.config;

public class EndPointConfig {
    public static final String VERSION_1 = "/api/v1";
    public static final String CUSTOMERSERVICE = "/customer";
    public static final String PRODUCTSERVISE = "/product";
    public static final String ORDERSERVICE = "/order";
    public static final String CREATE_CUSTOMER = "/createCustomer";
    public static final String CREATE_PRODUCT = "/createProduct";
    public static final String PLACE_ORDER = "{Customer_id}/placeOrder";
    public static final String UPDATE_ORDER_STATUS = "/{order_id}/updateStatus";
    public static final String FEATCH_ALL_ORDERS = "/orders";


    
}
