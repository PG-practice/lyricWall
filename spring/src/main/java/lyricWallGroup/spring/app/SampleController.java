package lyricWallGroup.spring.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lyricWallGroup.spring.app.form.SearchForm;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/form")
    public String form(SearchForm searchForm, Model model, @ModelAttribute("redirectTitle") String title){
        model.addAttribute("title", "artist name");
        return "form.html";
    }

    @PostMapping("/form")
    public String formArtist(@Validated SearchForm searchForm, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            model.addAttribute("title", "error page");
            return "form";
        }
        // model.addAttribute("title", "success page\n You select " + searchForm.getArtistName());
        // return "form";
        redirectAttributes.addFlashAttribute("redirectTitle", "success page\n You select " + searchForm.getArtistName());
        return "redirect:form";

    }
}