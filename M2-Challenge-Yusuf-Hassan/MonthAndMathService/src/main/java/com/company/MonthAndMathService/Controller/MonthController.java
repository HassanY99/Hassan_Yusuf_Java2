package com.company.MonthAndMathService.Controller;

import com.company.MonthAndMathService.exceptions.NotFoundException;
import com.company.MonthAndMathService.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MonthController {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
            ));

    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getNameAndNumberOfMonth(@PathVariable int monthNumber) {
        Month foundNumber = null;

        for(Month month : months) {
            if(month.getNumber() == monthNumber) {
                foundNumber = month;
                break;
            }
        }
        if(foundNumber == null) {
            throw new IllegalArgumentException("Please enter month number between 1 and 12 - month not found");
        } else {
            return foundNumber;
        }
    }

    @GetMapping("/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        int randomMonth = (int) Math.floor(Math.random() * months.size());
        return months.get(randomMonth);
    }
}
