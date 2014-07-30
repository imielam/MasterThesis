package com.maciej.imiela.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maciej.imiela.entity.Participant;
import com.maciej.imiela.service.ParticipantService;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    private static final Logger logger = LoggerFactory
            .getLogger(ParticipantController.class);

    @RequestMapping(value = { "/detail/{id}" }, method = RequestMethod.GET)
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("participant", this.participantService.findOne(id));
        return "participant/detail";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("participant", this.participantService.findOne(id));
        return "participant/edit";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String save(Model model, @PathVariable int id,
            @Valid Participant participant, BindingResult bResult) {
        if (bResult.hasErrors()) {
            return "participant/edit";
        }
        participant.setId(id);
        this.participantService.save(participant);
        return "redirect:/participant/detail/" + participant.getId()
                + ".html?success=true";
    }

}
