package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ) {

        model.addAttribute( "name", name );

        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString( @RequestParam("name") String name ) {
        return "hello " + name;
    }

    // api 방식은 객체를 반환해 준다.
    @GetMapping("hello-api")
    @ResponseBody // default 값은 JSON이다.
    public Hello helloApi( @RequestParam("name") String name ) {
        Hello hello = new Hello();

        hello.setName(name);
        hello.setAge( 15 );

        return hello;

    }

    static class Hello {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge( int age ) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName( String name ) {
            this.name = name;
        }
    }
}
