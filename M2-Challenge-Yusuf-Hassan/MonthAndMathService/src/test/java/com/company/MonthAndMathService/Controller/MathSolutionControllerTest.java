package com.company.MonthAndMathService.Controller;

import com.company.MonthAndMathService.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void shouldReturnSumOfTwoOperands() throws Exception {

        MathSolution inputMathSolution = new MathSolution();
        inputMathSolution.setOperand1(20);
        inputMathSolution.setOperand2(30);


        // Convert Java Object to JSON.
        String inputJson = objectMapper.writeValueAsString(inputMathSolution);

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(20);
        outputMathSolution.setOperand2(30);
        outputMathSolution.setOperation("add");
        outputMathSolution.setAnswer(outputMathSolution.getOperand1() + outputMathSolution.getOperand2());

        String outputJson = objectMapper.writeValueAsString(outputMathSolution);

        // ACT
        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBodyAddition() throws Exception {


        Map<String, String> input = new HashMap<>();
        input.put("operand1", "8");
        input.put("operand2", "This is string, not a number.");

        String inputJson = objectMapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }

    @Test
    public void shouldReturnDifferenceOfTwoOperands() throws Exception {

        MathSolution inputMathSolution = new MathSolution();
        inputMathSolution.setOperand1(50);
        inputMathSolution.setOperand2(30);

        String inputJson = objectMapper.writeValueAsString(inputMathSolution);

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(50);
        outputMathSolution.setOperand2(30);
        outputMathSolution.setOperation("subtract");
        outputMathSolution.setAnswer(outputMathSolution.getOperand1() - outputMathSolution.getOperand2());

        String outputJson = objectMapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBodySubtraction() throws Exception {

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "10");
        input.put("operand2", "This is string, not a number.");


        String inputJson = objectMapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/subtract")
                                .content(String.valueOf(inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }

    @Test
    public void shouldReturnAnAnswerWhenTwoOperandsAreMultiplied() throws Exception {

        MathSolution inputMathSolution = new MathSolution();
        inputMathSolution.setOperand1(20);
        inputMathSolution.setOperand2(2);

        String inputJson = objectMapper.writeValueAsString(inputMathSolution);

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(20);
        outputMathSolution.setOperand2(2);
        outputMathSolution.setOperation("multiply");
        outputMathSolution.setAnswer(outputMathSolution.getOperand1() * outputMathSolution.getOperand2());

        String outputJson = objectMapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBodyMultiplication() throws Exception {

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "5");
        input.put("operand2", "This is string, not a number.");


        String inputJson = objectMapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/multiply")
                                .content(String.valueOf(inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }

    @Test
    public void shouldReturnAnAnswerWhenTwoOperandsAreDivided() throws Exception {

        MathSolution inputMathSolution = new MathSolution();
        inputMathSolution.setOperand1(60);
        inputMathSolution.setOperand2(3);

        String inputJson = objectMapper.writeValueAsString(inputMathSolution);

        MathSolution outputMathSolution = new MathSolution();
        outputMathSolution.setOperand1(60);
        outputMathSolution.setOperand2(3);
        outputMathSolution.setOperation("divide");
        outputMathSolution.setAnswer(outputMathSolution.getOperand1() / outputMathSolution.getOperand2());

        String outputJson = objectMapper.writeValueAsString(outputMathSolution);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBodyDivision() throws Exception {

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "85");
        input.put("operand2", "This is string, not a number.");


        String inputJson = objectMapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/divide")
                                .content(String.valueOf(inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }

    @Test
    public void shouldReturn422StatusCodeWhenDivisionByZero() throws Exception {

        MathSolution inputMathSolution = new MathSolution();
        inputMathSolution.setOperand1(15);
        inputMathSolution.setOperand2(0);


        String inputJson = objectMapper.writeValueAsString(inputMathSolution);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }

}