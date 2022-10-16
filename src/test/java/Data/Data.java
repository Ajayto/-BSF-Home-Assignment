package Data;

import java.util.HashMap;

public class Data {
	public static enum productEnum {
		PRICE,
		QUANTITY,
		PRODUCT_NAME,
		SUB_TOTAL,
	}
	public static HashMap<productEnum,Object> productDetails=new HashMap<productEnum,Object>();
	public static HashMap<productEnum,Object> productOnCart=new HashMap<productEnum,Object>();

}
