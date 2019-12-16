package com.company.tables;

import com.company.beans.OneItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsManagerTest {

    @Test
    public void getRow() {

        OneItem bean = new OneItem();
        bean.setId(1);


        assertEquals(1, bean.getId() );
    }
}