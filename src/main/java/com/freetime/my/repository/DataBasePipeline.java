package com.freetime.my.repository;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Iterator;
import java.util.Map;

/**
 * <b>Description:</b><br>
 *
 * @author Eric.
 * @version 1.0
 *          <b>ProjectName:</b> my
 *          <br><b>PackageName:</b> com.freetime.my.repository
 *          <br><b>Date:</b> 2018/3/13 16:46
 */
public class DataBasePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        Iterator var3 = resultItems.getAll().entrySet().iterator();

        while (var3.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) var3.next();
            System.out.println((String) entry.getKey() + ":\t" + entry.getValue());
        }

    }
}
