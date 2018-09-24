package com.crm.test;

import com.crm.Utils.UploadUtil;
import org.junit.Test;

/**
 * @author LGCN
 */
public class uploadTest {

    @Test
    public void uniqnname(){
        String name = UploadUtil.uniqueFileName("极品家丁.txt");
        System.out.println(name);
    }

}
