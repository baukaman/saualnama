package com.web.controllers;

/**
 * Created with IntelliJ IDEA.
 * User: Bauka
 * Date: 4/8/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */

import com.rc.saualnama.question.manager.QuestionManager;
import com.rc.saualnama.question.manager.QuestionManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

@Controller
@RequestMapping(value = "/questions")
public class RcQuestionsController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Qualifier("questionManager")
    @Autowired
    private QuestionManager questionManager;

    @RequestMapping(method = RequestMethod.GET, value="/aaa")
    public
    @ResponseBody  ModelAndView someName(){

        Long id = questionManager.addQuestion("emaaa");
        logger.info("question created with id"+id);
        return new ModelAndView("hello");
    }

    @RequestMapping(method = RequestMethod.GET, value="/bbb")
    public String printWelcome(ModelMap model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name=userDetails.getUsername();
         model.addAttribute("message","Yoppa hello "+name+" !!!");
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/ccc")
    public String printXenofob(ModelMap model){
        model.addAttribute("var","sdfd");
        return "xenofob";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String printText(){
        return "sdf";
    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }
}