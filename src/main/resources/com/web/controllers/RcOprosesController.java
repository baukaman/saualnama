package com.web.controllers;

import com.rc.saualnama.opros.Opros;
import com.rc.saualnama.opros.manager.OprosManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Bauyrzhan
 * Date: 4/10/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/opros")
public class RcOprosesController {

    @Qualifier("oprosManager")
    @Autowired
    private OprosManager oprosManager;

    @RequestMapping(method = RequestMethod.GET,value="/take/{userId}")
    public String showOpros(ModelMap model,@PathVariable long userId){

        Opros opros = getOprosManager().getOprosById(userId);
        model.addAttribute("sz",opros);

        return "opros";
    }

    public OprosManager getOprosManager() {
        return oprosManager;
    }
}
