package com.example.sample;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @PostMapping("/updateValues")
    public String updateValues(@RequestBody ValuesRequest request) {
        List<Integer> values = request.getValues();
        // valuesを使用して必要な処理を行う
        System.out.println("Received values: " + values);
        return "Values received";
    }

    public static class ValuesRequest {
        private List<Integer> values;

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
    }
}

