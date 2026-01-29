package com.xworkz.Iapp.controller;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.TeamDTO;
import com.xworkz.Iapp.dto.UserDTO;
import com.xworkz.Iapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping("addTeamPage")
    public String addTeamPage() {
        return "AddTeam";
    }


    @PostMapping("addTeam")
    public ModelAndView addTeam(@Valid TeamDTO teamDTO, BindingResult bindingResult, ModelAndView model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addObject("dto", teamDTO);
            model.setViewName("AddTeam");
            return model;
        }

        UserDTO loggedInUser = (UserDTO) session.getAttribute("userInfo");
        if (loggedInUser == null) {
            model.setViewName("UserLogin");
            return model;
        }

        IssueCode issueCode = teamService.validateAndSave(teamDTO,loggedInUser);

        switch (issueCode) {
            case EMAILEXISTS:
                model.addObject("failureMsg", "Team email already exists");
                break;

            case DBERROR:
                model.addObject("failureMsg", "Something went wrong. Try again");
                break;

            case ALLOK:
                model.addObject("successMsg", "Team added successfully");
                break;

            default:
                model.addObject("failureMsg", "Unexpected error");
        }

        model.setViewName("AddTeam");
        return model;
    }



    @GetMapping("viewTeamsPage")
    public ModelAndView viewTeams(ModelAndView model) {

        List<TeamDTO> teams = teamService.getAllTeams();
        model.addObject("teams", teams);

        model.setViewName("ViewTeams");
        return model;
    }


    @GetMapping("editTeamPage")
    public ModelAndView editTeamPage(@RequestParam int id, ModelAndView model) {

        Optional<TeamDTO> team = teamService.getTeamById(id);

        if (!team.isPresent()) {
            model.addObject("failureMsg", "Team not found");
            model.addObject("teams", teamService.getAllTeams());
            model.setViewName("ViewTeams");
            return model;
        }

        model.addObject("teamDTO", team.get());
        model.setViewName("EditTeamPage");
        return model;
    }


    @PostMapping("updateTeam")
    public ModelAndView updateTeam(TeamDTO teamDTO, ModelAndView model) {

        IssueCode issueCode = teamService.updateTeam(teamDTO);

        switch (issueCode) {
            case ALLOK:
                    model.addObject("successMsg", "Team updated successfully");
                    break;

            case INVALIDINPUT:
                    model.addObject("failureMsg", "Invalid input");
                    break;

            case EMAILNOTREGISTERED:
                    model.addObject("failureMsg", "Team not found");
                    break;

            case DBERROR:
                    model.addObject("failureMsg", "Unable to update team");
                    break;

            default:
                    model.addObject("failureMsg", "Something went wrong");
        }


        model.addObject("teams", teamService.getAllTeams());
        model.setViewName("ViewTeams");
        return model;
    }


    @GetMapping("deleteTeam")
    public ModelAndView deleteTeam(@RequestParam int id, ModelAndView model) {

        IssueCode issueCode = teamService.deleteTeam(id);

        switch (issueCode) {
            case ALLOK:
                    model.addObject("successMsg", "Team deleted successfully");
                    break;

            case INVALIDINPUT:
                    model.addObject("failureMsg", "Invalid team id");
                    break;

            case DBERROR:
                    model.addObject("failureMsg", "Unable to delete team");
                    break;

            default:
                    model.addObject("failureMsg", "Something went wrong");
        }

        model.addObject("teams", teamService.getAllTeams());
        model.setViewName("ViewTeams");
        return model;
    }
}


