package com.thoughtworks.domain.eshop.service;

import com.thoughtworks.domain.eshop.Price;
import com.thoughtworks.domain.eshop.constants.ProductName;

import java.util.HashMap;

import static com.thoughtworks.domain.eshop.constants.ProductName.I_PAD_PRO;

public class CompetitorData {
    private static final HashMap<ProductName, Price> priceList = new HashMap<ProductName, Price>() {{
        put(I_PAD_PRO, new Price(10.0));
    }};

    public static float getDiscountPrice(ProductName productName) {
        return (float) (CompetitorData.priceList.get(productName).getAmount() * 0.1);
    }
}
