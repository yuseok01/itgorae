package com.a508.wms.productdetail.dto;

import com.a508.wms.util.constant.ProductStorageTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProductDetailRequestDto {

    private int originalPrice;
    private int sellingPrice;
    private Long barcode;
    private ProductStorageTypeEnum productStorageTypeEnum;
    private Long size;
    private Long unit;
    private String name;
    private Long businessId;
}
