package service.impl;

import enums.Measure;
import enums.ProductCategory;
import models.products.Sugar;
import models.products.Tea;

public class Operationlmpl {

    Sugar sugar = new Sugar("Sugar", 124, Measure.Kg, ProductCategory.SUGAR );
    Sugar sugar2 = new Sugar("Sugar2", 124, Measure.Pc, ProductCategory.SUGAR );
}
