package com.xworkz.Iapp.controller;

import com.xworkz.Iapp.constants.IssueCode;
import com.xworkz.Iapp.dto.MemberDTO;
import com.xworkz.Iapp.dto.TeamDTO;
import com.xworkz.Iapp.service.MemberService;
import com.xworkz.Iapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class MemberController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;


    @GetMapping("addMemberPage")
    public ModelAndView addMemberPage(@RequestParam int teamId, ModelAndView model) {

        Optional<TeamDTO> teamOpt = teamService.getTeamById(teamId);
        if (!teamOpt.isPresent()) {
            model.setViewName("redirect:/viewTeamsPage");
            return model;
        }

        model.addObject("team", teamOpt.get());
        model.addObject("memberDTO", new MemberDTO());
        model.setViewName("AddMember");
        return model;
    }

    @PostMapping("addMember")
    public ModelAndView addMember(MemberDTO dto, ModelAndView model) {

        IssueCode code = memberService.addMember(dto);

        if (code == IssueCode.ALLOK) {
            model.setViewName("redirect:/viewTeamDetails?teamId=" + dto.getTeamId());
        } else {
            model.addObject("failureMsg", "Unable to add member");
            model.setViewName("AddMember");
        }
        return model;
    }


    @GetMapping("viewTeamDetails")
    public ModelAndView viewTeamDetails(@RequestParam int teamId, ModelAndView model) {

        Optional<TeamDTO> teamOpt = teamService.getTeamById(teamId);
        if (!teamOpt.isPresent()) {
            model.setViewName("ViewTeamsPage");
            return model;
        }

        model.addObject("team", teamOpt.get());
        model.addObject("members", memberService.getMembersByTeam(teamId));
        model.setViewName("ViewTeamDetails");
        return model;
    }




    @GetMapping("editMemberPage")
    public ModelAndView editMemberPage(@RequestParam int memberId, ModelAndView model) {

        Optional<MemberDTO> memberOpt = memberService.getMemberById(memberId);
        if (!memberOpt.isPresent()) {
            model.setViewName("ViewTeams");
            return model;
        }

        MemberDTO member = memberOpt.get();

        Optional<TeamDTO> teamOpt = teamService.getTeamById(member.getTeamId());
        if (!teamOpt.isPresent()) {
            model.setViewName("ViewTeams");
            return model;
        }

        model.addObject("member", member);
        model.addObject("team", teamOpt.get());
        model.setViewName("EditMemberPage");
        return model;
    }


    @PostMapping("updateMember")
    public ModelAndView updateMember(MemberDTO dto, ModelAndView model) {


        IssueCode issueCode = memberService.updateMember(dto);

        switch (issueCode) {

            case ALLOK:
                model.addObject("successMsg", "Member updated successfully");
                break;

            case INVALIDINPUT:
                model.addObject("failureMsg", "Invalid member details");
                break;

            case DBERROR:
                model.addObject("failureMsg", "Unable to update member");
                break;

            default:
                model.addObject("failureMsg", "Something went wrong");
        }

        Optional<TeamDTO> teamOpt = teamService.getTeamById(dto.getTeamId());
        if (!teamOpt.isPresent()) {
            model.addObject("failureMsg", "Team not found");
            model.setViewName("ViewTeams");
            return model;
        }
        model.addObject("team", teamOpt.get());


        model.addObject("members", memberService.getMembersByTeam(dto.getTeamId()));

        model.setViewName("ViewTeamDetails");
        return model;
    }


    @PostMapping("deleteMember")
    public ModelAndView deleteMember(@RequestParam int memberId, @RequestParam int teamId, ModelAndView model) {

        IssueCode issueCode = memberService.deleteMember(memberId);

        switch (issueCode) {

            case ALLOK:
                model.addObject("successMsg", "Member deleted successfully");
                break;

            case INVALIDINPUT:
                model.addObject("failureMsg", "Invalid member id");
                break;

            case DBERROR:
                model.addObject("failureMsg", "Unable to delete member");
                break;

            default:
                model.addObject("failureMsg", "Something went wrong");
        }

        Optional<TeamDTO> teamOpt = teamService.getTeamById(teamId);
        if (!teamOpt.isPresent()) {
            model.addObject("failureMsg", "Team not found");
            model.setViewName("ViewTeams");
            return model;
        }
        model.addObject("team", teamOpt.get());

        model.addObject("members", memberService.getMembersByTeam(teamId));

        model.setViewName("ViewTeamDetails");
        return model;
    }


}
