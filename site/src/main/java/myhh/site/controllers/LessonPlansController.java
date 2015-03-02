package myhh.site.controllers;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Controller
public class LessonPlansController {
    @RequestMapping(value= "/lesson-plans", produces="application/json")
    @ResponseBody
    public List<Map<String, String>> getLessonPlans() {
        return ImmutableList.<Map<String, String>>builder()
                .add(of("title", "First Lesson"))
                .add(of("title", "Second Lesson"))
                .add(of("title", "Third Lesson"))
                .build();
    }
}
