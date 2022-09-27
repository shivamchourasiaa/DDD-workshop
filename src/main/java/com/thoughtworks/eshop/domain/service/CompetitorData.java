package com.thoughtworks.eshop.domain.service;

import com.thoughtworks.eshop.domain.Price;
import com.thoughtworks.eshop.domain.constants.ProductName;

import java.util.HashMap;

import static com.thoughtworks.eshop.domain.constants.ProductName.I_PAD_PRO;

public class CompetitorData {
    private static final HashMap<ProductName, Price> priceList = new HashMap<ProductName, Price>() {{
        put(I_PAD_PRO, new Price(10.0));
    }};

    public static float getDiscountPrice(ProductName productName) {
        return (float) (CompetitorData.priceList.get(productName).getAmount() * 0.1);
    }
}
