package lyricWallGroup.spring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lyricWallGroup.spring.app.form.InsertForm;
import lyricWallGroup.spring.app.form.SearchForm;
import lyricWallGroup.spring.entity.Lyric;
import lyricWallGroup.spring.service.LyricService;

@Controller
@RequestMapping("/lyric")
public class LyricController {
    private final LyricService lyricService;

    @Autowired
    public LyricController(LyricService lyricService) {
        this.lyricService = lyricService;
    }

    @GetMapping("/form")
    public String form(Model model, @ModelAttribute("insertCompleteMessage") String message){
        model.addAttribute("title", "artist name");
        return "form.html";
    }

    @GetMapping("/select")
    public String select(@Validated SearchForm searchForm, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("title", "Error Page");
            return "form.html";
        }
        List<Lyric> list = lyricService.getSongs(searchForm.getArtistName());
        if(list.size()!=0){
            model.addAttribute("lyricList", list);
        }else{
            model.addAttribute("noResultMessage", "該当アーティストの曲が登録されていない");
        }
        return "list.html";
    }

    @PostMapping("/insert")
    public String insert(@Validated InsertForm insertForm, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            model.addAttribute("title", "Error Page");
            return "form.html";
        }
        // まずは入力フォームは一つ。DAOはリスト形式のため、要素が1つのリストにする
        List<Lyric> list = convertInsertForm(insertForm);
        // TODO エラーがあった場合の処理を書くこと
        lyricService.insertSongs(list);
        redirectAttributes.addFlashAttribute("insertCompleteMessage", "insert complete");
        return "redirect:form";
    }

    @ModelAttribute
    SearchForm setSearchForm(){
        return new SearchForm();
    }    

    @ModelAttribute
    InsertForm setInsertForm(){
        return new InsertForm();
    }

    public static List<Lyric> convertInsertForm(InsertForm insertForm){
        List<Lyric> list = new ArrayList<>();
        Lyric lyric = new Lyric();
        lyric.setArtist(insertForm.getArtistName());
        lyric.setTitle(insertForm.getTitle());
        lyric.setWords_writer(insertForm.getWordsWriter());
        lyric.setMusic_composer(insertForm.getMusicComposer());
        lyric.setLyric(insertForm.getLyric());
        lyric.setUrl(insertForm.getUrl());
        list.add(lyric);
        return list;
    }

}
