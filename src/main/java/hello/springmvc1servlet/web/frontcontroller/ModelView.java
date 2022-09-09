package hello.springmvc1servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


public class ModelView {

    private String viewName;
    private Map<String, Object> model = new HashMap<>(); // 모델 객체들 보관하는 저장소

    public ModelView(String viewName){
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
