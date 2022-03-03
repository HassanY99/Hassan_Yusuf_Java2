package com.company.MonthAndMathService.Controller;

import com.company.MonthAndMathService.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class MathSolutionController {


    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution sumOfTwoOperands(@RequestBody @Valid MathSolution mathSolution) {

        mathSolution.setOperation("add");
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());

        return mathSolution;

    }

    @PostMapping("/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution subtractTheTwoOperands(@RequestBody @Valid MathSolution mathSolution) {
        mathSolution.setOperation("subtract");
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());

        return mathSolution;
    }

    @PostMapping("/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution multiplyTheTwoOperands(@RequestBody @Valid MathSolution mathSolution) {
        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());

        return mathSolution;
    }


    @PostMapping("/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution divideTheTwoOperands(@RequestBody @Valid MathSolution mathSolution) {
        mathSolution.setOperation("divide");
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());


        return mathSolution;
    }
}
