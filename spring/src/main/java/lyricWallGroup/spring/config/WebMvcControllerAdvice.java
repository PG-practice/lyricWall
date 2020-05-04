package lyricWallGroup.spring.config;

import org.postgresql.util.PSQLException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import lyricWallGroup.spring.app.form.InsertForm;
import lyricWallGroup.spring.app.form.SearchForm;



/**
 * 全てのControllerで共通処理を定義
 */
@ControllerAdvice
public class WebMvcControllerAdvice {

	/*
	 * This method changes empty character to null
	 * こちらのメソッドを用意しておくと送信された空文字はnullに変換されます
	 */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ExceptionHandler(PSQLException.class)
    public String sqlException(PSQLException e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("insertForm", new InsertForm());
        return "form.html";
    }
   
}