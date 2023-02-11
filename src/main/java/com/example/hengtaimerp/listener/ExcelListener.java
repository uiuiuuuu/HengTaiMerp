package com.example.hengtaimerp.listener;



import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {
    //可以通过实例获取该值
    private List<Object> data = new ArrayList<Object>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        data.add(o);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(o);//根据自己业务做处理
    }

    private void doSomething(Object object) {
        //1、入库调用接口
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // data.clear();//解析结束销毁不用的资源
    }
}
