package ra.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ra.model.dto.FeedbackDto;
import ra.model.entity.Feedback;
import ra.model.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping
    public String home(Model model, Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber(), 1,Sort.unsorted());
        Page<Feedback> feedbacks = feedbackService.findAll(pageable);
        model.addAttribute("list",feedbacks);
        model.addAttribute("form",new FeedbackDto());
        return "home";
    }

    @PostMapping()
    public String publish (@ModelAttribute FeedbackDto feedbackDto){
        feedbackService.save(feedbackDto);
        return "redirect:/";
    }
    @GetMapping("{id}")
    public String like (@PathVariable Long id){
        feedbackService.like(id);
        return "redirect:/";
    }


}