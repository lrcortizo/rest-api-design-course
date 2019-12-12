package io.trabe.teaching.rest.controller.rest.examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jooq.lambda.Seq;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/examples/1")
public class NumbersApiController {

    @ResponseBody
    @RequestMapping(value = "/numbers", produces = "application/json")
    public ResponseEntity<List<String>> getNumbers() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(100, TimeUnit.SECONDS))
                .body(Seq.of("Uno", "Dos", "Tres", "Cuatro", "Cinco").toList());
    }

    @ResponseBody
    @RequestMapping(value = "/numbers/xml", produces = "application/xml")
    public List<String> getNumbersXML() {
        return Seq.of("Uno", "Dos", "Tres", "Cuatro", "Cinco").toList();
    }
}
