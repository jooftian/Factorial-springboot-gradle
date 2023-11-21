package py.com.softshop.factorial.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.softshop.factorial.model.Factorial;
import py.com.softshop.factorial.service.FactorialService;

import java.util.List;

@RequestMapping("/test/api/v1/factorial")
@RestController
public class FactorialController {
    private static final Gson gson = new Gson();
    @Autowired
    FactorialService factorialService;

    private

    @GetMapping(value = "/get") ResponseEntity<Object> getFactorial(@RequestParam(required = false) Integer hasta) {
        try {
            List<Factorial> factorial = factorialService.getFactorial(hasta);

            return ResponseEntity.status(200).body(gson.toJson(factorial));

        } catch (Exception exception) {
            return ResponseEntity.status(400).body("Error: " + exception.getMessage());
        }

    }
}
