package service;

import enums.ProductCategory;
import models.Receipt;
import service.impl.Operationlmpl;

public interface Operation {

    ProductCategory[] category();
}
