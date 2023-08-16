package com.multicampus.basic.controller;

import com.multicampus.basic.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller  // 스프링mvc에서 컨트롤러 역할, 스프링의 빈(Bean)으로 등록 처리하겠다.
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(){
        log.info("hello~");
    }

    @GetMapping("/ex1")         //http://localhost:8090/ex1?name=AAA&age=23
    public void ex1(String name, int age){
        log.info("ex1....");
        log.info("name : " + name);
        log.info("age : " + age);

    }

    @GetMapping("/ex2")        //http://localhost:8090/ex2
    public void ex2(@RequestParam(name = "name", defaultValue = "CCC") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age){

        log.info("ex2.....");
        log.info("name : "+ name);
        log.info("age : "+ age);
    }

    //LocalDateFormatter 참조
    @GetMapping("/ex3")         //http://localhost:8090/ex3?dueDate=2023-01-01
    public void ex3(LocalDate dueDate){
        log.info("ex3.....");
        log.info(dueDate);
    }

    @RequestMapping(value = "/ex4", method = RequestMethod.GET)
    public void ex4(Model model){   //return 타입이 void 이면.. 해당 URL의 경로를 그대로 jsp 파일 이름으로 사용하게 됨
        log.info("ex4.....");
        //request.setAttribute와 동일
        model.addAttribute("message", "Hello Spring~");


    }

    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto")TodoDTO todoDTO, Model model){
        log.info("ex4_1........");
        //model.addAttribute("message","Hello Spring project");
        log.info(todoDTO);
        model.addAttribute("message","Hello ex4_1()!");
    }

    @GetMapping("/ex5")             //http://localhost:8090/ex5
    public String  ex5(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name", "ABCD"); 
        redirectAttributes.addAttribute("age", "25");
        // 실행 결과 주소창에  http://localhost:8090/ex6?name=ABCD&age=25 이런식으로 나옴
        redirectAttributes.addFlashAttribute("result","success");   //일회성, 새로고침시 사리짐
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){}

}
