package hello.hello_spring.controller;

@controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute(attributeName: "data", attributeValue: "hello!!");
        return "hello";
    }
}
