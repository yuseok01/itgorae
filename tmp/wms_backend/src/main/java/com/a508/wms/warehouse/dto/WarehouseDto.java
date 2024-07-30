package com.a508.wms.warehouse.dto;


import com.a508.wms.location.dto.LocationDto;
import com.a508.wms.util.constant.FacilityTypeEnum;
import com.a508.wms.util.constant.ProductStorageTypeEnum;
import com.a508.wms.util.constant.StatusEnum;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WarehouseDto {

    private Long id;
    private Long businessId;
    private int size;
    private String name;
    private int rowCount;
    private int columnCount;
    private int priority;
    private FacilityTypeEnum facilityTypeEnum;
    private ProductStorageTypeEnum productStorageTypeEnum;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private StatusEnum statusEnum;
    private List<LocationDto> locations;
    private List<WallDto> walls;


}